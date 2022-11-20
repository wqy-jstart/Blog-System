package cn.tedu.blogsystem.filter;

import cn.tedu.blogsystem.pojo.vo.UserStandardVO;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "MyFilter",urlPatterns = {"/","/userDetail","/articleDetail","/createArticle"})
public class MyFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        //参数列表中变量进行了向上造型,这里需强转成指定的类型,以便调用合适的方法
        HttpServletRequest rt = (HttpServletRequest) request;
        HttpServletResponse re = (HttpServletResponse) response;
        //通过HttpServletRequest从请求对象中获取Session对象
        HttpSession session = rt.getSession();
        //获取Session中的用户对象,强转成UserVO类型
        UserStandardVO user = (UserStandardVO) session.getAttribute("userLoginDTO");
        if (user!=null){//登录了
            chain.doFilter(request, response);//放行
        }else {
            re.sendRedirect("/login");//通过HttpServletResponse类重定向到登录页面
        }
    }
}

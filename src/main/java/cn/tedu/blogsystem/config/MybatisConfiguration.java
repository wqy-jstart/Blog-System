package cn.tedu.blogsystem.config;

import cn.tedu.blogsystem.mybatis.InsertUpdateTimeInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 这是MyBatis的配置类
 *
 * @Author java@Wqy
 * @Version 0.0.1
 */
@Slf4j
@Configuration
@MapperScan("cn.tedu.blogsystem.mapper")
public class MybatisConfiguration {
    //测试配置是否加载成功,输出对应日志内容
    public MybatisConfiguration(){
        log.info("创建配置类对象:MybatisConfiguration");
    }

    @Autowired
    private List<SqlSessionFactory> sqlSessionFactoryList;

    // 此注解添加在方法上,表示此方法是Spring Bean的生命周期方法中的初始化方法
    // 会在创建对象,自动装配之后,自动执行,仅可拦截一条数据,批量时无效
    @PostConstruct
    public void addInterceptor(){
        log.debug("开始注册Mybatis拦截器");
        InsertUpdateTimeInterceptor interceptor = new InsertUpdateTimeInterceptor();// 创建插入修改时间的拦截器
        for (SqlSessionFactory sqlSessionFactory : sqlSessionFactoryList) {// 遍历sqlSession工厂集合
            sqlSessionFactory.getConfiguration().addInterceptor(interceptor);// 传入拦截器
        }

    }

}

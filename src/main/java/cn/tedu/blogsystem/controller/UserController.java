package cn.tedu.blogsystem.controller;

import cn.tedu.blogsystem.pojo.dto.UserLoginDTO;
import cn.tedu.blogsystem.pojo.dto.UserRegisterDTO;
import cn.tedu.blogsystem.pojo.dto.UserUpdateDTO;
import cn.tedu.blogsystem.pojo.vo.UserStandardVO;
import cn.tedu.blogsystem.service.IUserService;
import cn.tedu.blogsystem.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 控制器层
 * 接收用户的请求
 *
 * @Author java@Wqy
 * @Version 0.0.1
 */
@Api
@Slf4j
@Validated
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 处理用户注册的请求
     * @param userRegisterDTO 用户的注册信息
     * @return 返回JsonResult结果集
     */
    @ApiOperation("用户注册")
    @ApiOperationSupport(order = 100)
    @PostMapping("/register")
    public JsonResult<Void> register(UserRegisterDTO userRegisterDTO){
        log.debug("开始处理用户注册的请求!,参数{}",userRegisterDTO);
        userService.addNew(userRegisterDTO);
        return JsonResult.ok();
    }

    /**
     * 处理用户登录的请求
     * @param userLoginDTO 用户登录的信息
     * @return JsonResult结果集
     */
    @ApiOperation("用户登录")
    @ApiOperationSupport(order = 160)
    @PostMapping("/login")
    public JsonResult<Void> login(UserLoginDTO userLoginDTO){
        log.debug("开始处理用户登录的请求!,参数{}",userLoginDTO);
        userService.login(userLoginDTO);
        return JsonResult.ok();
    }

    /**
     * 根据用户id修改用户信息
     * @param id 用户id
     * @param userUpdateDTO 修改的信息
     * @return 结果集
     */
    @ApiOperation("根据id修改信息")
    @ApiOperationSupport(order = 200)
    @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "long")
    @PostMapping("/{id:[0-9]+}/update")
    public JsonResult<Void> update(@PathVariable Long id, UserUpdateDTO userUpdateDTO){
        log.debug("开始处理[根据id修改用户信息]的请求,id:{},参数:{}",id,userUpdateDTO);
        userService.update(id,userUpdateDTO);
        return JsonResult.ok();
    }

    /**
     * 根据用户id修改用户密码
     * @param id 用户id
     * @param userUpdateDTO 修改的信息
     * @return 结果集
     */
    @ApiOperation("根据id修改密码")
    @ApiOperationSupport(order = 210)
    @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "long")
    @PostMapping("/{id:[0-9]+}/updateToPassword")
    public JsonResult<Void> updateToPassword(@PathVariable Long id, UserUpdateDTO userUpdateDTO){
        log.debug("开始处理[根据id修改密码]的请求,id:{},参数:{}",id,userUpdateDTO);
        userService.updateToPassword(id,userUpdateDTO);
        return JsonResult.ok();
    }

    /**
     * 根据用户名查询用户详情信息
     * @param username 用户名
     * @return 返回结果集
     */
    @ApiOperation("根据用户名查询用户信息")
    @ApiOperationSupport(order = 500)
    @PostMapping("")
    public JsonResult<UserStandardVO> userDetail(String username){
        log.debug("开始处理根据用户名查询用户详情的请求!参数{}",username);
        UserStandardVO userStandardVO = userService.userDetail(username);
        return JsonResult.ok(userStandardVO);
    }

    /**
     * 根据id查询用户详情
     * @param id 用户id
     * @return 返回用户详情的VO类
     */
    @ApiOperation("根据id查询用户详情")
    @ApiOperationSupport(order = 510)
    @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "long")
    @GetMapping("/{id:[0-9]+}/delectById")
    public JsonResult<UserStandardVO> selectById(@PathVariable Long id){
        log.debug("开始处理[根据id查询用户详情]的请求,参数:{}",id);
        UserStandardVO userStandardVO = userService.userStandard(id);
        return JsonResult.ok(userStandardVO);
    }
}
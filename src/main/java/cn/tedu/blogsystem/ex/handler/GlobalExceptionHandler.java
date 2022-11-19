package cn.tedu.blogsystem.ex.handler;

import cn.tedu.blogsystem.ex.ServiceException;
import cn.tedu.blogsystem.web.JsonResult;
import cn.tedu.blogsystem.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;
import java.util.StringJoiner;

/**
 * 创建一个全局异常处理器
 *
 * @Author java@Wqy
 * @Version 0.0.1
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    public GlobalExceptionHandler(){
        log.debug("创建全局异常处理器对象：GlobalExceptionHandler");
    }

    /**
     * 自定义异常处理----已存在的异常
     * @param e 自定义的异常类
     * @return 返回JSON对象,该对象封装了状态信息和状态描述
     */
    @ExceptionHandler
    public JsonResult<Void> handlerServiceException(ServiceException e){
        log.debug("开始统一处理ServiceException----已经存在的异常");
        return JsonResult.fail(e);
    }

    /**
     * 自定义异常处理----检查不通过的异常
     * @param e BindException
     * @return  返回JSON对象,该对象封装了状态信息和状态描述
     */
    @ExceptionHandler
    public JsonResult<Void> handlerBingException(BindException e){
        log.debug("开始处理BindException----检查不通过的异常");
        //第二种方式"快速失败"(一次仅获取一次异常)
        String defaultMessage = e.getFieldError().getDefaultMessage();//Spring框架提供的API,直接获取某一个错误信息

        return JsonResult.fail(ServiceCode.ERR_BAD_REQUEST,defaultMessage);
    }

    /**
     * 自定义异常处理----未封装的请求参数异常
     * @param e ConstraintViolationException
     * @return  返回JSON对象,该对象封装了状态信息和状态描述
     */
    @ExceptionHandler
    public JsonResult<Void> handleConstViolationException(ConstraintViolationException e){
        log.debug("开始处理ConstraintViolationException----未封装的请求参数异常");
        StringJoiner stringJoiner = new StringJoiner(". ");
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        for (ConstraintViolation<?> constraintViolation : constraintViolations) {
            stringJoiner.add(constraintViolation.getMessage());
        }
        return JsonResult.fail(ServiceCode.ERR_BAD_REQUEST,stringJoiner.toString());
    }

    /**
     * 全局异常处理
     * @param e 全局的异常类
     * @return 返回异常处理反馈的信息
     */
//    @ExceptionHandler
//    public String handlerServiceException(Throwable e){
//        log.debug("这是一个Throwable异常,将统一处理");
//        return e.getMessage();
//    }
}

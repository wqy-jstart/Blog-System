package cn.tedu.blogsystem.controller;

import cn.tedu.blogsystem.pojo.dto.CommentAddNewDTO;
import cn.tedu.blogsystem.pojo.vo.CommentListVO;
import cn.tedu.blogsystem.service.ICommentService;
import cn.tedu.blogsystem.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 评论的控制器类
 */
@Api
@Slf4j
@Validated
@RestController
@RequestMapping("/comments")
public class CommentController {

    public CommentController(){
        log.debug("创建控制器对象:CommentController");
    }

    @Autowired
    private ICommentService commentService;


    /**
     * 向评论表中插入数据
     * @param commentAddNewDTO 客户端传递的数据
     * @return 结果集
     */
    @ApiOperation("向评论表中插入数据")
    @ApiOperationSupport(order = 100)
    @PostMapping("/insert")
    public JsonResult<Void> insert(CommentAddNewDTO commentAddNewDTO){
        log.debug("开始处理[添加评论]的请求,参数{}",commentAddNewDTO);
        commentService.insert(commentAddNewDTO);
        return JsonResult.ok();
    }

    /**
     * 根据文章id查询文章列表的请求
     * @param id 文章id
     * @return 返回JsonResult结果集
     */
    @ApiOperation("根据文章id查询评论列表")
    @ApiOperationSupport(order = 600)
    @ApiImplicitParam(name = "id",value = "文章id",required = true, dataType = "long")
    @GetMapping("/{id:[0-9]+}/listByArticleId")
    public JsonResult<List<CommentListVO>> listByArticleId(@PathVariable Long id){
        log.debug("开始处理[根据文章id查询评论列表]的请求,参数:{}",id);
        List<CommentListVO> commentListVOS = commentService.listByArticleId(id);
        return JsonResult.ok(commentListVOS);
    }
}

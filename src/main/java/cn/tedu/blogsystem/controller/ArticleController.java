package cn.tedu.blogsystem.controller;

import cn.tedu.blogsystem.pojo.dto.ArticleAddNewDTO;
import cn.tedu.blogsystem.pojo.vo.ArticleStandardlVO;
import cn.tedu.blogsystem.pojo.vo.UserArticleListItemVO;
import cn.tedu.blogsystem.service.IArticleService;
import cn.tedu.blogsystem.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章控制器类
 *
 * @Author java@Wqy
 * @Version 0.0.1
 */
@Api
@Slf4j
@Validated
@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    /**
     * 发布文章数据
     * @param articleAddNewDTO 文章数据
     * @return 结果集
     */
    @ApiOperation("发布文章数据")
    @ApiOperationSupport(order = 100)
    @ApiImplicitParam(name = "userId",value = "用户id",required = true,dataType = "long")
    @PostMapping("/{userId:[0-9]+}/insert")
    public JsonResult<Void> insert(@PathVariable Long userId, ArticleAddNewDTO articleAddNewDTO){
        log.debug("开始处理[发布文章数据]的请求,参数:{}",articleAddNewDTO);
        articleService.addNew(userId,articleAddNewDTO);
        return JsonResult.ok();
    }

    /**
     * 根据id查询文章详情
     * @param id 文章id
     * @return 返回文章详情
     */
    @ApiOperation("根据id查询文章详情")
    @ApiOperationSupport(order = 600)
    @GetMapping("/selectById")
    public JsonResult<ArticleStandardlVO> selectById(Long id){
        log.debug("开始处理[根据id查询文章详情]的请求,参数{}",id);
        ArticleStandardlVO articleStandardlVO = articleService.articleDetail(id);
        return JsonResult.ok(articleStandardlVO);
    }

    /**
     * 查询主页列表数据
     * @return JsonResult结果集
     */
    @ApiOperation("查询主页信息")
    @ApiOperationSupport(order = 610)
    @GetMapping("")
    public JsonResult<List<UserArticleListItemVO>> homeList(){
        log.debug("开始处理[查询主页列表]的请求,无参");
        List<UserArticleListItemVO> userArticleListItemVOList = articleService.userAndArticleList();
        return JsonResult.ok(userArticleListItemVOList);
    }
}

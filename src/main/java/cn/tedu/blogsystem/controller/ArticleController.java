package cn.tedu.blogsystem.controller;

import cn.tedu.blogsystem.pojo.dto.ArticleAddNewDTO;
import cn.tedu.blogsystem.pojo.vo.ArticleListItemVO;
import cn.tedu.blogsystem.pojo.vo.ArticleStandardVO;
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
@Api(tags = "文章模块")
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
     * @param articleId 文章id
     * @return 返回文章详情
     */
    @ApiOperation("根据文章id查询文章详情")
    @ApiOperationSupport(order = 600)
    @ApiImplicitParam(name = "articleId",value = "文章id",required = true,dataType = "long")
    @GetMapping("/{articleId:[0-9]+}/selectById")
    public JsonResult<ArticleStandardVO> selectByArticleId(@PathVariable Long articleId){
        log.debug("开始处理[根据id查询文章详情]的请求,参数{}",articleId);
        ArticleStandardVO articleStandardVO = articleService.articleDetail(articleId);
        return JsonResult.ok(articleStandardVO);
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

    /**
     * 根据id查询文章列表
     * @param id 用户id
     * @return 文章列表
     */
    @ApiOperation("根据id查询文章列表")
    @ApiOperationSupport(order = 620)
    @GetMapping("/selectById")
    public JsonResult<List<ArticleListItemVO>> selectByUserId(Long id){
        log.debug("开始处理[根据id查询文章列表]的请求,参数:{}", id);
        List<ArticleListItemVO> articleListItemVOS = articleService.listById(id);
        return JsonResult.ok(articleListItemVOS);
    }
}

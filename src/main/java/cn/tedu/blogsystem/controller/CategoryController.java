package cn.tedu.blogsystem.controller;

import cn.tedu.blogsystem.pojo.vo.CategoryListItemVO;
import cn.tedu.blogsystem.service.ICategoryService;
import cn.tedu.blogsystem.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import java.util.List;

/**
 * 类别控制器层
 *
 * @Author java@Wqy
 * @Version 0.0.1
 */
@Api
@Slf4j
@Validated
@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    /**
     * 处理查询类别列表的请求
     * @return 列表
     */
    @ApiOperation("查询类别列表")
    @ApiOperationSupport(order = 600)
    @GetMapping("")
    public JsonResult<List<CategoryListItemVO>> list(){
        log.debug("开始处理[查询类别列表]的请求");
        List<CategoryListItemVO> list = categoryService.list();
        return JsonResult.ok(list);
    }

    /**
     * 根据文章id查询类别
     * @param articleId 文章id
     * @return 返回类别集合
     */
    @ApiOperation("根据文章id查询列表")
    @ApiOperationSupport(order = 610)
    @ApiImplicitParam(name = "articleId",value = "文章id",required = true,dataType = "long")
    @GetMapping("/{articleId:[0-9]+}/listByArticleId")
    public JsonResult<List<CategoryListItemVO>> listByArticleId(@PathVariable Long articleId){
        log.debug("开始处理[根据文章id查询类别]的请求!参数:{}",articleId);
        List<CategoryListItemVO> stringList = categoryService.listByArticleId(articleId);
        return JsonResult.ok(stringList);
    }
}

package cn.tedu.blogsystem.controller;

import cn.tedu.blogsystem.pojo.vo.CategoryListItemVO;
import cn.tedu.blogsystem.service.ICategoryService;
import cn.tedu.blogsystem.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("categories")
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
}

package ${package.Controller};


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.monco.common.response.ApiResult;
import com.monco.entity.${entity};
import com.monco.service.I${entity}Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
<#if superControllerClassPackage??>
    import ${superControllerClassPackage};
</#if>

/**
* <p>
    * ${table.comment!} 前端控制器
    * </p>
*
* @author ${author}
* @since ${date}
*/
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
    class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
    <#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
    <#else>
public class ${table.controllerName} {
    </#if>

    @Resource
    private I${entity}Service ${table.entityPath}Service;

    /**
     * 新增${entity}方法
     *
     * @param ${table.entityPath}
     * @return
     */
    @PostMapping
    public ApiResult save(@RequestBody ${entity} ${table.entityPath}) {
        ${table.entityPath}Service.save(${table.entityPath});
        return ApiResult.ok();
    }

    /**
     * 修改${entity}方法
     *
     * @param ${table.entityPath}
     * @return
     */
    @PutMapping
    public ApiResult update(@RequestBody ${entity} ${table.entityPath}) {
        ${table.entityPath}Service.updateById(${table.entityPath});
        return ApiResult.ok();
    }

    /**
     * 查询列表
     *
     * @param ${table.entityPath}
     * @return
     */
    @GetMapping("list")
    public ApiResult list(${entity} ${table.entityPath}) {
        return ApiResult.ok(${table.entityPath}Service.get${entity}List(${table.entityPath}));
    }

    /**
     * 查询分页
     *
     * @param current 当前页
     * @param size    一页多少数据
     * @param ${table.entityPath}
     * @return
     */
    @GetMapping("page")
    public ApiResult page(@RequestParam(required = false, defaultValue = "0") long current,
                          @RequestParam(required = false, defaultValue = "10") long size, ${entity} ${table.entityPath}) {
        return ApiResult.ok(${table.entityPath}Service.get${entity}Page(new Page<${entity}>().setCurrent(current).setSize(size), ${table.entityPath}));
    }

    /**
     * 删除方法
     *
     * @param id
     * @return
     */
    @DeleteMapping
    public ApiResult delete(@RequestParam Long id) {
        ${table.entityPath}Service.removeById(id);
        return ApiResult.ok();
    }

    /**
     * 按照id获取单条记录
     *
     * @param id
     * @return
     */
    public ApiResult getOne(@RequestParam Long id) {
        return ApiResult.ok(${table.entityPath}Service.getById(id));
    }
}
</#if>

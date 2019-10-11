package ${package.Service};

import com.baomidou.mybatisplus.core.metadata.IPage;
import ${package.Entity}.${entity};
import ${superServiceClassPackage};

import java.util.List;
/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

    /**
     * 查询列表数据
     *
     * @param ${table.entityPath}
     * @return
     */
    List<${entity}> get${entity}List(${entity} ${table.entityPath});

    /**
     * 查询分页数据
     *
     * @param page
     * @param ${table.entityPath}
     * @return
     */
    IPage<${entity}> get${entity}Page(IPage<${entity}> page, ${entity} ${table.entityPath});

}
</#if>

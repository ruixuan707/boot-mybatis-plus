package ${package.ServiceImpl};

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
* <p>
    * ${table.comment!} 服务实现类
    * </p>
*
* @author ${author}
* @since ${date}
*/
@Service
<#if kotlin>
    open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

    }
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    @Resource
    private ${entity}Mapper ${table.entityPath}Mapper;

    @Override
    public List<${entity}> get${entity}List(${entity} ${table.entityPath}) {
        return ${table.entityPath}Mapper.selectList(getWrapper(${table.entityPath}));
    }

    @Override
    public IPage<${entity}> get${entity}Page(IPage<${entity}> page, ${entity} ${table.entityPath}) {
        return ${table.entityPath}Mapper.selectPage(page, getWrapper(${table.entityPath}));
    }

    private QueryWrapper<${entity}> getWrapper(${entity} ${table.entityPath}) {
         QueryWrapper<${entity}> queryWrapper = new QueryWrapper<>();
        if (${table.entityPath}.getId() != null) {
            queryWrapper.eq("id", ${table.entityPath}.getId());
        }
        if (${table.entityPath}.getDataStatus() != null) {
            queryWrapper.eq("data_status", ${table.entityPath}.getDataStatus());
        }
        if (${table.entityPath}.getCreateId() != null) {
            queryWrapper.eq("create_id", ${table.entityPath}.getCreateId());
        }
        if (StringUtils.isNotBlank(${table.entityPath}.getCreateName())) {
            queryWrapper.like("create_name", ${table.entityPath}.getCreateName());
        }
        if (${table.entityPath}.getUpdateId() != null) {
            queryWrapper.eq("update_id", ${table.entityPath}.getUpdateId());
        }
        if (StringUtils.isNotBlank(${table.entityPath}.getUpdateName())) {
            queryWrapper.like("update_name", ${table.entityPath}.getUpdateName());
        }
        return new QueryWrapper<>(${table.entityPath});
    }
}
</#if>

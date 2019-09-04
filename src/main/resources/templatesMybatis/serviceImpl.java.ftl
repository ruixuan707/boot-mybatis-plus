package ${package.ServiceImpl};

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
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
    public List<${entity}> getList(${entity} ${table.entityPath}){
        return ${table.entityPath}Mapper.selectList(getQueryWrapper(${table.entityPath}));
    }

    private QueryWrapper<${entity}> getQueryWrapper(${entity} ${table.entityPath}) {
        return new QueryWrapper<${entity}>();
    }
}
</#if>

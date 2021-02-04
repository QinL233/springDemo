package ${package.Controller};

import ${package.Entity}.${entity};
import ${package.Service}.${table.serviceName};
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
import java.util.List;
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
@RequestMapping("<#if package.ModuleName?? && package.ModuleName != "">/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>
    <#assign service=table.serviceName?uncap_first/>
    @Autowired
    private  ${table.serviceName} ${service};

    @GetMapping("/list")
    public List<${entity}> list(@RequestBody(required = false) ${entity} entity){
        QueryWrapper<${entity}> wrapper = new QueryWrapper<>();
        wrapper.setEntity(entity);
        return ${service}.list(wrapper);
    }

    @GetMapping("/page")
    public IPage<${entity}> page(@RequestParam(value = "current", defaultValue = "1") int current,
                               @RequestParam(value = "size", defaultValue = "10") int size,
                               @RequestBody(required = false) ${entity} entity) {
        IPage<${entity}> page = new Page<>(current, size);
        QueryWrapper<${entity}> wrapper = new QueryWrapper<>();
        wrapper.setEntity(entity);
        return ${service}.page(page, wrapper);
    }
}
</#if>

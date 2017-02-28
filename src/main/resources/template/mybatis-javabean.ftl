public class ${table.camelTableName}Po {
<#list table.fieldVos as field>

    <#if field.comment?? && field.comment != "" >// ${field.comment}</#if>
    private ${field.type} ${field.camelField};
</#list>
}
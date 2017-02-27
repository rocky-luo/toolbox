${'<'}?xml version="1.0" encoding="UTF-8"?${'>'}
${'<'}!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd"${'>'}
${'<'}mapper namespace="需要手动输入"${'>'}

    ${'<'}insert id="insert"${'>'}
        INSERT INTO ${table.tableName} (<#list table.fieldVos as field>${field.field}<#if field_index != table.fieldVos?size - 1>, </#if></#list>)
        VALUE
        (<#list table.fieldVos as field>${r'#{'}${field.camelField}${r'}'}<#if field_index != table.fieldVos?size - 1>, </#if></#list>)
    ${'<'}/insert${'>'}

    ${'<'}insert id="batchInsert"${'>'}
        INSERT INTO ${table.tableName} (<#list table.fieldVos as field>${field.field}<#if field_index != table.fieldVos?size - 1>, </#if></#list>)
        VALUES
    ${'<'}foreach collection="list" item="item" separator=","${'>'}
            (<#list table.fieldVos as field>${r'#{item.'}${field.camelField}${r'}'}<#if field_index != table.fieldVos?size - 1>, </#if></#list>)
    ${'<'}/foreach${'>'}
    ${'<'}/insert${'>'}

    ${'<'}delete id="batchDeleteByIds"${'>'}
        DELETE from ${table.tableName}
        WHERE ${table.primaryField.field} in
        ${'<'}foreach collection="list" item="id" index="index" open="(" close=")" separator=","${'>'}
            ${r'#{'}${table.primaryField.camelField}${r'}'}
        ${'<'}/foreach${'>'}
    ${'<'}/delete${'>'}

    ${'<'}update id="updateById"${'>'}
        UPDATE ${table.tableName}
        ${'<'}trim prefix="SET" suffixOverrides=","${'>'}
        <#list table.fieldVos as field>
            <#if field.primaryKey?string('true', 'false') == 'false'>
            ${'<'}if test="${field.camelField} != null"${'>'}
            ${field.field} = ${r'#{'}${field.camelField}${r'}'},
            ${'<'}/if${'>'}
            </#if>
        </#list>
        ${'<'}/trim${'>'}
        WHERE ${table.primaryField.field} = ${r'#{'}${table.primaryField.camelField}${r'}'}
        ${"<"}/update${'>'}

    ${'<'}insert id="batchUpdateByIds"${'>'}
        INSERT INTO ${table.tableName} (<#list table.fieldVos as field>${field.field}<#if field_index != table.fieldVos?size - 1>, </#if></#list>)
        VALUES
        ${'<'}foreach collection="list" item="item" separator=","${'>'}
            (<#list table.fieldVos as field>${r'#{item.'}${field.camelField}${r'}'}<#if field_index != table.fieldVos?size - 1>, </#if></#list>)
        ${'<'}/foreach${'>'}
        ON DUPLICATE KEY UPDATE
        ${'<'}trim prefix="" suffixOverrides=","${'>'}
        <#list table.fieldVos as field>
            <#if !field.primaryKey>
            ${field.field} = VALUES(${field.field}),
            </#if>
        </#list>
        ${'<'}/trim${'>'}
    ${'<'}/insert${'>'}

    ${'<'}select id="getById" resultType="需要手动输入"${'>'}
        SELECT * FROM ${table.tableName}
        WHERE ${table.primaryField.field} = ${r'#{'}${table.primaryField.camelField}${r'}'}
    ${'<'}/select${'>'}

    ${'<'}select id="getByIds" resultType="需要手动输入"${'>'}
        SELECT * FROM ${table.tableName}
        WHERE ${table.primaryField.field} IN
        ${'<'}foreach collection="list" item="item" separator="," open="(" close=")"${'>'}
            ${r'#{'}item${r'}'}
        ${'<'}/foreach${'>'}
    ${'<'}/select${'>'}
${'<'}/mapper${'>'}
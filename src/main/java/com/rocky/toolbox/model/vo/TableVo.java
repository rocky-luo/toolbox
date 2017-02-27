package com.rocky.toolbox.model.vo;

import java.util.List;

/**
 * Created by rocky on 17/2/24.
 */
public class TableVo {
    private String tableName;
    private String camelTableName;
    private List<FieldVo> fieldVos;
    private FieldVo primaryField;


    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getCamelTableName() {
        return camelTableName;
    }

    public void setCamelTableName(String camelTableName) {
        this.camelTableName = camelTableName;
    }

    public List<FieldVo> getFieldVos() {
        return fieldVos;
    }

    public void setFieldVos(List<FieldVo> fieldVos) {
        this.fieldVos = fieldVos;
    }

    public FieldVo getPrimaryField() {
        return primaryField;
    }

    public void setPrimaryField(FieldVo primaryField) {
        this.primaryField = primaryField;
    }

}

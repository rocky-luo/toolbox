package com.rocky.code.generator.model.vo;

/**
 * Created by rocky on 17/2/23.
 */
public class FieldVo {
    private String field;
    private String type;
    private String camelField;
    private String comment;
    private Boolean primaryKey;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCamelField() {
        return camelField;
    }

    public void setCamelField(String camelField) {
        this.camelField = camelField;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Boolean getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(Boolean primaryKey) {
        this.primaryKey = primaryKey;
    }
}

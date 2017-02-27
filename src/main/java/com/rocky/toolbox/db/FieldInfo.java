package com.rocky.toolbox.db;

/**
 * Created by rocky on 17/2/23.
 */
public class FieldInfo {
    private String field;
    private String type;
    private String comment;
    private String key;

    public FieldInfo(String field, String type, String comment, String key) {
        this.field = field;
        this.type = type;
        this.comment = comment;
        this.key = key;
    }

    public String getField() {
        return field;
    }

    public String getType() {
        return type;
    }

    public String getComment() {
        return comment;
    }

    public String getKey() {
        return key;
    }

    public boolean isPrimaryKey() {
        return "PRI".equals(key);
    }
}

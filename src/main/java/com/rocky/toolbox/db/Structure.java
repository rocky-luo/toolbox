package com.rocky.toolbox.db;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by rocky on 17/2/23.
 */
public class Structure {
    private LinkedHashMap<String, FieldInfo> fieldMap;
    private FieldInfo primaryKey;
    private String tableName;

    public Structure(ResultSet rs, String tableName) throws SQLException {
        rs.beforeFirst();
        fieldMap = Maps.newLinkedHashMapWithExpectedSize(50);
        while (rs.next()) {
            String field = ResultColumn.getField(rs);
            String type = ResultColumn.getType(rs);
            String key = ResultColumn.getKey(rs);
            String comment = ResultColumn.getComment(rs);
            FieldInfo fieldInfo = new FieldInfo(field, type, comment, key);
            if (fieldInfo.isPrimaryKey()) {
                primaryKey = fieldInfo;
            }
            fieldMap.put(fieldInfo.getField(), fieldInfo);
        }
        this.tableName = tableName;

    }

    public int fieldSize() {
        return fieldMap.size();
    }

    public FieldInfo getField(String field) {
        return fieldMap.get(field);
    }

    public FieldInfo getPrimaryKey() {
        return primaryKey;
    }

    public List<FieldInfo> getAllFields() {
        return Lists.newArrayList(fieldMap.values());
    }

    public String getTableName() {
        return tableName;
    }
}

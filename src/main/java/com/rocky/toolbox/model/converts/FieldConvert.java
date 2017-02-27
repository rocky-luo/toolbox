package com.rocky.toolbox.model.converts;

import com.rocky.toolbox.db.FieldInfo;
import com.rocky.toolbox.model.vo.FieldVo;
import com.rocky.toolbox.utils.Underline2Camel;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by rocky on 17/2/23.
 */
public class FieldConvert {

    public static FieldVo info2Vo(FieldInfo fieldInfo) {
        FieldVo vo = new FieldVo();
        vo.setField(fieldInfo.getField());
        vo.setType(jdbcType2JavaClass(fieldInfo.getType()).getSimpleName());
        vo.setComment(fieldInfo.getComment());
        vo.setCamelField(Underline2Camel.underline2Camel(fieldInfo.getField(), true));
        vo.setPrimaryKey(fieldInfo.isPrimaryKey());
        return vo;
    }


    public static Class jdbcType2JavaClass(String jdbcType){
        if (jdbcType.startsWith("bigint")) {
            return Long.class;
        }else if (jdbcType.startsWith("int")){
            return Integer.class;
        }else if (jdbcType.startsWith("char") || jdbcType.startsWith("varchar")) {
            return String.class;
        }else if (jdbcType.startsWith("tinyint")) {
            return Boolean.class;
        }else if (jdbcType.startsWith("float")) {
            return Float.class;
        }else if (jdbcType.startsWith("double")) {
            return Double.class;
        }else if (jdbcType.startsWith("decimal")){
            return BigDecimal.class;
        }else if (jdbcType.startsWith("datetime")) {
            return Timestamp.class;
        }else if (jdbcType.equals("date")) {
            return Date.class;
        }else if (jdbcType.equals("blob")) {
            return byte[].class;
        } else {
            throw new UnsupportedOperationException("unknown jdbc type : " + jdbcType);
        }
    }
}

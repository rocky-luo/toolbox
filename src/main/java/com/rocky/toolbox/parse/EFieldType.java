package com.rocky.toolbox.parse;

/**
 * Created by rocky on 17/3/20.
 */
public enum EFieldType {
    LONG("Long"),
    INTEGER("Integer"),
    STRING("String"),
    BOOL("Bool"),
    BYTE("Byte"),
    SHORT("Short"),
    DOUBLE("Double"),
    UNKNOWN("Unknown");

    private String name;

    EFieldType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static EFieldType findByJavaClassName(String className) {
        if ("Long".equals(className) || "long".equals(className)) {
            return LONG;
        } else if ("short".equals(className) || "Short".equals(className)) {
            return SHORT;
        } else if ("boolean".equals(className) || "Boolean".equals(className)) {
            return BOOL;
        } else if ("Integer".equals(className) || "int".equals(className)) {
            return INTEGER;
        } else if ("String".equals(className)) {
            return STRING;
        } else if ("double".equals(className) || "Double".equals(className)) {
            return DOUBLE;
        }else if ("byte".equals(className) || "Byte".equals(className)) {
            return BYTE;
        } else {
            return UNKNOWN;
        }
    }

    public static EFieldType findByThriftTypeName(String thriftType) {
        if ("i64".equals(thriftType)) {
            return LONG;
        } else if ("i32".equals(thriftType)) {
            return INTEGER;
        } else if ("string".equals(thriftType)) {
            return STRING;
        } else if ("bool".equals(thriftType)) {
            return BOOL;
        } else if ("byte".equals(thriftType)) {
            return BYTE;
        } else if ("i16".equals(thriftType)) {
            return SHORT;
        } else if ("double".equals(thriftType)) {
            return DOUBLE;
        }else {
            return UNKNOWN;
        }
    }
}

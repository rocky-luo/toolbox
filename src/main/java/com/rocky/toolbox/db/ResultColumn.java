package com.rocky.toolbox.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by rocky on 17/2/23.
 */
public class ResultColumn {
    private final static Logger LOGGER = LoggerFactory.getLogger(ResultColumn.class);
    public static final String STRUCTURE_FIELD = "Field";
    public static final String STRUCTURE_TYPE = "Type";
    public static final String STRUCTURE_KEY = "Key";
    public static final String STRUCTURE_COMMENT = "Comment";

    public static String getField(ResultSet rs) {
        String s = null;
        try {
            s = rs.getString(STRUCTURE_FIELD);
        } catch (SQLException e) {
            LOGGER.error("", e);
        }
        return s;
    }

    public static String getType(ResultSet rs) {
        String s = null;
        try {
            s = rs.getString(STRUCTURE_TYPE);
        } catch (SQLException e) {
            LOGGER.error("", e);
        }
        return s;
    }

    public static String getKey(ResultSet rs) {
        String s = null;
        try {
            s = rs.getString(STRUCTURE_KEY);
        } catch (SQLException e) {
            LOGGER.error("", e);
        }
        return s;
    }

    public static String getComment(ResultSet rs) {
        String s = null;
        try {
            s = rs.getString(STRUCTURE_COMMENT);
        } catch (SQLException e) {
            LOGGER.error("", e);
        }
        return s;
    }
}

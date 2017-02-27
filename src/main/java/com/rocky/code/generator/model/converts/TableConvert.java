package com.rocky.code.generator.model.converts;

import com.rocky.code.generator.db.Structure;
import com.rocky.code.generator.model.vo.TableVo;
import com.rocky.code.generator.utils.Underline2Camel;

import java.util.stream.Collectors;

/**
 * Created by rocky on 17/2/24.
 */
public class TableConvert {
    public static TableVo structure2Vo(Structure structure) {
        TableVo tableVo = new TableVo();
        tableVo.setFieldVos(structure.getAllFields().stream()
                .map(FieldConvert::info2Vo)
                .collect(Collectors.toList()));
        tableVo.setPrimaryField(FieldConvert.info2Vo(structure.getPrimaryKey()));
        tableVo.setTableName(structure.getTableName());
        tableVo.setCamelTableName(Underline2Camel.underline2Camel(structure.getTableName(), true));
        return tableVo;
    }
}

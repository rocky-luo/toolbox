package com.rocky.toolbox.model.converts;

import com.rocky.toolbox.db.Structure;
import com.rocky.toolbox.model.vo.TableVo;
import com.rocky.toolbox.utils.Underline2Camel;

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

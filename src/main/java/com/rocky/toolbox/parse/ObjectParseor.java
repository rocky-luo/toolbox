package com.rocky.toolbox.parse;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by rocky on 17/3/20.
 */
public class ObjectParseor {
    private final static Splitter SPLITTER_LINE = Splitter.on(Pattern.compile("[,;\n]")).omitEmptyStrings().trimResults();
    private final static Splitter SPLITTER_BLANK = Splitter.on(" ").omitEmptyStrings().trimResults();
    public static List<ObjectField> parseJava(String text) {
        List<String> lines = parseLine(text);
        return lines.stream()
                .map(ObjectParseor::parseJavaObject)
                .collect(Collectors.toList());
    }

    public static List<ObjectField> parseThrift(String text) {
        List<String> lines = parseLine(text);
        return lines.stream()
                .map(ObjectParseor::parseThriftStruct)
                .collect(Collectors.toList());
    }

    private static List<String> parseLine(String text) {
        List<String> lines = SPLITTER_LINE.splitToList(text);
        return lines;
    }

    private static ObjectField parseJavaObject(String line) {
        ObjectField objectField = new ObjectField();
        List<String> meta = SPLITTER_BLANK.splitToList(line);
        IllegalArgumentException exception = new IllegalArgumentException(String.format("解析出现错误, %s", line));
        if (!(meta.size() == 3 || meta.size() == 2)) {
            throw exception;
        }
        List<String> metaCore = Lists.newArrayListWithCapacity(2);
        if (meta.size() == 3) {
            String modifier = meta.get(0);
            if (!modifier.equals("public") && !modifier.equals("private") && !modifier.equals("protected")) {
                throw exception;
            }
            metaCore.add(meta.get(1));
            metaCore.add(meta.get(2));
        }else {
            metaCore.addAll(meta);
        }
        objectField.setName(metaCore.get(1));
        objectField.setType(EFieldType.findByJavaClassName(metaCore.get(0)).getName());
        return objectField;
    }

    private static ObjectField parseThriftStruct(String line) {
        ObjectField objectField = new ObjectField();
        List<String> meta = SPLITTER_BLANK.splitToList(line);
        IllegalArgumentException exception = new IllegalArgumentException(String.format("解析出现错误, %s", line));
        if (!(meta.size() == 3 || meta.size() == 2)) {
            throw exception;
        }
        List<String> metaCore = Lists.newArrayListWithCapacity(2);
        if (meta.size() == 3) {
            String modifier = meta.get(0);
            Pattern pattern = Pattern.compile("\\d+[:](optional|required)?");
            if (!pattern.matcher(modifier).matches()) {
                throw exception;
            }
            metaCore.add(meta.get(1));
            metaCore.add(meta.get(2));
        }else {
            metaCore.add(meta.get(0).replaceFirst("\\d+[:]", ""));
            metaCore.add(meta.get(1));
        }
        objectField.setName(metaCore.get(1));
        objectField.setType(EFieldType.findByThriftTypeName(metaCore.get(0)).getName());
        return objectField;
    }
}

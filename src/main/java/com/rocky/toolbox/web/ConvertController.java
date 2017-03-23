package com.rocky.toolbox.web;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.rocky.toolbox.model.vo.ConvertPair;
import com.rocky.toolbox.parse.ObjectField;
import com.rocky.toolbox.parse.ObjectParseor;
import com.rocky.toolbox.template.Generator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by rocky on 17/3/20.
 */
@Controller
@RequestMapping("/convert")
public class ConvertController {
    @RequestMapping("/home")
    public String home(){
        return "convert";
    }

    @RequestMapping("/parse")
    @ResponseBody
    public DataResult parse(String text, int type) {
        List<ObjectField> objectFields = null;
        if (type == 1) {
            objectFields = ObjectParseor.parseJava(text);
        }else {
            objectFields = ObjectParseor.parseThrift(text);
        }
        return new SuccessResult(objectFields);
    }

    @RequestMapping("/gen")
    @ResponseBody
    public DataResult gen(String pairs, int type) {
        List<ConvertPair> convertPairs = JSON.parseArray(pairs, ConvertPair.class);
        Map<String, Object> param = Maps.newHashMap();
        param.put("pairs", convertPairs);
        String result = null;
        if (type == 1) {
            result = Generator.classpathTemplateGen("template/convert-direct.ftl", param);
        }else {
            result = Generator.classpathTemplateGen("template/convert-null.ftl", param);
        }
        return new SuccessResult(result);
    }
}

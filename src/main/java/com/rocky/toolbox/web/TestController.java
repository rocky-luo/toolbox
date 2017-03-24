package com.rocky.toolbox.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by rocky on 17/3/24.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/time")
    @ResponseBody
    public String time(){
        return "it is " + new Date();
    }
}

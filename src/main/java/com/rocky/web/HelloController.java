package com.rocky.web;

import com.rocky.service.IHelloWorldService;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by rocky on 16/9/1.
 */
@RequestMapping("/hello")
@Controller
public class HelloController {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Resource
    private IHelloWorldService helloWorldService;
    @RequestMapping("/world")
    @ResponseBody
    public String hello(Long id){
        logger.error("this is not cool~");
        return helloWorldService.getById(id).getName();
    }
}

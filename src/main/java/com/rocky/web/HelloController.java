package com.rocky.web;

import com.google.common.collect.Lists;
import com.rocky.dao.IHelloWorldDAO;
import com.rocky.model.po.PersonPO;
import com.rocky.service.IHelloWorldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by rocky on 16/9/1.
 */
@RequestMapping("/hello")
@Controller
public class HelloController {
    private Logger logger = LoggerFactory.getLogger(HelloController.class);
    @Resource
    private IHelloWorldService helloWorldService;
    @Resource
    private IHelloWorldDAO helloWorldDAO;

    @RequestMapping("/world")
    @ResponseBody
    public String helloWorld(){
        return "hello, world";
    }

    @RequestMapping("/name")
    @ResponseBody
    public String hello(Long id) {
        logger.error("this is not cool~");
        return helloWorldService.getById(id).getName();
    }

    @RequestMapping("/transactional")
    @ResponseBody
    public String transactional() {
        PersonPO po = new PersonPO();
        po.setId(1L);
        po.setName(String.valueOf(System.currentTimeMillis()));
        PersonPO po1 = new PersonPO();
        po1.setId(2L);
        po1.setName(String.valueOf(System.currentTimeMillis()));

        List<PersonPO> pos = Lists.newArrayList(po, po1);
        helloWorldService.batchInsert(pos);
        return "transactional over";
    }

    @RequestMapping("/freemarker")
    public String freemarker(Long id, Model model) {
        PersonPO personPO = helloWorldService.getById(id);
        model.addAttribute("name", personPO.getName());
        model.addAttribute("id", personPO.getId());
        return "hello";
    }

    @RequestMapping("/batchInsert")
    @ResponseBody
    public String batchInsert(){
        PersonPO po = new PersonPO(null, "rocky");
        PersonPO po1 = new PersonPO(null, "luoqi");
        List<PersonPO> pos = Lists.newArrayList(po, po1);
        helloWorldDAO.batchInsert(pos);
        System.out.println(pos);
        return "ok";
    }


}

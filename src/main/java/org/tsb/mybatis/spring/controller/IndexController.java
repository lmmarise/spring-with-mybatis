package org.tsb.mybatis.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * <p>@program: spring-with-mybatis </p>
 * <p>@description:  </p>
 * <p>@author: Arise Tang </p>
 * <p>@create: 2020-04-19 23:33 </p>
 **/
@Controller
public class IndexController {
    @RequestMapping(value = {"/index"})
    public ModelAndView dicts(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("now", new Date());
        return mv;
    }
}

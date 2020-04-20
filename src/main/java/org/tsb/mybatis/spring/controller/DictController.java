package org.tsb.mybatis.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.tsb.mybatis.spring.model.SysDict;
import org.tsb.mybatis.spring.web.service.DictService;

import java.util.List;

/**
 * <p>@program: spring-with-mybatis </p>
 * <p>@description: 实现字典的增删改查 </p>
 * <p>@author: Arise Tang </p>
 * <p>@create: 2020-04-20 12:13 </p>
 **/
@Controller
@RequestMapping("/dicts")
public class DictController {
    @Autowired
    private DictService dictService;

    /**
     * 显示字典数据列表
     */
    @RequestMapping
    public ModelAndView dicts(SysDict sysDict, Integer offset, Integer limit) {
        ModelAndView mv = new ModelAndView("dicts");
        List<SysDict> dicts = dictService.findBySysDictLimit(sysDict, offset, limit);
        mv.addObject("dicts", dicts);
        return mv;
    }

    /**
     * 前端点击[修改/新增]按钮, get提交, 这里根据是否提交id判断是新增还是修改操作
     * 如果是新增, 带着一个空对象跳转到 dict_add.jsp
     * 如果是修改, 先根据id从数据库查出用户信息, 用于回显, 再跳转到 dict_add.jsp
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ModelAndView add(Long id) {
        ModelAndView mv = new ModelAndView("dict_add");
        SysDict sysDict;
        if (id == null) {
            // 没有id创建一个空对象, 进行新增数据操作
            sysDict = new SysDict();
        } else {
            // 有id, 就是根据id修改对象操作
            sysDict = dictService.findById(id);
        }
        mv.addObject("model", sysDict);
        return mv;
    }

    /**
     * 新增或修改字典信息， 通过表单post提交数据
     * 操作成功, 重定向到dicts.jsp页面
     * 操作失败, 跳转到dict_add.jsp页面, 显示失败信息, 回显修改对象
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ModelAndView save(SysDict sysDict){
        ModelAndView mv = new ModelAndView();
        try {
            dictService.saveOrUpdate(sysDict);
            mv.setViewName("redirect:/dicts");
        } catch (Exception e) {
            mv.setViewName("dict_add");
            mv.addObject("msg", e.getMessage());
            mv.addObject("model", sysDict);
        }
        return mv;
    }

    /**
     * 通过id删除字典信息
     * 前端通过ajax来执行删除操作, 删除成功... , 删除失败, 回显失败信息
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap delete(@RequestParam Long id){
        ModelMap modelMap = new ModelMap();
        try {
            boolean success = dictService.deleteById(id);
            modelMap.put("success", success);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("msg", e.getMessage());
        }
        return modelMap;
    }
}

package com.cris15.controller;/*
 *  create by 20224
 *  2020/10/16
 * */

import com.alibaba.fastjson.JSONObject;
import com.cris15.dao.TestMapper;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class TestController {
    @Autowired
    private TestMapper testMapper;

    //private final Logger logger = org.apache.logging.log4j.core.Logger   .getLogger(this.getClass());


    @RequestMapping("/tofirst")
    public ModelAndView tofirst(){
        ModelAndView mv = new ModelAndView("tofirst");
        return mv;
    }

    @RequestMapping("/selectAll")
    public ModelAndView selectAll(){

        List<Map> list = new ArrayList();
        list= testMapper.selectAll();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).put("num",i+1);
        }
        ModelAndView mav = new ModelAndView();
        mav.addObject("list",list);
        mav.setViewName("fileInfo");
        return mav;
    }

}

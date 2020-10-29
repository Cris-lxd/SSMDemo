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

import java.io.File;
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
    public String tofirst(){
        return "tofirst";
    }

    @RequestMapping("/tocanvas")
    public String tocanvas(){
        return "canvas";
    }

    @RequestMapping("/selectAll")
    public ModelAndView selectAll(){

        /*List<Map> list = new ArrayList();
        list= testMapper.selectAll();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).put("num",i+1);
        }*/
        List<Map<String, String>> maps = testMapper.selectNum();
        ModelAndView mav = new ModelAndView();
        mav.addObject("list",maps);
        mav.setViewName("fileInfo");
        return mav;
    }

    @RequestMapping("/selectNum")
    @ResponseBody
    public String selectNum(){
        List<Map<String, String>> maps = testMapper.selectNum();
        File file = new File("D:/desktop/a.html");
        return "查询结果有序号";
    }

}

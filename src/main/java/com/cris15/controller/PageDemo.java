package com.cris15.controller;/*
 *  create by 20224
 *  2020/10/28
 * */

import com.cris15.dao.TestMapper;
import com.sun.xml.internal.ws.resources.HttpserverMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class PageDemo {
    @Autowired
    private TestMapper testMapper;
    @RequestMapping("/pagedemo")
    public ModelAndView pagedemo(HttpServletRequest request){
        int count ;
        ModelAndView mav = new ModelAndView("fileInfo");

            List<Map<String, String>> list = testMapper.selectAllByPage(0,4);
            count = testMapper.count();
            Map map = new HashMap();
            map.put("prePage",1);
            map.put("nextPage",2);
            map.put("currentPage",1);
            int pagenum;
            if(count%4 == 0){
                pagenum = count/4;
            }else {
                pagenum = (count / 4) +1;
            }
            mav.addObject("list",list);
            mav.addObject("pagenum",pagenum);
            mav.addObject("map",map);
            return mav;


    }

    @RequestMapping("/prePage")
    public ModelAndView prePage(HttpServletRequest request,int page){
        int count ;
        ModelAndView mav = new ModelAndView("fileInfo");
        if(page == 1){
            return new ModelAndView("redirect:/pagedemo");
        }
        if(page > 1){
            int start = (page-1)*4+1;
            count = testMapper.count();
            Map map = new HashMap();
            map.put("prePage",page -1);
            map.put("nextPage",page + 1);
            map.put("currentPage",page);
            int pagenum;
            if(count%4 == 0){
                pagenum = count/4;
            }else {
                pagenum = (count / 4) +1;
            }
            List<Map<String, String>> list = testMapper.selectAllByPage(start,4);
            mav.addObject("list",list);
            mav.addObject("pagenum",pagenum);
            mav.addObject("map",map);
            return mav;
        }
        return null;
    }

    @RequestMapping("/nextPage")
    public ModelAndView nextPage(HttpServletRequest request,int page) {
        int count;
        count = testMapper.count();
        Map map = new HashMap();
        map.put("prePage", page - 1);
        map.put("nextPage", page + 1);
        map.put("currentPage",page);
        ModelAndView mav = new ModelAndView("fileInfo");
        int start = (page - 1) * 4 + 1;
        int pagenum;
        if(count%4 == 0){
            pagenum = count/4;
        }else {
            pagenum = (count / 4) +1;
        }
        if (page <= pagenum) {
            List<Map<String, String>> list = testMapper.selectAllByPage(start, 4);
            mav.addObject("list", list);
            mav.addObject("pagenum", pagenum);
            mav.addObject("map",map);
            return mav;
        }
        return null;
    }
}

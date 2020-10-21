package com.cris15.dao;/*
 *  create by 20224
 *  2020/10/16
 * */

import java.util.List;
import java.util.Map;

public interface TestMapper {
    //查找所有
    public List<Map> selectAll();

    //根据id查找
    public String selectById(Long id);
}

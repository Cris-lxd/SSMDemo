package com.cris15.dao;/*
 *  create by 20224
 *  2020/10/16
 * */

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TestMapper {
    //查找所有
    public List<Map> selectAll();

    public List<Map<String,String>> selectAllByPage(@Param("start") int start, @Param("total")int total);

    //根据id查找
    public String selectById(Long id);

    public List<Map<String,String>> selectNum();

    public int count();
}

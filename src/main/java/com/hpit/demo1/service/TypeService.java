package com.hpit.demo1.service;

import com.github.pagehelper.PageInfo;
import com.hpit.demo1.entity.Type;

import java.util.List;

public interface TypeService {
    PageInfo<Type> getType(Integer page, Integer pageSize);

    int insertSelective(Type record);

    int updateByPrimaryKeySelective(Type record);

    int deleteh(Integer[] ids);

    List<Type> getHao();
}

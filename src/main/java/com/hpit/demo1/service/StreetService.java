package com.hpit.demo1.service;

import com.github.pagehelper.PageInfo;
import com.hpit.demo1.entity.Street;

import java.util.List;

public interface StreetService {
    List<Street> query();
    public PageInfo<Street> getPageInfo(Integer page,Integer rows);

    int insertSelective(Street record);

    int updateByPrimaryKeySelective(Street record);

    int deleteByPrimaryKey(Integer id);

    int deletedg(Integer[] ids);

    /*PageInfo<Street> getLook(Integer page, Integer rows, Integer districtId);*/
     List<Street> getMoeld(Integer districtId);
}

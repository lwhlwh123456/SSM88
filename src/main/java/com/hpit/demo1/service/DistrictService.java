package com.hpit.demo1.service;

import com.github.pagehelper.PageInfo;
import com.hpit.demo1.entity.District;
import com.hpit.demo1.entity.DistrictExample;
import com.hpit.demo1.entity.Street;
import com.hpit.demo1.entity.Users;

import java.util.List;

public interface DistrictService {
    PageInfo<District> getPageInfo(Integer page, Integer pageSize);
    int deleteByPrimaryKey(Integer id);
    int insertSelective(District record);
    int updateByPrimaryKeySelective(District record);

    int deleted(Integer[] ids);
    List<District> getAllType();
}

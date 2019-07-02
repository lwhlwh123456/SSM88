package com.hpit.demo1.mapper;

import com.hpit.demo1.entity.District;
import com.hpit.demo1.entity.DistrictExample;
import com.hpit.demo1.entity.StreetExample;

import java.util.List;

public interface DistrictMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(District record);

    int insertSelective(District record);

    List<District> selectByExample(DistrictExample example);

    District selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(District record);

    int updateByPrimaryKey(District record);

     int deleted(Integer[] ids);//list集合和数组
}
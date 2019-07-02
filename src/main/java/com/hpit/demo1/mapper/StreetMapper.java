package com.hpit.demo1.mapper;

import com.hpit.demo1.entity.Street;
import com.hpit.demo1.entity.StreetExample;
import java.util.List;

public interface StreetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Street record);

    int insertSelective(Street record);
    List<Street> query();

    List<Street> selectByExample(StreetExample example);

    Street selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Street record);

    int updateByPrimaryKey(Street record);
   //通过区域删除街道
    int deletes(Integer id);

    int deletedg(Integer[] ids);
}
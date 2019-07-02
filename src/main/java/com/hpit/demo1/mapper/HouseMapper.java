package com.hpit.demo1.mapper;

import com.hpit.demo1.entity.House;
import com.hpit.demo1.entity.HouseExample;
import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    House selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);

    List<House> selectHouse(Integer id);

    House getUpdate(String id);

    List<House> getHouseByStart(Integer ispass);


}
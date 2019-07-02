package com.hpit.demo1.service;

import com.github.pagehelper.PageInfo;
import com.hpit.demo1.entity.House;

import java.util.List;


public interface HouseService {
    int addHouse(House house);

   public PageInfo<House> getSelectHouse(Integer page, Integer rows,Integer id);

    House getHouse(String id);
    //修改
    int Update(House house);
    //删除
    int delete(String id);

    PageInfo<House> getHouseByStart(Integer page,Integer rows,Integer ispaas);

    int passHouse(String id);
}

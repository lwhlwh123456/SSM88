package com.hpit.demo1.service.lmpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hpit.demo1.entity.House;
import com.hpit.demo1.entity.HouseExample;
import com.hpit.demo1.mapper.HouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements com.hpit.demo1.service.HouseService {
    @Autowired
    private HouseMapper houseMapper;

    @Override
    public int addHouse(House house){

        return houseMapper.insertSelective(house);
    }

    @Override
    public PageInfo<House> getSelectHouse(Integer page, Integer rows, Integer id) {
        PageHelper.startPage(page,rows);
        HouseExample houseExample=new HouseExample();
        List<House> houses =houseMapper.selectHouse(id);
        return new PageInfo<House> (houses);
    }

    @Override
    public House getHouse(String id) {
        return houseMapper.getUpdate(id);
    }

    @Override
    public int Update(House house) {
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public int delete(String id) {
        House house=new House();
        house.setId(id);
        house.setIsdel(1);
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public PageInfo<House> getHouseByStart(Integer page, Integer rows, Integer ispass) {
        PageHelper.startPage(page,rows);
        List<House> list= houseMapper.getHouseByStart(ispass);
        return new PageInfo<>(list);
    }

    @Override
    public int passHouse(String id) {
        House house=new House();
        house.setId(id);
        house.setIspass(1);
        return houseMapper.updateByPrimaryKeySelective(house);
    }


}

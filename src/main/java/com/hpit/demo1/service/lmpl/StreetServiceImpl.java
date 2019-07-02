package com.hpit.demo1.service.lmpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hpit.demo1.entity.Street;
import com.hpit.demo1.entity.StreetExample;
import com.hpit.demo1.mapper.StreetMapper;
import com.hpit.demo1.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetServiceImpl implements StreetService {
    @Autowired
    private StreetMapper streetMapper;
    @Override
    public List<Street> query(){
        return streetMapper.query();
    }
    @Override
    public PageInfo<Street> getPageInfo(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        List<Street> list = streetMapper.query();
        PageInfo<Street> pageInfo=new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int insertSelective(Street record) {
        return streetMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Street record) {
        return streetMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return streetMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deletedg(Integer[] ids) {
        return streetMapper.deletedg(ids);
    }

  /*  @Override
    public PageInfo<Street> getLook(Integer page, Integer rows, Integer districtId) {
            PageHelper.startPage(page,rows);
            StreetExample streetExample=new StreetExample();
            StreetExample.Criteria criteria = streetExample.createCriteria();
            criteria.andDistrictIdEqualTo(districtId);
            List<Street> streets = streetMapper.selectByExample(streetExample);
            return new PageInfo<>(streets);
        }*/

     public List<Street> getMoeld(Integer districtId){
         StreetExample streetExample=new StreetExample();
         StreetExample.Criteria criteria = streetExample.createCriteria();
         criteria.andDistrictIdEqualTo(districtId);
         List<Street> streets = streetMapper.selectByExample(streetExample);
         return streets;
     }
    }


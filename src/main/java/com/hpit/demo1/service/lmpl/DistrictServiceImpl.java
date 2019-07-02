package com.hpit.demo1.service.lmpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hpit.demo1.entity.District;
import com.hpit.demo1.entity.DistrictExample;
import com.hpit.demo1.mapper.DistrictMapper;
import com.hpit.demo1.mapper.StreetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DistrictServiceImpl implements com.hpit.demo1.service.DistrictService {
    @Autowired
    private DistrictMapper districtMapper;
    @Autowired
    private StreetMapper streetMapper;

    @Override
    public PageInfo<District> getPageInfo(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        DistrictExample districtExample=new DistrictExample();
        //DistrictExample.Criteria criteria=example.createCriteria();
        //criteria.andNameLike("%东%");
        List<District> list = districtMapper.selectByExample(districtExample);
        return new PageInfo<>(list);
    }
    @Transactional
    public int deleteByPrimaryKey(Integer id) {
        /*删除区域

        删除街道*/

        try {
            streetMapper.deletes(id);
            districtMapper.deleteByPrimaryKey(id);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int insertSelective(District record) {
        return districtMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(District record) {

        return districtMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleted(Integer[] ids) {
        return districtMapper.deleted(ids);
    }

    @Override
    public List<District> getAllType() {
        return districtMapper.selectByExample(new DistrictExample());
    }
}
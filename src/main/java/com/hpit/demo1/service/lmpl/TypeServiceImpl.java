package com.hpit.demo1.service.lmpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hpit.demo1.entity.Type;
import com.hpit.demo1.entity.TypeExample;
import com.hpit.demo1.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hpit.demo1.service.TypeService;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;
    @Override
    public PageInfo<Type> getType(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        TypeExample typeExample = new TypeExample();
        List<Type> types = typeMapper.selectByExample(typeExample);
        PageInfo<Type> pageInfo=new PageInfo<>(types);
        return pageInfo;
    }

    @Override
    public int insertSelective(Type record) {
        return typeMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Type record) {
        return typeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteh(Integer[] ids) {
        return typeMapper.deleteh(ids);
    }

    @Override
    public List<Type> getHao() {
        return typeMapper.selectByExample(new TypeExample());
    }

}

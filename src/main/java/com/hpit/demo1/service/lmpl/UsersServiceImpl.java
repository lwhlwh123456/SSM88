package com.hpit.demo1.service.lmpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hpit.demo1.entity.Users;
import com.hpit.demo1.entity.UsersExample;
import com.hpit.demo1.mapper.UsersMapper;
import com.hpit.demo1.service.UsersService;
import com.hpit.demo1.util.MD5Utils;
import com.hpit.demo1.util.UserPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public int insertSelective(Users record) {
        return usersMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Users record) {
        return usersMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deletea(Integer[] ids) {
        return usersMapper.deletea(ids);
    }

    @Override
   public PageInfo<Users> pageInfo(UserPage userPage){
       PageHelper.startPage(userPage.getPage(),userPage.getRows());
       UsersExample usersExample=new UsersExample();
       UsersExample.Criteria criteria=usersExample.createCriteria();
       //criteria.andIsadminEqualTo(new Integer(1));
       if (userPage.getName()!=null){
           criteria.andNameLike("%"+userPage.getName()+"%");
       }
       if (userPage.getTelephone()!=null){
           criteria.andTelephoneLike("%"+userPage.getTelephone()+"%");
       }
       List<Users> list = usersMapper.selectByExample(usersExample);
        PageInfo<Users> usersPageInfo = new PageInfo<>(list);
        return usersPageInfo;
   }

    @Override
    public int getUsers(String name) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andNameEqualTo(name);
        criteria.andIsadminEqualTo(0);
        List<Users> list=usersMapper.selectByExample(usersExample);
        return list.size()==0?0:1;
    }

    @Override
    public int addUesrs(Users users) {
        //设置为前台注册用户
        users.setIsadmin(0);
        users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));
        return usersMapper.insertSelective(users);
    }

    @Override
    public Users deng(String username, String password) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andIsadminEqualTo(0);
        criteria.andNameEqualTo(username);
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));
        List<Users> list=usersMapper.selectByExample(usersExample);
        if (list.size()==1){
            return list.get(0);
        }
        return null;
    }

}

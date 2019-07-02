package com.hpit.demo1.service;

import com.github.pagehelper.PageInfo;
import com.hpit.demo1.entity.Street;
import com.hpit.demo1.entity.Users;
import com.hpit.demo1.util.UserPage;

public interface UsersService {
    int insertSelective(Users record);

    int updateByPrimaryKeySelective(Users record);
    int deletea(Integer[] ids);

    //查询
    PageInfo<Users> pageInfo(UserPage userPage);
    //检查用户名是否存在
    public int getUsers(String name);
    //实现注册
    public int addUesrs(Users users);
    //实现登入
    public Users deng(String name,String password);
}

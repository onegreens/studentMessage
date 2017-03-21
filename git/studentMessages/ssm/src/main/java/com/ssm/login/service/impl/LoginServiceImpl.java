package com.ssm.login.service.impl;

import com.ssm.login.entity.RoleEntity;
import com.ssm.login.entity.UserEntity;
import com.ssm.login.mapper.RoleMapper;
import com.ssm.login.mapper.UserMapper;
import com.ssm.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<RoleEntity> queryRole() {
        return roleMapper.queryRole();
    }

    @Override
    public UserEntity login( String account,String password) {
        return userMapper.login(account,password);
    }

    @Override
    public Integer queryUserRole(Integer userId,Integer roleId) {
        return userMapper.queryUserRole(userId,roleId);
    }

    @Override
    public UserEntity testEmail(String email) {
        return userMapper.testEmail(email);
    }

    @Override
    public void changePassword(int userId, String password) {
        userMapper.changePassword(userId,password);
    }

}

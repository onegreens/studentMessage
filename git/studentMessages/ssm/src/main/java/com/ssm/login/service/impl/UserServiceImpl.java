package com.ssm.login.service.impl;

import com.ssm.login.entity.UserEntity;
import com.ssm.login.mapper.UserMapper;
import com.ssm.login.service.UserService;
import com.ssm.other.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chensui on 2017/3/19.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public Page queryUserList(Page page) {
        page.setRowCount(userMapper.queryUserCount());
        if (page.getPageSize() == 0) {
            Page.init(page);
        }
        page.setList(null);
        page.setList(userMapper.queryUserList(page.getOffset(),page.getPageSize()));
        return page;
    }

    @Override
    public UserEntity queryUser(Integer userId) {
        return userMapper.queryUser(userId);
    }

    @Override
    public void deleteUser(Integer userId) {
        userMapper.deleteUser(userId);
    }
}

package com.ssm.login.service.impl;

import com.ssm.login.entity.PermissionEntity;
import com.ssm.login.mapper.RoleMapper;
import com.ssm.login.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chensui on 2017/3/15.
 */
@Service
public class MainServiceImpl implements MainService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<PermissionEntity> queryPermission(int roleId) {
        return roleMapper.queryPermission(roleId);
    }
}

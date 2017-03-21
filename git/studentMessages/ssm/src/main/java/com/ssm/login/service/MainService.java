package com.ssm.login.service;

import com.ssm.login.entity.PermissionEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chensui on 2017/3/15.
 */
@Service
public interface MainService {
    /**
     * 查询角色拥有权限
     * @param roleId
     * @return
     */
    public List<PermissionEntity> queryPermission(int roleId);

}

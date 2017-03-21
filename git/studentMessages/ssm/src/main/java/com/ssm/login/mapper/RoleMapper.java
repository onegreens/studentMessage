package com.ssm.login.mapper;

import com.ssm.login.entity.PermissionEntity;
import com.ssm.login.entity.RoleEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chensui on 2017/3/15.
 */
public interface RoleMapper {
    /**
     * 查询角色拥有权限
     * @param roleId
     * @return
     */
    public List<PermissionEntity> queryPermission(@Param("roleId")int roleId);

    /**
     * 查询系统角色
     * @return
     */
    public List<RoleEntity> queryRole();

    /**
     * 查询系统某个角色的id
     * @return
     */
    public Integer queryRoleId(@Param("role")String role);
}

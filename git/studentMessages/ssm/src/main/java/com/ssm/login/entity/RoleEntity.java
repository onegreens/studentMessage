package com.ssm.login.entity;

/**
 * 角色实体类t_role
 */
public class RoleEntity {

    /**
     * id
     */
    private Integer roleEntityId;

    /**
     * 角色名称
     */
    private String roleName;

    public Integer getRoleEntityId() {
        return roleEntityId;
    }

    public void setRoleEntityId(Integer roleEntityId) {
        this.roleEntityId = roleEntityId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

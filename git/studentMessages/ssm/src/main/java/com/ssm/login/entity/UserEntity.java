package com.ssm.login.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息，包含登录账号、密码、验证邮箱
 */
public class UserEntity {
    /**
     * ID
     */
    private Integer userEntityId;
    /**
     * 用户登录账号
     */
    private String account;
    /**
     * 用户登录密码
     */
    private String password;
    /**
     * 用户验证邮箱，用于找回密码
     */
    private String email;

    private List<RoleEntity> roleEntityList=new ArrayList<RoleEntity>();

    public List<RoleEntity> getRoleEntityList() {
        return roleEntityList;
    }

    public void setRoleEntityList(List<RoleEntity> roleEntityList) {
        this.roleEntityList = roleEntityList;
    }

    public Integer getUserEntityId() {
        return userEntityId;
    }

    public void setUserEntityId(Integer userEntityId) {
        this.userEntityId = userEntityId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}

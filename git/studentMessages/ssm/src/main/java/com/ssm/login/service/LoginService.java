package com.ssm.login.service;

import com.ssm.login.entity.RoleEntity;
import com.ssm.login.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface LoginService {

    /**
     * 查询系统角色
     * @return
     */
    public List<RoleEntity> queryRole();

    /**
     * 登录验证
     * @param account
     * @param password
     * @return
     */
    public UserEntity login(String account,String password);

    /**
     * 查询用户是否拥有该角色
     * @param userId
     * @return
     */
    public Integer queryUserRole(Integer userId,Integer roleId);

    /**
     * 查询该邮箱是否存在
     * @param email
     * @return
     */
    public UserEntity testEmail(String email);

    /**
     * 修改密碼
     * @param userId
     * @param password
     * @return
     */
    public void changePassword(int userId,String password);

}

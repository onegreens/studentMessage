package com.ssm.login.mapper;

import com.ssm.login.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserMapper {


    /**
     * 查询用户是否拥有该角色
     * @param userId
     * @return
     */
    public Integer queryUserRole(@Param("userId")Integer userId,@Param("roleId")Integer roleId);

    /**
     * 登录验证
     * @param account
     * @param password
     * @return
     */
    public UserEntity login(@Param("account")String account,@Param("password") String password);


    /**
     * 查询该邮箱是否存在
     * @param email
     * @return
     */
    public UserEntity testEmail(@Param("email") String email);

    /**
     * 修改密碼
     * @param userId
     * @param password
     * @return
     */
    public void changePassword(@Param("userId")int userId,@Param("password")String password);

    /**
     * 添加用户
     * @param userEntity
     * @return
     */
    public Integer addUser(@Param("userEntity")UserEntity userEntity);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    public void deleteUser(@Param("userId")Integer userId);

    /**
     * 为用户建立角色-student关系
     * @return
     */
    public void addUserRoleStu(@Param("userId")int userId,@Param("roleId")Integer roleId);

    /**
     * 查询所有用户
     * @return
     */
    public List<UserEntity> queryUserList(@Param("offset")Integer offset,@Param("pageSize") Integer pageSize);

    /**
     * 计算用户数目
     * @return
     */
    public Integer queryUserCount();

    /**
     * 查询用户
     * @return
     */
    public UserEntity queryUser(@Param("userId")Integer userId);






}

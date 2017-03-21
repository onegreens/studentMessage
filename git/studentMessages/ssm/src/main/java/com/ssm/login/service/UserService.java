package com.ssm.login.service;

import com.ssm.login.entity.UserEntity;
import com.ssm.other.page.Page;
import org.springframework.stereotype.Service;

/**
 * Created by chensui on 2017/3/19.
 */
@Service
public interface UserService {

    /**
     * 查询所有用户
     * @return
     */
    public Page queryUserList(Page page);

    /**
     * 查询用户
     * @return
     */
    public UserEntity queryUser(Integer userId);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    public void deleteUser(Integer userId);


}

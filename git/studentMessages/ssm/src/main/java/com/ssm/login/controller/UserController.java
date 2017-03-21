package com.ssm.login.controller;

import com.ssm.login.entity.UserEntity;
import com.ssm.login.service.UserService;
import com.ssm.other.page.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by chensui on 2017/3/19.
 */
@Controller
@RequestMapping("/manager")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询所有用户信息
     * @param page
     * @param modelMap
     * @return
     */
    @RequestMapping("userManager")
    public String userManager(Page page,ModelMap modelMap){
        page=userService.queryUserList(page);
        modelMap.addAttribute("page",page);
        return  "/back/user/userList";
    }

    @RequestMapping("loadUser")
     public String loadUser(@RequestParam("userId")Integer userId,ModelMap modelMap){
        UserEntity userEntity=userService.queryUser(userId);
        modelMap.addAttribute("userEntity",userEntity);
        return  "/back/user/loadUser";
    }

    @RequestMapping("deleteUser")
    public String deleteUser(@RequestParam("userId")Integer userId,ModelMap modelMap){
        userService.deleteUser(userId);
        modelMap.addAttribute("message","用户删除成功");
        return  "/back/user/loadUser";
    }

    @RequestMapping("addUserRole")
    public String addUserRole(@RequestParam("userId")Integer userId,ModelMap modelMap){
        userService.deleteUser(userId);
        modelMap.addAttribute("message","用户删除成功");
        return  "/back/user/loadUser";
    }


}

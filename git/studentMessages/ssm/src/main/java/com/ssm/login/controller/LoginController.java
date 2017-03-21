package com.ssm.login.controller;

import com.ssm.login.entity.RoleEntity;
import com.ssm.login.entity.UserEntity;
import com.ssm.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 转至登录页面
     * @return
     */
    @RequestMapping(value="/loginPage")
    public String loginPage(String message,ModelMap model){
        List<RoleEntity> roleEntityList=loginService.queryRole();
        model.addAttribute("roleEntityList",roleEntityList);
        model.addAttribute("message",message);
        return "/login/login";
    }

    /**
     * 登录验证
     * @param request
     * @param roleId
     * @param account
     * @param password
     * @param model
     * @return
     */
    @RequestMapping(value="/login",method =RequestMethod.POST)
    public String login(
            HttpServletRequest request,
            @RequestParam("roleId") int roleId,
            @RequestParam("account") String account,
            @RequestParam("password") String password,
            ModelMap model){
        String message=null;
        UserEntity userEntity=loginService.login(account,password);
        if(userEntity == null){
            message="帐号或密码错误,请重新登录!!!";
            model.addAttribute("message", message);
            return "forward:/login/loginPage?message="+message;
        }else{
            Integer userRole=loginService.queryUserRole(userEntity.getUserEntityId(),roleId);
            if(userRole != null){
                request.getSession().setAttribute("user", userEntity);
                request.getSession().setAttribute("roleId", roleId);
                model.addAttribute("user",userEntity);
                return "forward:/back/main";
            }else {
                message="你不具有登录该角色的权限!!!";
                model.addAttribute("message", message);
                return "forward:/login/loginPage?message="+message;
            }
        }
    }

    @RequestMapping(value="/loginOut")
    public String loginOut(
            HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "/login/login";

    }

}

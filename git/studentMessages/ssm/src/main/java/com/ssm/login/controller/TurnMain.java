package com.ssm.login.controller;

import com.ssm.login.entity.PermissionEntity;
import com.ssm.login.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 跳转至主页面
 */
@Controller
@RequestMapping("/back")
public class TurnMain {

    @Autowired
    private MainService mainService;

    @RequestMapping(value="/main")
    public String main(
            HttpServletRequest request,ModelMap modelMap){
        int roleId=(Integer)request.getSession().getAttribute("roleId");
        List<PermissionEntity> permissionEntityList;
        try{
            permissionEntityList=mainService.queryPermission(roleId);
            modelMap.addAttribute("permissionList",permissionEntityList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "/back/main";

    }

}

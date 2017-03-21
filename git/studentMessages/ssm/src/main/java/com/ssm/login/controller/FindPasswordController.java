package com.ssm.login.controller;

import com.ssm.login.entity.UserEntity;
import com.ssm.login.service.LoginService;
import com.ssm.other.email.RandomNum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/find")
public class FindPasswordController {
    String message;
    @Autowired
    private LoginService loginService;

    /**
     * 验证邮箱是否存在
     * 不存在：返回错误信息
     * 存在：往该邮箱发送邮件
     * @param request
     * @param email
     * @param modelMap
     * @return
     */
    @RequestMapping("/testEmail")
    public String testEmail(HttpServletRequest request,@RequestParam("email")String email,ModelMap modelMap){
        UserEntity userEntity=loginService.testEmail(email);
        if(userEntity==null){
            message="该邮箱未注册！！！";
            modelMap.addAttribute("message",message);
            return "/login/writerEmail";
        }else{
            String code= RandomNum.randomNum();
//            try {
//               SendEmail.sendMailCode(email,code);
//            } catch (MessagingException e) {
//                e.printStackTrace();
//                message="邮件发送未成功！";
//                modelMap.addAttribute("message",message);
//                return "/login/writerEmail";
//            }
            modelMap.addAttribute("code",code);
            request.getSession().setAttribute("userId", userEntity.getUserEntityId());
            return "/login/testEmail";
        }
    }

    /**
     * 转至修改密码界面
     * 属于忘记密码操作
     * @param request
     * @return
     */
    @RequestMapping(value="/changePassword")
    public String changePassword(HttpServletRequest request){

        return "/login/changePassword";

    }

    /**
     * 重设密码
     * 属于忘记密码操作
     * @param password
     * @param request
     * @param modelMap
     * @return
     */
    @RequestMapping(value="/updatePassword")
    public String updatePassword(@RequestParam("password") String password, HttpServletRequest request,ModelMap modelMap){
        Integer userId=(Integer)request.getSession().getAttribute("userId");
        loginService.changePassword(userId,password);
        modelMap.addAttribute("message","密码修改成功，请重新的登录！！");
        return "/login/result";
    }

    /**
     * 转至修改密码界面
     * 属于用户修改密码操作
     * @return
     */
    @RequestMapping(value="/toUpdatePassword")
    public String changePassword(){
        return "/back/password/toUpdatePassword";
    }

    /**
     * 修改密码
     * 验证用户原始密码，不正确则返回错误信息
     * 修改密码
     * @param original
     * @param password
     * @param request
     * @param modelMap
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/updateUserPassword")
    public String updateUserPassword(@RequestParam("original") String original,@RequestParam("password") String password, HttpServletRequest request,ModelMap modelMap){
        UserEntity userEntity=(UserEntity)request.getSession().getAttribute("user");
        if (userEntity.getPassword().equals(original)){
            int userId=userEntity.getUserEntityId();
            loginService.changePassword(userId,password);
            request.getSession().removeAttribute("user");
            return "/back/password/success";
        }else{
            modelMap.addAttribute("message","原始密码不正确，请重新输入");
            return "/back/password/toUpdatePassword";
        }
    }

}

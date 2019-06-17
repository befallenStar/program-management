package cn.edu.njnu.controller;

import cn.edu.njnu.pojo.User;
import cn.edu.njnu.service.LoginService;
import cn.edu.njnu.vo.LoginResult;
import cn.edu.njnu.vo.SignUpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private LoginService service;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String signIn(User user, HttpSession session,Model model){
        LoginResult result = service.signIn(user);
        if(result.getType().equals("success")){
            result.setUsername(user.getUsername());
            session.setAttribute("loginResult",result);
            //老师权限，跳转到老师界面
            if(result.getPower()==0){
                return "teacher";
            }
            //学生权限，直接跳转至课程界面，同时将学生的选课信息返回
            else{
                return "class";
            }
        }
        //登录失败
        model.addAttribute("msg",result.getMsg());
        return "../../signIn";
    }

    @RequestMapping(value = "/signUp",method = RequestMethod.POST)
    public String signUp(HttpServletRequest request, Model model){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String reInputPwd = request.getParameter("reInputPwd");
        SignUpResult result = service.signUp(username, password, reInputPwd);
        model.addAttribute("msg",result.getMsg());
        if(result.getType().equals("fail")){
            return "../../signUp";
        }
        return "../../index";
    }

}

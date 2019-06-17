package cn.edu.njnu.aop;

import cn.edu.njnu.pojo.User;
import cn.edu.njnu.vo.LoginResult;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class LoginLog {

    @AfterReturning(value = "execution(public * cn.edu.njnu.service.LoginService.signIn(..))", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        LoginResult loginResult = (LoginResult) result;
        Object[] args = joinPoint.getArgs();
        User user = (User) args[0];
        String username = user.getUsername();
        String ip = request.getRemoteAddr();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = format.format(new Date());
        String msg = "[Login] username:" + username + " ipAddress:" + ip + " at" + time + "try to login, ";
        msg += (loginResult.getType().equals("success") ? "success" : "fail");
    }

}

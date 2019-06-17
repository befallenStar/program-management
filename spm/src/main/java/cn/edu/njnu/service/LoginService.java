package cn.edu.njnu.service;

import cn.edu.njnu.dao.CourseMapper;
import cn.edu.njnu.dao.UserMapper;
import cn.edu.njnu.pojo.Course;
import cn.edu.njnu.pojo.User;
import cn.edu.njnu.vo.LoginResult;
import cn.edu.njnu.vo.SignUpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserMapper userDao;

    @Autowired
    private CourseMapper courseDao;

    public LoginResult signIn(User user) {
        User tmp = userDao.queryUserByUsernameAndPassword(user);
        LoginResult result = new LoginResult();
        if (tmp == null) {
            result.setType("fail");
            result.setMsg("用户名密码不正确");
        } else {
            result.setUserId(tmp.getId());
            result.setUsername(user.getUsername());
            //教师权限
            if (tmp.getPower() == 0) {
                result.setType("success");
                result.setPower(0);
            }
            //学生权限
            else {
                result.setType("success");
                result.setPower(1);
                Course course = courseDao.queryCourseInfoByUserId(tmp.getId());
                result.setCourse(course);
                if (course != null) {
                    int status = course.getStatus();
                    if (status == 0) {
                        result.setCourseStatus("等待任课老师确认");
                    } else {
                        result.setCourseStatus("已加入学习");
                    }
                } else {
                    result.setCourseStatus("加入学习");
                }
            }
        }
        return result;
    }

    public SignUpResult signUp(String username, String password, String reInputPwd) {
        SignUpResult result = new SignUpResult();
        if (!password.equals(reInputPwd)) {
            result.setType("fail");
            result.setMsg("两次密码输入不一致,注册失败");
        } else {
            if (userDao.queryUserByUsername(username) != null) {
                result.setType("fail");
                result.setMsg("用户名已存在,注册失败");
            } else {
                User user = new User(null, username, password, 1);
                Integer res = userDao.insertUser(user);
                if (res != null) {
                    result.setType("success");
                    result.setMsg("注册成功,请登录!");
                } else {
                    result.setType("fail");
                    result.setMsg("注册失败,请稍后重试");
                }
            }
        }
        return result;
    }
}

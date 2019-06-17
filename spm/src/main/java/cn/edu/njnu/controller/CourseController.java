package cn.edu.njnu.controller;

import cn.edu.njnu.pojo.Course;
import cn.edu.njnu.pojo.User;
import cn.edu.njnu.service.CourseService;
import cn.edu.njnu.vo.LoginResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping("/course")
    public String intoCourse(HttpSession session) {
        LoginResult result = (LoginResult) session.getAttribute("loginResult");
        if (result.getCourse() == null) {
            //未选课,跳转至选课界面
            return "student/selectCourse";
        }
        return "student";
    }

    @RequestMapping("/selectCourse")
    public String selectCourse(HttpServletRequest request, HttpSession session) {
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        LoginResult result = (LoginResult) session.getAttribute("loginResult");
        Course course = new Course(null, new User(result.getUserId(), null, null, null),
                email, phone, 0, null, null, null, null, null);
        Course tmpCourse = courseService.selectCourse(course);
        result.setCourse(tmpCourse);
        result.setCourseStatus("等待任课老师确认");
        session.setAttribute("loginResult", result);
        return "class";
    }

    @RequestMapping("/course/list")
    public String showSelectCourseList(Model model) {
        List<Course> courses = courseService.selectAllCourseInfo(1);
        model.addAttribute("courses", courses);
        return "course/list";
    }

    @RequestMapping("/course/confirm_list")
    public String showWaitedConfirmList(Model model) {
        List<Course> courses = courseService.selectAllCourseInfo(0);
        model.addAttribute("courses", courses);
        return "course/confirm_list";
    }

    @RequestMapping("/course/confirm")
    public String confirm(Model model, HttpServletRequest request) {
        String[] ids = request.getParameterValues("id");
        for (String id : ids)
            courseService.confirmCourse(Integer.parseInt(id));
        model.addAttribute("courses", courseService.selectAllCourseInfo(0));
        return "course/confirm_list";
    }

    @RequestMapping("/course/delete")
    public String delete(Model model, HttpServletRequest request) {
        String[] ids = request.getParameterValues("id");
        for (String id : ids)
            courseService.confirmCourse(Integer.parseInt(id));
        model.addAttribute("courses", courseService.selectAllCourseInfo(0));
        return "course/confirm_list";
    }

}

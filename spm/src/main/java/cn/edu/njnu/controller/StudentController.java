package cn.edu.njnu.controller;

import cn.edu.njnu.service.StudentService;
import cn.edu.njnu.vo.ExamPaper;
import cn.edu.njnu.vo.LoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService service;

    @RequestMapping("/test")
    public String test(HttpSession session) {
        LoginResult loginResult = (LoginResult) session.getAttribute("loginResult");
        //已经参加过测试了,直接显示测试结果
        if(loginResult.getCourse().getDailyGrade()!=null)
            return "student/test";
        List<ExamPaper> paper = service.generatePaper();
        session.setAttribute("paper", paper);
        return "student/test";
    }

    @RequestMapping("/completePaper")
    public String complete(HttpServletRequest request, HttpSession session) {
        List<ExamPaper> paper = (List<ExamPaper>) session.getAttribute("paper");
        for (int i = 0; i < paper.size(); i++) {
            String[] parameterValues = request.getParameterValues("question" + (i + 1));
            if(parameterValues==null) paper.get(i).setAnswer(null);
            else paper.get(i).setAnswer(Arrays.asList(parameterValues));
        }
        LoginResult loginResult = (LoginResult) session.getAttribute("loginResult");
        service.verifyAnswer(paper,loginResult);
        session.setAttribute("loginResult",loginResult);
        return "student/test";
    }

    @RequestMapping("/grade")
    public String searchGrade(){
        return "student/grade";
    }

}

package cn.edu.njnu.service;

import cn.edu.njnu.dao.CourseMapper;
import cn.edu.njnu.dao.ExamMapper;
import cn.edu.njnu.pojo.Course;
import cn.edu.njnu.pojo.Exam;
import cn.edu.njnu.util.PointUtil;
import cn.edu.njnu.vo.ExamPaper;
import cn.edu.njnu.vo.LoginResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    @Autowired
    ExamMapper examDao;

    @Autowired
    CourseMapper courseDao;

    public List<ExamPaper> generatePaper() {
        Random random = new Random();
        int paperId = random.nextInt(2) + 1;
        List<Exam> exams = examDao.getAllQuestionsByPaperId(paperId);
        List<ExamPaper> paper = new ArrayList<>();
        for (Exam exam : exams) {
            ExamPaper examPaper = new ExamPaper(exam.getOrder(), exam.getType(),
                    null, null, null, null, exam.getPoint());
            String content = exam.getContent();
            String[] strs = content.split("\r\n");
            //设置单选题或多选题的题目和选项
            if (exam.getType() == 1 || exam.getType() == 2) {
                //strs[0]是题目
                examPaper.setQuestion(strs[0].trim());
                Map<String, String> options = new LinkedHashMap<>();
                int i = 1;
                while (strs[i].trim().equals("")) i++;
                for (; i < strs.length; i++) {
                    String option = strs[i].trim();
                    options.put(option.substring(0, 1), option);
                }
                examPaper.setOptions(options);
            } else {
                examPaper.setQuestion(strs[0].trim());
                Map<String, String> options = new LinkedHashMap<>();
                options.put("T", "T");
                options.put("F", "F");
                examPaper.setOptions(options);
            }
            //设置单选和判断的答案
            if (exam.getType() == 1 || exam.getType() == 3)
                examPaper.setCorrectAnswer(Collections.singletonList(exam.getAnswer().trim()));
                //多选题的正确答案是多选
            else
                examPaper.setCorrectAnswer(Arrays.asList(exam.getAnswer().split(",")));
            //最后将一道题目放到paper数组中
            paper.add(examPaper);
        }
        return paper;
    }

    public void verifyAnswer(List<ExamPaper> paper, LoginResult loginResult) {
        Float point = PointUtil.verifyAnswer(paper);
        Course course = loginResult.getCourse();
        course.setDailyGrade(point);
        courseDao.updateDailyGrade(course);
    }
}

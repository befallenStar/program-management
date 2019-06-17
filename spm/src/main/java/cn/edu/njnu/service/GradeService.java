package cn.edu.njnu.service;

import cn.edu.njnu.dao.CourseMapper;
import cn.edu.njnu.pojo.Course;
import cn.edu.njnu.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
public class GradeService {

    @Autowired
    CourseMapper courseDao;

    public List<Course> importGrade(MultipartFile file) {
        if (file.isEmpty()) {
            try {
                throw new Exception("文件不存在");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        InputStream in;
        try {
            in = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        List<List<Object>> listOb;
        try {
            listOb = new ExcelUtil().getBankListByExcel(in, file.getOriginalFilename());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        List<Course> courses = new ArrayList<>();
        for (List<Object> lo : listOb) {
            String username = (String) lo.get(1);
            Course course = courseDao.queryCourseInfoByUsername(username);
            course.setDailyGrade(Float.valueOf((String) lo.get(2)));
            course.setMidGrade(Float.valueOf((String) lo.get(3)));
            course.setFinalGrade(Float.valueOf((String) lo.get(4)));
            course.setPracticeGrade(Float.valueOf((String) lo.get(5)));
            courses.add(course);
        }
        return courses;
    }

    public Course getCourseInList(Integer id, List<Course> courses) {
        for (Course course : courses) {
            if (course.getId().equals(id))
                return course;
        }
        return null;
    }

    public void updateImportCourses(List<Course> courses) {
        for (Course course : courses) {
            double finalGrade = course.getDailyGrade() * 0.1 + course.getMidGrade() * 0.1
                    + course.getPracticeGrade() * 0.2 + course.getFinalGrade() * 0.6;
            course.setTotalGrade((float) finalGrade);
            courseDao.updateGradeById(course);
        }
    }

    public List<Course> getAllCourses() {
        return courseDao.queryAllByStatus(1);
    }

    public Course getCourseById(Integer id) {
        return courseDao.queryCourseInfoById(id);
    }

    public void updateCourse(Course course) {
        double finalGrade = course.getDailyGrade() * 0.1 + course.getMidGrade() * 0.1
                + course.getPracticeGrade() * 0.2 + course.getFinalGrade() * 0.6;
        course.setTotalGrade((float) finalGrade);
        courseDao.updateGradeById(course);
    }

    public List<Course> getAllFailed() {
        return courseDao.queryCourseInfoByFinalGrade((float) 60.0);
    }

    public List<Course> getNoticedCourses(String[] selecteds) {
        List<Course> courses = new ArrayList<>();
        for (String selected : selecteds) {
            Course course = courseDao.queryCourseInfoById(Integer.valueOf(selected));
            courses.add(course);
        }
        return courses;
    }

    public void notice(List<Course> noticedCourse) throws Exception {
        for (Course course : noticedCourse) {
            String email = course.getEmail();
            String username = course.getUser().getUsername();
            Float finalGrade = course.getFinalGrade();
            notice(email, username, finalGrade);
        }
    }

    @Autowired
    private JavaMailSender javaMailSender;

    private void notice(String email, String username, Float finalGrade) throws Exception {
        MimeMessage mMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mMessageHelper;
        Properties pro = new Properties();
        String from;
        pro.load(this.getClass().getResourceAsStream("/config/mail.properties"));
        from = pro.get("mail.smtp.username") + "";
        mMessageHelper = new MimeMessageHelper(mMessage, true);
        mMessageHelper.setFrom(from);
        mMessageHelper.setTo(email);
        mMessageHelper.setSubject("软件项目管理课程预警");
        mMessageHelper.setText(username+"您好!\n"+"您的软件项目管理课程成绩为"+finalGrade+",成绩不合格，请认真复习，准备补考!");
        javaMailSender.send(mMessage);
    }

}

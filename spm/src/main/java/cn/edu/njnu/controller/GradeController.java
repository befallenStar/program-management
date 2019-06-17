package cn.edu.njnu.controller;

import cn.edu.njnu.pojo.Course;
import cn.edu.njnu.service.GradeService;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.awt.*;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    GradeService service;

    @RequestMapping("/show_import")
    public String showImportGrade() {
        return "grade/grade_import";
    }

    @RequestMapping("/import")
    public String importGrade(@RequestParam("file") MultipartFile file, HttpSession session, Model model) {
        List<Course> courseList = service.importGrade(file);
        session.setAttribute("courses", courseList);
        return "grade/grade_import";
    }

    @RequestMapping("/update_import")
    public String updateImportGrade(Integer id, HttpSession session, Model model) {
        List<Course> courses = (List<Course>) session.getAttribute("courses");
        Course course = service.getCourseInList(id, courses);
        model.addAttribute("course", course);
        model.addAttribute("jumpUrl", "grade/submit_update_import");
        return "grade/grade_update";
    }

    @RequestMapping("/submit_update_import")
    public String submitUpdateImport(Course course, HttpSession session) {
        List<Course> courses = (List<Course>) session.getAttribute("courses");
        Course courseInList = service.getCourseInList(course.getId(), courses);
        courseInList.setDailyGrade(course.getDailyGrade());
        courseInList.setMidGrade(course.getMidGrade());
        courseInList.setFinalGrade(course.getFinalGrade());
        courseInList.setPracticeGrade(course.getPracticeGrade());
        return "grade/grade_import";
    }

    @RequestMapping("/submit_update")
    public String submitUpdate(Course course, Model model) {
        service.updateCourse(course);
        model.addAttribute("courses", service.getAllCourses());
        return "grade/grade_show";
    }


    @RequestMapping("/submit_import")
    public String submitImport(HttpSession session) {
        List<Course> courses = (List<Course>) session.getAttribute("courses");
        service.updateImportCourses(courses);
        session.removeAttribute("courses");
        return "grade/grade_import";
    }

    @RequestMapping("/show")
    public String showAll(Model model) {
        List<Course> courses = service.getAllCourses();
        model.addAttribute("courses", courses);
        return "grade/grade_show";
    }

    @RequestMapping("/update")
    public String update(Integer id, Model model) {
        model.addAttribute("jumpUrl", "grade/submit_update");
        Course course = service.getCourseById(id);
        model.addAttribute("course", course);
        return "grade/grade_update";
    }

    @RequestMapping("/notice_list")
    public String noticeList(Model model) {
        List<Course> courses = service.getAllFailed();
        model.addAttribute("courses", courses);
        return "grade/grade_notice";
    }

    @RequestMapping("/notice")
    public String noticeStudent(HttpServletRequest request, Model model) {
        String[] selecteds = request.getParameterValues("chk");
        if (null == selecteds)
            model.addAttribute("msg", "未选择要通知的学生");
        else {
            List<Course> noticedCourse = service.getNoticedCourses(selecteds);
            try {
                service.notice(noticedCourse);
                model.addAttribute("msg", "发送成功");
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("msg", "发送失败");
            }
        }
        model.addAttribute("courses", service.getAllFailed());
        return "grade/grade_notice";
    }

    @RequestMapping("/analyse")
    public String analysis(HttpServletRequest request,HttpSession session,Model model) throws IOException {
        List<Course> courses = service.getAllCourses();
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        for (Course course : courses) {
            Float point = course.getTotalGrade();
            if(point==null) continue;
            if (point>=90){
                a++;
            }else if(point>=75){
                b++;
            }else if(point>=60){
                c++;
            }else {
                d++;
            }
        }
        StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
        standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 20));
        standardChartTheme.setRegularFont(new Font("微软雅黑", Font.PLAIN, 15));
        standardChartTheme.setLargeFont(new Font("微软雅黑", Font.PLAIN, 15));
        ChartFactory.setChartTheme(standardChartTheme);

        DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
        dataset1.addValue(a,"优秀","优秀");
        dataset1.addValue(b,"良好","良好");
        dataset1.addValue(c,"及格","及格");
        dataset1.addValue(d,"不及格","不及格");
        JFreeChart barChart = ChartFactory.createBarChart3D(
                "成绩分析柱状图",
                "成绩",
                "人数",
                dataset1,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        barChart.setBackgroundPaint(null);
        ChartRenderingInfo barInfo = new ChartRenderingInfo(new StandardEntityCollection());
        String barFileName = ServletUtilities.saveChartAsPNG(barChart,360,280,barInfo,session);
        String barUrl = request.getContextPath()+"/servlet/DisplayChart?filename="+barFileName;
        model.addAttribute("barUrl",barUrl);

        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("优秀", a);
        dataset.setValue("良好", b);
        dataset.setValue("及格",c);
        dataset.setValue("不及格",d);
        JFreeChart chart = ChartFactory.createPieChart(
                "成绩分析饼状图",
                dataset,
                true,
                true,
                false
        );
        chart.setBackgroundPaint(null);
        ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
        String fileName = ServletUtilities.saveChartAsPNG(chart, 360, 280, info, session);
        String url = request.getContextPath() + "/servlet/DisplayChart?filename=" + fileName;
        model.addAttribute("pieUrl",url);
        return "grade/grade_analyse";
    }
}

package cn.edu.njnu.service;

import cn.edu.njnu.dao.CourseMapper;
import cn.edu.njnu.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseMapper courseDao;

    public Course selectCourse(Course course) {
        courseDao.insertCourse(course);
        return courseDao.queryCourseInfoByUserId(course.getUser().getId());
    }

    public List<Course> selectAllCourseInfo(Integer status) {
        return courseDao.queryAllByStatus(status);
    }

    public void confirmCourse(Integer id) {
        courseDao.updateStatusById(id);
    }

    public void deleteCourse(Integer id) {
        courseDao.deleteCourseById(id);
    }
}

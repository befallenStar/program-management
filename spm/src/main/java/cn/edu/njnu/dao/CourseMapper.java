package cn.edu.njnu.dao;

import cn.edu.njnu.pojo.Course;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public interface CourseMapper {

    Course queryCourseInfoByUserId(Integer userId);

    @Transactional
    void insertCourse(Course course);

    @Transactional
    void updateDailyGrade(Course course);

    List<Course> queryAllByStatus(Integer status);

    @Transactional
    void updateStatusById(Integer id);

    @Transactional
    void deleteCourseById(Integer id);

    Course queryCourseInfoByUsername(String username);

    @Transactional
    void updateGradeById(Course course);

    Course queryCourseInfoById(Integer id);

    List<Course> queryCourseInfoByFinalGrade(float finalGrade);
}

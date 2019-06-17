package cn.edu.njnu.dao;

import cn.edu.njnu.pojo.Exam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ExamMapper {

    List<Exam> getAllQuestionsByPaperId(int paperId);

}

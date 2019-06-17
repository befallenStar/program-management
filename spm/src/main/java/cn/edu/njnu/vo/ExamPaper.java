package cn.edu.njnu.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamPaper {

    private Integer order;
    private Integer type;
    private String question;
    private Map<String,String> options;
    private List<String> answer;
    private List<String> correctAnswer;
    private Float point;

}

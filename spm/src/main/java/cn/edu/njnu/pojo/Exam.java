package cn.edu.njnu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Exam implements Serializable {

    private Integer paperId;//卷子Id
    private Integer order;//序号
    //双主键 paperId+order

    private Integer type;//题型
    private String content;//题目内容

    private String answer;//答案
    private Float point;//分数

}

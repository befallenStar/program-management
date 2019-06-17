package cn.edu.njnu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Course implements Serializable {

    private Integer id;
    private User user;//foreign key from user id

    private String email;
    private String telno;//电话号码
    private Integer status;//选课状态

    private Float dailyGrade;//平时分
    private Float midGrade;//期中成绩
    private Float finalGrade;//期末成绩
    private Float practiceGrade;//在线测试成绩
    private Float totalGrade;//总成绩,计算得到

}

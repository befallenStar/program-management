package cn.edu.njnu.vo;

import cn.edu.njnu.pojo.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResult {

    private Integer userId;
    private String username;
    private Integer power;
    private String type;
    private String msg;
    private String CourseStatus;
    private Course course;

}

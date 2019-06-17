package cn.edu.njnu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Message implements Serializable {

    private Integer id;
    private User user;//foreign key from user id
    private String content;//留言内容
    private String time;//留言时间

}

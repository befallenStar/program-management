package cn.edu.njnu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MyFile implements Serializable {

    private Integer id;

    private String filename;//随机文件名,UUID生成防止重名
    private String realname;//真正的文件名
    private String path;//路径名

    private String time;//修改时间,mysql用timestamp存,Java用date

}

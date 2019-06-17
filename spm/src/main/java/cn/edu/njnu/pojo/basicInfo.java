package cn.edu.njnu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class basicInfo implements Serializable {

    private Integer id;
    private String key;
    private String content;

}

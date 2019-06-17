package cn.edu.njnu.dao;

import cn.edu.njnu.pojo.MyFile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ResourceMapper {

    @Transactional
    Integer insertFile(MyFile file);

    List<MyFile> queryAllFile();

    MyFile queryFileById(Integer id);

    @Transactional
    void deleteFileById(Integer id);
}

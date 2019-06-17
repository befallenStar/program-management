package cn.edu.njnu.service;

import cn.edu.njnu.dao.ResourceMapper;
import cn.edu.njnu.pojo.MyFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {

    @Autowired
    ResourceMapper resourceDao;

    public void uploadFile(MyFile myFile) {
        Integer id = resourceDao.insertFile(myFile);
        myFile.setId(id);
    }

    public List<MyFile> showAllFile() {
        return resourceDao.queryAllFile();
    }

    public MyFile queryFileById(Integer id) {
        return resourceDao.queryFileById(id);
    }

    public void deleteFileById(Integer id) {
        resourceDao.deleteFileById(id);
    }
}

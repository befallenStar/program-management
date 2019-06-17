package cn.edu.njnu.dao;

import cn.edu.njnu.pojo.Message;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public interface MessageMapper {

    List<Message> queryAllMsgInfo();

    @Transactional
    void insertMessage(Message message);
}

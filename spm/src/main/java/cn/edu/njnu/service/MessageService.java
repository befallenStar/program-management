package cn.edu.njnu.service;

import cn.edu.njnu.dao.MessageMapper;
import cn.edu.njnu.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageMapper msgDao;

    public List<Message> getMsgList() {
        return msgDao.queryAllMsgInfo();
    }

    public void leaveMsg(Message message) {
        msgDao.insertMessage(message);
    }
}

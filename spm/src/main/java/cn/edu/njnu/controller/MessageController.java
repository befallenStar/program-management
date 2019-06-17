package cn.edu.njnu.controller;

import cn.edu.njnu.pojo.Message;
import cn.edu.njnu.pojo.User;
import cn.edu.njnu.service.MessageService;
import cn.edu.njnu.vo.LoginResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService service;

    @RequestMapping("/message_board")
    public String showMessageBoard(Integer page, Model model) {
        PageHelper.startPage(page, 2);
        List<Message> msgList = service.getMsgList();
        PageInfo<Message> p = new PageInfo<>(msgList);
        model.addAttribute("page", p);
        model.addAttribute("msgList", msgList);
        return "message_board";
    }

    @RequestMapping("/leave")
    public String leaveMessage(String content, HttpSession session, Model model) {
        Message message = new Message();
        LoginResult loginResult = (LoginResult) session.getAttribute("loginResult");
        message.setUser(new User(loginResult.getUserId(),null,null,null));
        message.setContent(content);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        message.setTime(sdf.format(new Date()));
        service.leaveMsg(message);
        //回到留言板界面
        PageHelper.startPage(1, 2);
        List<Message> msgList = service.getMsgList();
        PageInfo<Message> p = new PageInfo<>(msgList);
        model.addAttribute("page", p);
        model.addAttribute("msgList", msgList);
        return "message_board";
    }

}

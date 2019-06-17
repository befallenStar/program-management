package cn.edu.njnu.dao;

import cn.edu.njnu.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public interface UserMapper {

    User queryUserByUsernameAndPassword(User user);

    User queryUserByUsername(String username);

    @Transactional
    Integer insertUser(User user);
}

package com.maz.forum.service;

import com.maz.forum.entity.User;
import com.maz.forum.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    /**
     * 注册用户
     */
    public void register(String userName, String password) {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setUserName(userName);
        user.setPassword(password);

        //判断用户是否已经存在
        //判断密码必须大于6位数

        userRepo.save(user);
    }
}

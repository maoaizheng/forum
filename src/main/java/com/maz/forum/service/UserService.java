package com.maz.forum.service;

import com.maz.forum.controller.api.ForumException;
import com.maz.forum.entity.User;
import com.maz.forum.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.net.sdp.SdpSupport;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    /**
     * 注册用户
     */
    public void register(String userName, String password) throws ForumException {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setUserName(userName);
        user.setPassword(password);

        if (isUserExist(userName)){
            throw new ForumException("用户已存在");
        }
        if(!isPasswordValid(password)) {
            throw new ForumException("密码必须大于6位");
        }
        userRepo.save(user);
    }

    private boolean isUserExist(String userName)  {

        User existingUser =userRepo.findByUserName(userName);

        return existingUser!=null;
    }

    //判断密码必须大于6位数
    private boolean isPasswordValid(String password){
        return password.length() >= 6;

    }

    /**
      * 用户登录功能
     */

    public void login(String userName, String password)throws ForumException{

        if ( !isUserPasswordValid( userName,  password)){
            throw new ForumException("用户名密码不正确");
        }

    }
    private  boolean isUserPasswordValid(String userName, String password){
        User existingUserNameAndPassword=userRepo.findByUserNameAndPassword(userName,password);
        return existingUserNameAndPassword!=null;
    }


    /**
     * 用户登出功能
     */
    public void logout(String userName)throws ForumException{
        if(!isUserExist(userName)){
            throw new ForumException("用户名不存在");
        }

    }

}

package com.maz.forum.controller;

import com.maz.forum.controller.api.ForumException;
import com.maz.forum.controller.api.Response;
import com.maz.forum.service.PostService;
import com.maz.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HomeController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register")
    private Response register(@RequestParam String userName, @RequestParam String password){
        try {
            userService.register(userName, password);
            return Response.success();
        } catch (ForumException e) {

            return  Response.error(e.getMessage());
        }

    }
    @RequestMapping(value = "/login")
    private Response login(@RequestParam String userName, @RequestParam String password){
        try {
            userService.login(userName, password);
            return Response.success();
        } catch (ForumException e) {

            return  Response.error(e.getMessage());
        }

    }
    @RequestMapping(value = "/logout")
    private Response logout(@RequestParam String userName){
        try {
            userService.logout(userName);
            return Response.success();
        } catch (ForumException e) {

            return  Response.error(e.getMessage());
        }

    }

    @RequestMapping(value = "/create")
    private Response create(@RequestParam String author, @RequestParam String content, @RequestParam String title){
            postService.create(author,content,title);
            return Response.success();


    }
}

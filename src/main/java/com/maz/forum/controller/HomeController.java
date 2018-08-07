package com.maz.forum.controller;

import com.maz.forum.controller.api.ForumException;
import com.maz.forum.controller.api.Response;
import com.maz.forum.service.CommentService;
import com.maz.forum.service.PostService;
import com.maz.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(allowCredentials = "true")
public class HomeController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;
    private Response e;


    @RequestMapping(value = "/register")
    private Response register(@RequestParam String userName, @RequestParam String password) {
        try {
            userService.register(userName, password);
            return Response.success();
        } catch (ForumException e) {
            return Response.error(e.getMessage());
        }

    }

    @RequestMapping(value = "/login")
    private Response login(@RequestParam String userName, @RequestParam String password, HttpSession session, HttpServletResponse response) {
        try {
            String uid = userService.login(userName, password);
            return Response.success(uid);
        } catch (ForumException e) {
            return Response.error(e.getMessage());
        }
    }

    @RequestMapping(value = "/getLoginUserName")
    private Response getLoginUserName(@RequestParam String user) {
        return Response.success(userService.getLoginUserName(user));
    }

    @RequestMapping(value = "/logout")
    private Response logout(@RequestParam String userName) {
        try {
            userService.logout(userName);
            return Response.success();
        } catch (ForumException e) {

            return Response.error(e.getMessage());
        }
    }

    @RequestMapping(value = "/create")
    private Response create(@RequestParam String author, @RequestParam String content, @RequestParam String title) {
        postService.create(author, content, title);
        return Response.success();
    }

    @RequestMapping(value = "/modify")
    private Response modify(@RequestParam String id, @RequestParam String content, @RequestParam String title) {
        try {
            postService.modify(id, content, title);
            return Response.success();
        } catch (ForumException e) {

            return Response.error(e.getMessage());
        }
    }

    @RequestMapping(value = "/delete")
    private Response delete(@RequestParam String id) {
        try {
            postService.delete(id);
            return Response.success();
        } catch (ForumException e) {

            return Response.error(e.getMessage());
        }
    }

    @RequestMapping(value = "/findAuthorBooks")
    private Response findAuthorBooks(@RequestParam String author) {
        try {

            return Response.success(postService.findAuthorBooks(author));
        } catch (ForumException e) {

            return Response.error(e.getMessage());
        }
    }

    @RequestMapping(value = "/findAll")
    private Response findAll() {
        return Response.success(postService.findAll());
    }

    @RequestMapping(value = "/addComment")
    private Response addComment(@RequestParam String commentator, @RequestParam String content, @RequestParam String postId) {
        commentService.addComment(commentator, content, postId);
        return Response.success();
    }

    @RequestMapping(value = "/deleteComment")
    private Response deleteComment(@RequestParam String id) {
        try {
            commentService.deleteComment(id);
            return Response.success();
        } catch (ForumException e) {

            return Response.error(e.getMessage());
        }
    }

    @RequestMapping(value = "/findAllComment")
    private Response findAllComment() {
        return Response.success(commentService.findAllComment());
    }

}

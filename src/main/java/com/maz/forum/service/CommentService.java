package com.maz.forum.service;

import com.maz.forum.controller.api.ForumException;
import com.maz.forum.entity.Comment;
import com.maz.forum.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CommentService {
    @Autowired
    private  CommentRepo commentRepo;




    /**
     * 增加评论
     */
    public void addComment(String commentator,String content,String postId){
        Comment comment = new  Comment();
        comment.setId(UUID.randomUUID().toString());
        comment.setContent(content);
        comment.setCommentator(commentator);
        comment.setCreationTime(new Date());
        comment.setPostId(postId);

        commentRepo.save(comment);
    }

    /**
     * 删除评论
     */
    public void deleteComment( String id)throws ForumException {
        if(!commentRepo.existsById(id)){
            throw new ForumException("评论不存在");
        }
        commentRepo.deleteById(id);

    }

    /**
     * 查看所有评论
     */
    public List<Comment> findAllComment() {
        return commentRepo.findAll();
    }

    /**
     * 查看一个帖子的所有评论
     */

    public List<Comment> findOnePostComment(String postId) throws ForumException{
        if(!commentRepo.existsByPostId(postId)){
            throw new ForumException("帖子不存在");
        }
        return  commentRepo.findAllByPostId(postId);
    }




}

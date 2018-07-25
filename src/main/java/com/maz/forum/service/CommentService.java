package com.maz.forum.service;

import com.maz.forum.controller.api.ForumException;
import com.maz.forum.entity.Comment;
import com.maz.forum.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class CommentService {
    @Autowired
    private CommentRepo commentRepo;

    /**
     * 增加评论
     */
    public void addComment(String commentator,String content){
        Comment comment = new  Comment();
        comment.setId(UUID.randomUUID().toString());
        comment.setContent(content);
        comment.setCommentator(commentator);
        comment.setCreationTime(new Date());

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
}

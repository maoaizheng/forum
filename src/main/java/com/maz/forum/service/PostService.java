package com.maz.forum.service;

import com.maz.forum.entity.Post;
import com.maz.forum.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class PostService {
    @Autowired
    private PostRepo postRepo;

    /**
     * 创建帖子
     */
    public void create( String author, String content, String title)  {
        Post post = new Post();
        post.setId(UUID.randomUUID().toString());
        post.setAuthor(author);
        post.setContent(content);
        post.setCreationTime(new Date());
        post.setModifyTime(new Date());
        post.setTitle(title);

        postRepo.save(post);

    }
}

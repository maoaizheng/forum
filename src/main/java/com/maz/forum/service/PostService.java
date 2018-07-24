package com.maz.forum.service;

import com.maz.forum.controller.api.ForumException;
import com.maz.forum.entity.Post;
import com.maz.forum.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
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

    /**
     * 修改帖子
     */
    public void modify( String id, String content, String title)throws ForumException {
        Optional<Post> post = postRepo.findById(id);
        if(!post.isPresent()){
            throw new ForumException("帖子不存在");
        }

        Post post1 = post.get();
        post1.setTitle(title);
        post1.setContent(content);
        post1.setModifyTime(new Date());
        postRepo.save(post1);

    }



    /**
     * 删除帖子
     */
    public void delete( String id)throws ForumException {
        if(!postRepo.existsById(id)){
            throw new ForumException("帖子不存在");
        }
        postRepo.deleteById(id);

    }
    /**
     * 查找所有帖子
     */
    public Iterable findAll() {
         return postRepo.findAll();
    }


    /**
     * 找出某个用户的所有帖子
     */
    public List findAuthorBooks(String author) throws ForumException{
        if(!postRepo.existsByAuthor(author)){
            throw new ForumException("用户不存在");
        }
        return  postRepo.findByAuthor(author);
    }




}

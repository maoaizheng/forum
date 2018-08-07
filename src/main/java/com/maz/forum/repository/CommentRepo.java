package com.maz.forum.repository;

import com.maz.forum.entity.Comment;
import com.maz.forum.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo  extends CrudRepository<Comment, String> {


    void deleteById(String id);

    List<Comment> findAll();
}

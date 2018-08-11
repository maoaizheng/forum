package com.maz.forum.repository;

import com.maz.forum.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepo  extends CrudRepository<Comment, String> {


    void deleteById(String id);

    List<Comment> findAllByPostId(String postId);
    boolean existsByPostId(String postId);

    List<Comment> findAll();
}

package com.maz.forum.repository;

import com.maz.forum.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepo extends CrudRepository<Post, String> {
    List<Post> findByAuthor(String author);
    boolean existsByAuthor(String author);
    List<Post> findAll();
}

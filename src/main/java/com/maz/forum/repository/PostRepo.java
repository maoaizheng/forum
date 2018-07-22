package com.maz.forum.repository;

import com.maz.forum.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends CrudRepository<Post, String> {
    Post findByAuthor (String author);


}

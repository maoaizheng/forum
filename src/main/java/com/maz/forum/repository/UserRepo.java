package com.maz.forum.repository;

import com.maz.forum.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, String> {
     User  findByUserName (String userName);
     User  findByUserNameAndPassword(String userName ,String password);

}

package com.jaeh.blog.repository;

import com.jaeh.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository //생략가능
public interface UserRepository  extends JpaRepository<User,Integer> {
    //JPA 네이밍 전략
   // User findByUsernameAndPassword(String username,String password);
}

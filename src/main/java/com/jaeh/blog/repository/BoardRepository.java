package com.jaeh.blog.repository;

import com.jaeh.blog.model.Board;
import com.jaeh.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //생략가능
public interface BoardRepository extends JpaRepository<Board,Integer> {

}

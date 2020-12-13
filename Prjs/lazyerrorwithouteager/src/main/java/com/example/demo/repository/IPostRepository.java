package com.example.demo.repository;

import com.example.demo.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepository extends JpaRepository<Post, Long> {

}

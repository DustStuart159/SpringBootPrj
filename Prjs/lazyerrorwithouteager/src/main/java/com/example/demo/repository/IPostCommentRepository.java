package com.example.demo.repository;

import com.example.demo.models.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostCommentRepository extends JpaRepository<PostComment, Long> {

}

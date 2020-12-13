package com.example.demo.controller;

import com.example.demo.models.Post;
import com.example.demo.repository.IPostRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private IPostRepository postRepo;

    @GetMapping("/find-one")
    @Transactional
    public Post findById(@RequestParam long id){
        Post post = postRepo.findById(id).get();
        Hibernate.initialize(post.getComments());
        return post;
    }
}

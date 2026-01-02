package com.example.mappingdemo.controller;

import com.example.mappingdemo.entity.Post;
import com.example.mappingdemo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController
{
    private final PostRepository postRepository;

    @PostMapping
    public Post savePost(@RequestBody Post post)
    {
        return postRepository.save(post);
    }

    @GetMapping("/{id}")
    public Post getPost(@PathVariable Long id)
    {
        return postRepository.findById(id).orElseThrow();
    }
}

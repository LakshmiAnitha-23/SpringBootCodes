package com.example.mappingdemo.repository;

import com.example.mappingdemo.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long>
{
}


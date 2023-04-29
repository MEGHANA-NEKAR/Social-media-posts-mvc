package com.springpoc.springpoc.Model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostModel,Integer>{
    
}

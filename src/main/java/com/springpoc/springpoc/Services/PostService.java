
package com.springpoc.springpoc.Services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.springpoc.springpoc.Model.PostModel;
import com.springpoc.springpoc.Model.PostRepository;
import org.springframework.web.bind.annotation.*;
import com.springpoc.springpoc.Model.*;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepo;
    /*
     * public PostService(PostRepository postRepo){
     * this.postRepo=postRepo;
     * }
     */
    
    public void AddPost(String AuthorName, String Content){
        PostModel post=new PostModel();
        post.setAuthorName(AuthorName);
        post.setContent(Content);
        postRepo.save(post);
    }

    
    public List<PostModel> getPosts(){
        return postRepo.findAll();
    }


    public void UpdatePost(Integer postId,String authorName, String content) {
        Optional<PostModel> post = postRepo.findById(postId);
        System.out.println(postId);
        if(post.isPresent()){
            PostModel updatedPost = post.get();
            updatedPost.setAuthorName(authorName);
            updatedPost.setContent(content);
            postRepo.save(updatedPost);
       
        }

        
    }

    public void deleteItem(@PathVariable Integer postId) {
        postRepo.deleteById(postId);
    }

    public PostModel getPostById(Integer postId){
        Optional<PostModel> post = postRepo.findById(postId);
        // if(post.isPresent()){
            PostModel updatedPost = post.get();
            return updatedPost;
          
        // }
    }

}

    // private Integer postId;
    // private String content;
    // private String authorName;
    // private LocalDateTime createdTime;
// /*
//  * 
//  * Getting all posts sorted by time
//  * Create Post
//  * Update a post
//  * Delete a post
//  */
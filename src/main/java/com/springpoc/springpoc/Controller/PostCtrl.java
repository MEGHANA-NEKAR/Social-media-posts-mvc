// package com.springpoc.springpoc.Controller;

// import com.springpoc.springpoc.Model.PostModel;
// import com.springpoc.springpoc.Services.PostService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/posts")
// public class PostCtrl {

//     @Autowired
//     private PostService postService;

//     @GetMapping("")
//     public ResponseEntity<List<PostModel>> getPosts(){
//         List<PostModel> posts = postService.getPosts();
//         return new ResponseEntity<>(posts, HttpStatus.OK);
//     }

//     @PostMapping("")
//     public ResponseEntity<Void> addPost(@RequestBody PostModel post){
//         postService.AddPost(post.getAuthorName(), post.getContent());
//         return new ResponseEntity<>(HttpStatus.CREATED);
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<Void> updatePost(@PathVariable("id") Integer postId, @RequestBody PostModel post){
//         postService.updatePost(postId, post.getAuthorName(), post.getContent());
//         return new ResponseEntity<>(HttpStatus.OK);
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> deletePost(@PathVariable("id") Integer postId){
//         postService.deletePost(postId);
//         return new ResponseEntity<>(HttpStatus.OK);
//     }

// }




package com.springpoc.springpoc.Controller;

import com.springpoc.springpoc.Model.PostModel;
import com.springpoc.springpoc.Model.PostRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import com.springpoc.springpoc.Model.PostModel;
import com.springpoc.springpoc.Services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springpoc.springpoc.Model.PostModel;
import com.springpoc.springpoc.Services.PostService;




@RestController
@RequestMapping("api/v1/post")
public class PostCtrl {
    @Autowired
    private PostService postServ;

    @GetMapping
    public List<PostModel> getPostsCtrl() {
        return postServ.getPosts();
    }
    
    // record NewPost (String AuthorName, String content){}

   
    record NewPost (String AuthorName,String content){}
    

    @PostMapping
    public void creatPostCtrl(@RequestBody NewPost newPost){
    postServ.AddPost(newPost.AuthorName, newPost.content);
    }

    
    record UpdatePost(String AuthorName, String content) {

    }

    @PutMapping("/{postId}")
    public void updatePost(@PathVariable("postId") Integer PostId, @RequestBody UpdatePost it) {
       postServ.UpdatePost(PostId,it.AuthorName,it.content);
    }

    @DeleteMapping("/{postId}")
    public void deleteItem(@PathVariable("postId") Integer postId) {
       postServ.deleteItem(postId);
    }

    @GetMapping("/{postId}")
    public PostModel getPost(@PathVariable("postId") Integer postId){
        return postServ.getPostById(postId);
    }

  
}

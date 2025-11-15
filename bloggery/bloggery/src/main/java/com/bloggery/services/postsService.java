package com.bloggery.services;

import com.bloggery.entities.Posts;
import com.bloggery.entities.Tags;
import com.bloggery.repositories.postsRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class postsService {
    postsRepo repo;

    public postsService(postsRepo repo){
        this.repo = repo;
    }


    public List<Posts> getAllPosts(){
        return repo.findAll();
    }

    public Posts getPostById(int id){
        return repo.findById(id).orElseThrow(()-> new RuntimeException("Post Id Not Found! - Please Enter a valid ID"));
    }

    public void updatePost(int id, String content, String title){
        Posts post = getPostById(id);
        post.setContent(content);
        post.setTitle(title);
        repo.save(post);
    }

    public void savePost(Posts post){
        repo.save(post);
    }

    public void deletePostById(int id){
        repo.deleteById(id);
    }

    public List<Posts> findPostsByUserId(int id){
        return repo.findByUserId(id);
    }

    public List<Posts> findPostsByState(Posts.postState state){
        return repo.findByState(state);
    }

    public List<Posts> findPostsByTageId(Tags tag){
        return repo.findByTagIds(tag);
    }

}

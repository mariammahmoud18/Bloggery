package com.bloggery.services;

import com.bloggery.entities.Comments;
import com.bloggery.repositories.commentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class commentsService {
    commentsRepo repo;

    @Autowired
    public commentsService(commentsRepo repo) {
        this.repo = repo;
    }

    public List<Comments> getAllComments(){
        return repo.findAll();
    }

    public Comments getCommentById(int id){
        return repo.findById(id).orElseThrow(()-> new RuntimeException("Comment Iid Not Found! - Please Enter a valid ID"));
    }

    public void updateComment(int id, String content){
        Comments comment = getCommentById(id);
        comment.setContent(content);
        repo.save(comment);
    }

    public void saveComment(Comments comment){
        repo.save(comment);
    }

    public void deleteCommentById(int id){
        repo.deleteById(id);
    }
}

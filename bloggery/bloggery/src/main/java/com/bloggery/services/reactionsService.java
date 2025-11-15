package com.bloggery.services;

import com.bloggery.entities.Reactions;
import com.bloggery.entities.Users;
import com.bloggery.repositories.reactionsRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class reactionsService {
    reactionsRepo repo;

    public reactionsService(reactionsRepo repo){
        this.repo = repo;
    }


    public List<Reactions> getAllReactions(){
        return repo.findAll();
    }

    public Reactions getReactionById(int id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException("User Id Not Found! - Enter a Valid ID"));
    }

    public void saveReaction(Reactions reaction){
        repo.save(reaction);
    }

    public void deleteReactionById(int id){
        repo.deleteById(id);
    }

    public List<Reactions> getReactionsByType(Reactions.reactionType type){
        return repo.findByType(type);
    }
}

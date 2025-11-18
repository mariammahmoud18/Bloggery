package com.bloggery.services;

import com.bloggery.entities.Tags;
import com.bloggery.repositories.tagsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class tagsService {
    tagsRepo repo;

    @Autowired
    public tagsService(tagsRepo tagsRepo){
        this.repo = tagsRepo;
    }

    public List<Tags> getTagByName(String name){
        return repo.findByName(name);
    }

    public List<Tags> getAllTags(){
        return repo.findAll();
    }

    public Tags findTagById(int id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Tags Id not Found! - Please Enter a Valid ID"));
    }

    public void updateTag(int id, String name){
        Tags tag = findTagById(id);
        tag.setName(name);
        repo.save(tag);
    }

    public void saveTag (Tags tag){
        repo.save(tag);
    }

    public void deleteTagById(int id){
        repo.deleteById(id);
    }
}

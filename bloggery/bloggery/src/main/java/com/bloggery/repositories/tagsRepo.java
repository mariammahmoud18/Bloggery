package com.bloggery.repositories;

import com.bloggery.entities.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface tagsRepo extends JpaRepository<Tags, Integer> {
    public List<Tags> findByName(String name);
}

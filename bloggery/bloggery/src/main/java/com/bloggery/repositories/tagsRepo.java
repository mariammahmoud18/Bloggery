package com.bloggery.repositories;

import com.bloggery.entities.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface tagsRepo extends JpaRepository<Tags, Integer> {
    public List<Tags> findByName(String name);
}

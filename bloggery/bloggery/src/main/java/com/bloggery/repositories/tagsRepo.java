package com.bloggery.repositories;

import com.bloggery.entities.Tags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface tagsRepo extends JpaRepository<Tags, Integer> {
}

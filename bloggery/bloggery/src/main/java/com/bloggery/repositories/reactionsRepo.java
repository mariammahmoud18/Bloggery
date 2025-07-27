package com.bloggery.repositories;

import com.bloggery.entities.Reactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface reactionsRepo extends JpaRepository<Reactions, Integer> {
}

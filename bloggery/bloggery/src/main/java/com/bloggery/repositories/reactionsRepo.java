package com.bloggery.repositories;

import com.bloggery.entities.Reactions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface reactionsRepo extends JpaRepository<Reactions, Integer> {
    public List<Reactions> findByType(Reactions.reactionType type);
}

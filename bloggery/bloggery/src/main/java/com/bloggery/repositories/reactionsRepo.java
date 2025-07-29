package com.bloggery.repositories;

import com.bloggery.entities.Reactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface reactionsRepo extends JpaRepository<Reactions, Integer> {
    public List<Reactions> findByType(Reactions.reactionType type);
}

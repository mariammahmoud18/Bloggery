package com.bloggery.repositories;

import com.bloggery.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface rolesRepo extends JpaRepository<Roles, Integer> {
    public List<Roles> findByName(String name);
}

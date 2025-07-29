package com.bloggery.repositories;

import com.bloggery.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface rolesRepo extends JpaRepository<Roles, Integer> {
    public List<Roles> findByName(String name);
}

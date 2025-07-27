package com.bloggery.repositories;

import com.bloggery.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface rolesRepo extends JpaRepository<Roles, Integer> {
}

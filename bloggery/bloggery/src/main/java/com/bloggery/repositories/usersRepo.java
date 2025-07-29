package com.bloggery.repositories;

import com.bloggery.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface usersRepo extends JpaRepository<Users, Integer> {
    public List<Users> findByUsername(String username);
}

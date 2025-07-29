package com.bloggery.repositories;

import com.bloggery.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface usersRepo extends JpaRepository<Users, Integer> {
    public List<Users> findByUsername(String username);
}

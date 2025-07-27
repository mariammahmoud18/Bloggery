package com.bloggery.repositories;

import com.bloggery.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface usersRepo extends JpaRepository<Users, Integer> {
}

package com.bloggery.services;

import com.bloggery.entities.Users;
import com.bloggery.repositories.usersRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class usersService {
    usersRepo repo;

    public usersService(usersRepo usersRepo){
        this.repo = usersRepo;
    }

    public List<Users> getUserByUserName(String username){
        return repo.findByUsername(username);
    }

    public List<Users> getAllUsers(){
        return repo.findAll();
    }

    public Users getUserById(int id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException("User Id Not Found! - Enter a Valid ID"));
    }

    public void updateUserUsername(int id, String username){
        Users user = getUserById(id);
        user.setUsername(username);
        repo.save(user);
    }

    public void updateUserPassword(int id, String password){
        Users user = getUserById(id);
        user.setPassword(password);
        repo.save(user);
    };

    public void saveUser(Users user){
        repo.save(user);
    }

    public void deleteUserById(int id){
        repo.deleteById(id);
    }
}

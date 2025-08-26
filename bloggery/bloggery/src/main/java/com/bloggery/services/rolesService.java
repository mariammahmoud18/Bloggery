package com.bloggery.services;

import com.bloggery.entities.Roles;
import com.bloggery.repositories.rolesRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class rolesService {
    rolesRepo repo;

    public rolesService(rolesRepo rolesRepo){
        this.repo = rolesRepo;
    }

    public List<Roles> getRoleByName(String name){
        return repo.findByName(name);
    }

    public List<Roles> getAllRoles(){
        return repo.findAll();
    }

    public Roles getRoleById(int id){
        return repo.findById(id).orElseThrow(()-> new RuntimeException("Role id Not Found! - Please Enter a valid ID"));
    }

    public void updateRole(int id, String name){
        Roles role = getRoleById(id);
        role.setName(name);
        repo.save(role);
    }

    public void saveRole(Roles role){
        repo.save(role);
    }

    public void deleteRoleById(int id){
        repo.deleteById(id);
    }
}

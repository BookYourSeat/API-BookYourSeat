package com.bookyourseat.api.Core.User.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bookyourseat.api.Core.User.Model.User;
import com.bookyourseat.api.Core.User.Repository.UserRepository;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    public List<User> GetAll() {
        try {
            return userRepository.GetAll();
        }
        catch(SQLException e) {
            return new ArrayList<User>();
        }
    }

    public User GetById(UUID id) {
        try {
            return userRepository.GetById(id);
        }
        catch(SQLException e) {
            return new User();
        }
    }

    public User Post(User user) {
        try {
            if(!ValidateUserInfo(user))
                return new User();
            if(!UniqueEmail(user.getEmail()))
                return new User();
            return userRepository.Post(user);
        }
        catch(SQLException e) {
            return new User();
        }
    }

    public User Put(UUID id, User user) {
        try {
            if(!ValidateUserInfo(user))
                return new User();
            if(!ValidateUserExists(id))
                return new User();
            return userRepository.Put(id, user);
        }
        catch(SQLException e) {
            return new User();
        }
    }

    public User Delete(UUID id) {
        try {
            if(!ValidateUserExists(id))
                return new User();
            return userRepository.Delete(id);
        }
        catch(SQLException e) {
            return new User();
        }
    }

    private Boolean ValidateUserInfo(User user){
        if(user.getEmail().isBlank())
            return false;
        if(user.getFirstName().isBlank())
            return false;
        if(user.getLastName().isBlank())
            return false;
        if(user.getPassword().isBlank())
            return false;
        return true;
    }

    private Boolean UniqueEmail(String email){
        try{
            /* TODO: Create method in repository to improve performance
             whithout the need to get all users */
            List<User> users = userRepository.GetAll();
            for (User user : users) {
                if(user.getEmail().equals(email)){
                    return false;
                }
            }
        }
        catch(SQLException e) {
            return false;
        }
        return true;
    }

    private Boolean ValidateUserExists(UUID id){
        try{
            User user = userRepository.GetById(id);
            if(user.toString().isBlank())
                return false;
            return true;
        }
        catch(SQLException e) {
            return false;
        }      
    }
}

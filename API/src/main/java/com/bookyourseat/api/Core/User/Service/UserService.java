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

    public Boolean Post(User user) {
        try {
            if(!ValidateUserInfo(user))
                return false;
            if(!UniqueEmail(user.getEmail()))
                return false;
            return userRepository.Post(user);
        }
        catch(SQLException e) {
            return false;
        }
    }

    public Boolean Put(UUID id, User user) {
        try {
            if(!ValidateUserInfo(user))
                return false;
            if(!ValidateUserExists(id))
                return false;
            return userRepository.Put(id, user);
        }
        catch(SQLException e) {
            return false;
        }
    }

    public Boolean Delete(UUID id) {
        try {
            if(!ValidateUserExists(id))
                return false;
            return userRepository.Delete(id);
        }
        catch(SQLException e) {
            return false;
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
            if(user == null)
                return false;
            return true;
        }
        catch(SQLException e) {
            return false;
        }      
    }
}

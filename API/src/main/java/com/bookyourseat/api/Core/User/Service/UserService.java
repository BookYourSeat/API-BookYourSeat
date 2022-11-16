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
}

package com.bookyourseat.api.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookyourseat.api.Core.User.Model.User;
import com.bookyourseat.api.Core.User.Service.UserService;

@RestController
@RequestMapping("User")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> Get() {
        return userService.GetAll();
    }

    @GetMapping("{id}")
    public User GetById(@PathVariable UUID id) {
        return userService.GetById(id);
    }

    @PostMapping
    public Boolean Post(@RequestBody User newUser){
        //System.out.println(newUser.getFirstName() + " " + newUser.getLastName() + " " + newUser.getPassword());
        return userService.Post(newUser);
    }

    @PutMapping("{id}")
    public Boolean Put(@PathVariable UUID id, @RequestBody User user){
        return userService.Put(id, user);
    }

    @DeleteMapping("{id}")
    public Boolean Delete(@PathVariable UUID id){
        return userService.Delete(id);
    }
}
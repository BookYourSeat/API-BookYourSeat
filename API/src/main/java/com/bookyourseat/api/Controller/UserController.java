package com.bookyourseat.api.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

}

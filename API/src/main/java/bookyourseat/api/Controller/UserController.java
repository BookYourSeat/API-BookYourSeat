package bookyourseat.api.Controller;

import User.Model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/User")
public class UserController {
    @GetMapping("/GetById")
    public User GetUser(UUID Id) {
        User newUser = new User();
        return newUser;
    }

    @GetMapping("/GetAll")
    public List<User> GetAllUsers() {
        ArrayList users = new ArrayList<User>();
        return users;
    }

    @GetMapping("/GetAll")
    public boolean Post() {
        ArrayList users = new ArrayList<User>();
        return true;
    }
}

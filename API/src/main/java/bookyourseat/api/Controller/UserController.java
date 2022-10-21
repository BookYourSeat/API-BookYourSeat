package bookyourseat.api.Controller;

import User.Model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class UserController {
    @GetMapping("User/GetById")
    public User GetUser(UUID Id) {
        User newUser = new User();
        return newUser;
    }

    @GetMapping("User/GetAll")
    public List<User> GetAllUsers() {
        ArrayList users = new ArrayList<User>();
        return users;
    }
}

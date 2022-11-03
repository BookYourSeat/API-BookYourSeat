package bookyourseat.api.Controller;

import User.Model.User;
import User.Service.IUserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/User")
public class UserController {
    private IUserService userService;

    public UserController(IUserService userService){
        this.userService = userService;
    }

    @GetMapping("/GetById")
    public User GetUser(UUID Id) {
        User newUser = new User();
        return newUser;
    }

    @GetMapping("/GetAll")
    public List<User> GetAll() {
        ArrayList users = new ArrayList<User>();
        return users;
    }

    @PostMapping("/Post")
    public boolean Post(User user) {
        ArrayList users = new ArrayList<User>();
        return true;
    }

    @PutMapping("/Put")
    public boolean Put(User user) {
        ArrayList users = new ArrayList<User>();
        return true;
    }

    @DeleteMapping("/Delete")
    public boolean Delete(UUID id) {
        ArrayList users = new ArrayList<User>();
        return true;
    }
}

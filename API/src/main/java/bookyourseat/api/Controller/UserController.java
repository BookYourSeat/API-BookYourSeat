package bookyourseat.api.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("User/Get")
    public String GetUser() {
        return String.format("Logging in!");
    }
}

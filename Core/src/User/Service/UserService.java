package User.Service;

public class UserService {
    private IUserService userService;

    public UserService(IUserService userService){
        this.userService = userService;
    }

}

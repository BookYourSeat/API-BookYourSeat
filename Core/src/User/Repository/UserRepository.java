package User.Repository;

public class UserRepository {
    private IUserRepository userRepository;

    public UserRepository(IUserRepository userRepository){
        this.userRepository = userRepository;
    }
}

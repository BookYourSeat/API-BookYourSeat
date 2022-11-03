package User.Service;

import User.Model.User;
import User.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    public User GetById(UUID id){

        return null;
    }
    public List<User> GetAll(){
        return null;
    }
    public boolean Post(User user){
        return false;
    }
    public boolean Put(User user){
        return false;
    }
    public boolean Delete(UUID id){
        return false;
    }
}

package User.Service;

import User.Model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface IUserService {
    public User GetById(UUID id);
    public List<User> GetAll();
    public boolean Post(User user);
    public boolean Put(User user);
    public boolean Delete(UUID id);
}

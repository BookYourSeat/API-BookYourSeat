package User.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import User.Model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
}

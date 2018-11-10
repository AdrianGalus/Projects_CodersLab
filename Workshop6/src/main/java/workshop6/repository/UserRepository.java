package workshop6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import workshop6.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}

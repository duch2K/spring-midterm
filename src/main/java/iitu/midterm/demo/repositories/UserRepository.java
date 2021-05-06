package iitu.midterm.demo.repositories;

import iitu.midterm.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    boolean existsUserByUsernameAndPassword(String username, String password);
//    User getUserByUsername(String username);
    User findByUsername(String username);
}

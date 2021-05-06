package iitu.midterm.demo.repositories;

import iitu.midterm.demo.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> getRequestsByUserId(Long userId);
}

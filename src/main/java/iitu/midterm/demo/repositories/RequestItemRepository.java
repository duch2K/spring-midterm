package iitu.midterm.demo.repositories;

import iitu.midterm.demo.entities.RequestItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestItemRepository extends JpaRepository<RequestItem, Long> {
}

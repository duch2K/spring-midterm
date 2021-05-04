package iitu.midterm.demo.repositories;

import iitu.midterm.demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    boolean existsStudentByUsernameAndPassword(String username, String password);
    Student getStudentByUsername(String username);
}

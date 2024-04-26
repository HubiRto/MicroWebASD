package pl.pomoku.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pomoku.authservice.entity.User;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmailAndStudentId(String email, String studentId);

    Optional<User> findByEmail(String email);
}

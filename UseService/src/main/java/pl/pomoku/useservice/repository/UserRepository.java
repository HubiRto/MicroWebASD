package pl.pomoku.useservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pomoku.useservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

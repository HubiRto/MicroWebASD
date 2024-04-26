package pl.pomoku.useservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pomoku.useservice.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}

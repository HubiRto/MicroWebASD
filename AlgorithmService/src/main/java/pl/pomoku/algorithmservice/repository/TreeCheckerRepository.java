package pl.pomoku.algorithmservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.pomoku.algorithmservice.entity.TreeCheckerEntity;

import java.util.Optional;

@Repository
public interface TreeCheckerRepository extends MongoRepository<TreeCheckerEntity, String> {
    Optional<TreeCheckerEntity> findByHash(int hash);
}

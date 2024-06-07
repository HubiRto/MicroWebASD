package pl.pomoku.algorithmservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.pomoku.algorithmservice.entity.BinarySearchTreeDestroyEntity;

import java.util.Optional;

@Repository
public interface BinarySearchTreeDestroyRepository extends MongoRepository<BinarySearchTreeDestroyEntity, String> {
    Optional<BinarySearchTreeDestroyEntity> findByHash(int hash);
}

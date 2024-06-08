package pl.pomoku.algorithmservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.pomoku.algorithmservice.entity.BinarySearchTreeSequenceEntity;

import java.util.Optional;

@Repository
public interface BinarySearchTreeSequenceRepository extends MongoRepository<BinarySearchTreeSequenceEntity, String> {
    Optional<BinarySearchTreeSequenceEntity> findByHash(int hash);
}

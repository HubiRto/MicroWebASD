package pl.pomoku.algorithmservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.pomoku.algorithmservice.entity.StackSequenceEntity;

import java.util.Optional;

@Repository
public interface StackSequenceRepository extends MongoRepository<StackSequenceEntity, String> {
    Optional<StackSequenceEntity> findByHash(int hash);
}

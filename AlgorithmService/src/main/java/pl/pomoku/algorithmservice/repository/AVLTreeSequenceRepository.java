package pl.pomoku.algorithmservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.pomoku.algorithmservice.entity.AVLTreeSequenceEntity;

import java.util.Optional;

@Repository
public interface AVLTreeSequenceRepository extends MongoRepository<AVLTreeSequenceEntity, String> {
    Optional<AVLTreeSequenceEntity> findByHash(int hash);
}

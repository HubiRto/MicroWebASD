package pl.pomoku.algorithmservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.pomoku.algorithmservice.entity.TraverseConverterEntity;

import java.util.Optional;

@Repository
public interface TraverseConverterRepository extends MongoRepository<TraverseConverterEntity, String> {
    Optional<TraverseConverterEntity> findByHash(int hash);
}

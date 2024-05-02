package pl.pomoku.algorithmservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.pomoku.algorithmservice.entity.InsertionSortEntity;

import java.util.Optional;

@Repository
public interface InsertionSortRepository extends MongoRepository<InsertionSortEntity, String> {
    Optional<InsertionSortEntity> findByHash(int hash);
}

package pl.pomoku.algorithmservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.pomoku.algorithmservice.entity.CountingSortEntity;

import java.util.Optional;

@Repository
public interface CountingSortRepository extends MongoRepository<CountingSortEntity, String> {
    Optional<CountingSortEntity> findByHash(int hash);
}

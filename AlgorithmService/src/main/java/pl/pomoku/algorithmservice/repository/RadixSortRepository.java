package pl.pomoku.algorithmservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.pomoku.algorithmservice.entity.RadixSortEntity;

import java.util.Optional;

@Repository
public interface RadixSortRepository extends MongoRepository<RadixSortEntity, String> {
    Optional<RadixSortEntity> findByHash(int hash);
}

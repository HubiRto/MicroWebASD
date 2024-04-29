package pl.pomoku.algorithmservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.pomoku.algorithmservice.entity.BinSearchEntity;

import java.util.Optional;

@Repository
public interface BinSearchRepository extends MongoRepository<BinSearchEntity, String> {
    Optional<BinSearchEntity> findByHash(int hash);
}

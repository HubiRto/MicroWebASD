package pl.pomoku.algorithmservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.pomoku.algorithmservice.entity.binSearch.BinSearchEntity;

import java.util.Optional;

public interface BinSearchRepository extends MongoRepository<BinSearchEntity, String> {
    Optional<BinSearchEntity> findByHash(int hash);
}

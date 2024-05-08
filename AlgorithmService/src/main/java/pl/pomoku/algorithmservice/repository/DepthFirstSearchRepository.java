package pl.pomoku.algorithmservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.pomoku.algorithmservice.entity.DepthFirstSearchEntity;

import java.util.Optional;

@Repository
public interface DepthFirstSearchRepository extends MongoRepository<DepthFirstSearchEntity, String> {
    Optional<DepthFirstSearchEntity> findByHash(int hash);
}

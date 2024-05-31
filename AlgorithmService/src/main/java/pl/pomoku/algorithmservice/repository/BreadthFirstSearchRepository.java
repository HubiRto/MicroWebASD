package pl.pomoku.algorithmservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.pomoku.algorithmservice.entity.BreadthFirstSearchEntity;

import java.util.Optional;

@Repository
public interface BreadthFirstSearchRepository extends MongoRepository<BreadthFirstSearchEntity, String> {
    Optional<BreadthFirstSearchEntity> findByHash(int hash);
}

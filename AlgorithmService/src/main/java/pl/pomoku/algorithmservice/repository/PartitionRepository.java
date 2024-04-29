package pl.pomoku.algorithmservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.pomoku.algorithmservice.entity.binSearch.PartitionEntity;

import java.util.Optional;

@Repository
public interface PartitionRepository extends MongoRepository<PartitionEntity, String> {
    Optional<PartitionEntity> findByHash(int hash);
}

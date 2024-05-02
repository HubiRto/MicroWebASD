package pl.pomoku.algorithmservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pl.pomoku.algorithmservice.entity.QuickSortPartitionEntity;

import java.util.Optional;

public interface QuickSortPartitionRepository extends MongoRepository<QuickSortPartitionEntity, String> {
    Optional<QuickSortPartitionEntity> findByHash(int hash);
}

package pl.pomoku.algorithmservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.pomoku.algorithmservice.entity.MergeSortEntity;
import pl.pomoku.algorithmservice.entity.PartitionEntity;

import java.util.Optional;

@Repository
public interface MergeSortRepository extends MongoRepository<MergeSortEntity, String> {
    Optional<MergeSortEntity> findByHash(int hash);
}

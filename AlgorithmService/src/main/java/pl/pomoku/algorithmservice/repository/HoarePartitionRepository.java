package pl.pomoku.algorithmservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.pomoku.algorithmservice.entity.HoarePartitionEntity;

import java.util.Optional;

@Repository
public interface HoarePartitionRepository extends MongoRepository<HoarePartitionEntity, String> {
    Optional<HoarePartitionEntity> findByHash(int hash);
}

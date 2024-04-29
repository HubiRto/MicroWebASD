package pl.pomoku.algorithmservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pomoku.algorithmservice.algorithm.Partition;
import pl.pomoku.algorithmservice.dto.input.PartitionInput;
import pl.pomoku.algorithmservice.dto.output.PartitionOutput;
import pl.pomoku.algorithmservice.entity.PartitionEntity;
import pl.pomoku.algorithmservice.repository.PartitionRepository;
import pl.pomoku.algorithmservice.utils.HashUtils;

@Service
@RequiredArgsConstructor
public class PartitionService {
    private final PartitionRepository repository;

    public PartitionOutput getResult(PartitionInput input) {
        int hash = HashUtils.hash(input.getArr());
        return repository.findByHash(hash)
                .map(PartitionEntity::getOutput)
                .orElseGet(() -> {
                    PartitionOutput output = Partition.calculateWithOutput(input);
                    repository.save(new PartitionEntity(hash, input, output));
                    return output;
                });
    }
}

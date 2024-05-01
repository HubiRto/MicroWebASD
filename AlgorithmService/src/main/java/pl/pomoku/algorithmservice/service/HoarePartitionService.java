package pl.pomoku.algorithmservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pomoku.algorithmservice.algorithm.HoarePartition;
import pl.pomoku.algorithmservice.annotations.MeasureCalculationTime;
import pl.pomoku.algorithmservice.dto.input.HoarePartitionInput;
import pl.pomoku.algorithmservice.dto.output.HoarePartitionOutput;
import pl.pomoku.algorithmservice.entity.HoarePartitionEntity;
import pl.pomoku.algorithmservice.repository.HoarePartitionRepository;
import pl.pomoku.algorithmservice.utils.HashUtils;

@Service
@RequiredArgsConstructor
public class HoarePartitionService {
    private final HoarePartitionRepository repository;

    @MeasureCalculationTime
    public HoarePartitionOutput getResult(HoarePartitionInput input) {
        int hash = HashUtils.hash(input.getArr(), input.getK());
        return repository.findByHash(hash)
                .map(HoarePartitionEntity::getOutput)
                .orElseGet(() -> {
                    HoarePartitionOutput output = HoarePartition.calculate(input);
                    repository.save(new HoarePartitionEntity(hash, input, output));
                    return output;
                });
    }
}

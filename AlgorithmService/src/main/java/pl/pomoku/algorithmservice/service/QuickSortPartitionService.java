package pl.pomoku.algorithmservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pomoku.algorithmservice.algorithm.QuickSortPartition;
import pl.pomoku.algorithmservice.annotations.MeasureCalculationTime;
import pl.pomoku.algorithmservice.dto.input.QuickSortPartitionInput;
import pl.pomoku.algorithmservice.dto.output.QuickSortPartitionOutput;
import pl.pomoku.algorithmservice.entity.QuickSortPartitionEntity;
import pl.pomoku.algorithmservice.repository.QuickSortPartitionRepository;
import pl.pomoku.algorithmservice.utils.HashUtils;

@Service
@RequiredArgsConstructor
public class QuickSortPartitionService {
    private final QuickSortPartitionRepository repository;

    @MeasureCalculationTime
    public QuickSortPartitionOutput getResult(QuickSortPartitionInput input) {
        int hash = HashUtils.hash(input.getArr());
        return repository.findByHash(hash)
                .map(QuickSortPartitionEntity::getOutput)
                .orElseGet(() -> {
                    QuickSortPartitionOutput output = QuickSortPartition.calculate(input);
                    repository.save(new QuickSortPartitionEntity(hash, input, output));
                    return output;
                });
    }
}

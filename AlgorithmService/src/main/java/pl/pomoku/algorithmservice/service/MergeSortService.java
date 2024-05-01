package pl.pomoku.algorithmservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pomoku.algorithmservice.algorithm.MergeSort;
import pl.pomoku.algorithmservice.algorithm.Partition;
import pl.pomoku.algorithmservice.annotations.MeasureCalculationTime;
import pl.pomoku.algorithmservice.dto.input.MergeSortInput;
import pl.pomoku.algorithmservice.dto.input.PartitionInput;
import pl.pomoku.algorithmservice.dto.output.MergeSortOutput;
import pl.pomoku.algorithmservice.dto.output.PartitionOutput;
import pl.pomoku.algorithmservice.entity.MergeSortEntity;
import pl.pomoku.algorithmservice.entity.PartitionEntity;
import pl.pomoku.algorithmservice.repository.MergeSortRepository;
import pl.pomoku.algorithmservice.repository.PartitionRepository;
import pl.pomoku.algorithmservice.utils.HashUtils;

@Service
@RequiredArgsConstructor
public class MergeSortService {
    private final MergeSortRepository repository;

    @MeasureCalculationTime
    public MergeSortOutput getResult(MergeSortInput input) {
        int hash = HashUtils.hash(input.getArr());
        return repository.findByHash(hash)
                .map(MergeSortEntity::getOutput)
                .orElseGet(() -> {
                    MergeSortOutput output = MergeSort.calculate(input);
                    repository.save(new MergeSortEntity(hash, input, output));
                    return output;
                });
    }
}

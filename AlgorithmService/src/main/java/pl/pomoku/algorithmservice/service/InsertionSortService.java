package pl.pomoku.algorithmservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pomoku.algorithmservice.algorithm.InsertionSort;
import pl.pomoku.algorithmservice.annotations.MeasureCalculationTime;
import pl.pomoku.algorithmservice.dto.input.InsertionSortInput;
import pl.pomoku.algorithmservice.dto.output.InsertionSortOutput;
import pl.pomoku.algorithmservice.entity.InsertionSortEntity;
import pl.pomoku.algorithmservice.repository.InsertionSortRepository;
import pl.pomoku.algorithmservice.utils.HashUtils;

@Service
@RequiredArgsConstructor
public class InsertionSortService {
    private final InsertionSortRepository repository;

    @MeasureCalculationTime
    public InsertionSortOutput getResult(InsertionSortInput input) {
        int hash = HashUtils.hash(input.getArr());
        return repository.findByHash(hash)
                .map(InsertionSortEntity::getOutput)
                .orElseGet(() -> {
                    InsertionSortOutput output = InsertionSort.calculate(input);
                    repository.save(new InsertionSortEntity(hash, input, output));
                    return output;
                });
    }
}

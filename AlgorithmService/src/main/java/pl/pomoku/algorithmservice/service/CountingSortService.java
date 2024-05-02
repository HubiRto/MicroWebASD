package pl.pomoku.algorithmservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pomoku.algorithmservice.algorithm.CountingSort;
import pl.pomoku.algorithmservice.annotations.MeasureCalculationTime;
import pl.pomoku.algorithmservice.dto.input.CountingSortInput;
import pl.pomoku.algorithmservice.dto.output.CountingSortOutput;
import pl.pomoku.algorithmservice.entity.CountingSortEntity;
import pl.pomoku.algorithmservice.repository.CountingSortRepository;
import pl.pomoku.algorithmservice.utils.HashUtils;

@Service
@RequiredArgsConstructor
public class CountingSortService {
    private final CountingSortRepository repository;

    @MeasureCalculationTime
    public CountingSortOutput getResult(CountingSortInput input) {
        int hash = HashUtils.hash(input.getArr());
        return repository.findByHash(hash)
                .map(CountingSortEntity::getOutput)
                .orElseGet(() -> {
                    CountingSortOutput output = CountingSort.calculate(input);
                    repository.save(new CountingSortEntity(hash, input, output));
                    return output;
                });
    }
}

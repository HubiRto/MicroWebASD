package pl.pomoku.algorithmservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pomoku.algorithmservice.algorithm.RadixSort;
import pl.pomoku.algorithmservice.annotations.MeasureCalculationTime;
import pl.pomoku.algorithmservice.dto.input.RadixSortInput;
import pl.pomoku.algorithmservice.dto.output.RadixSortOutput;
import pl.pomoku.algorithmservice.entity.RadixSortEntity;
import pl.pomoku.algorithmservice.repository.RadixSortRepository;
import pl.pomoku.algorithmservice.utils.HashUtils;

@Service
@RequiredArgsConstructor
public class RadixSortService {
    private final RadixSortRepository repository;

    @MeasureCalculationTime
    public RadixSortOutput getResult(RadixSortInput input) {
        int hash = HashUtils.hash(input.getArr(), input.getD());
        return repository.findByHash(hash)
                .map(RadixSortEntity::getOutput)
                .orElseGet(() -> {
                    RadixSortOutput output = RadixSort.calculate(input);
                    repository.save(new RadixSortEntity(hash, input, output));
                    return output;
                });
    }
}

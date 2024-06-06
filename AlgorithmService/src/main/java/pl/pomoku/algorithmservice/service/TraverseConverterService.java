
package pl.pomoku.algorithmservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pomoku.algorithmservice.algorithm.tree.traverseConverter.TraverseConverter;
import pl.pomoku.algorithmservice.annotations.MeasureCalculationTime;
import pl.pomoku.algorithmservice.dto.input.TraverseConverterInput;
import pl.pomoku.algorithmservice.dto.output.TraverseConverterOutput;
import pl.pomoku.algorithmservice.entity.TraverseConverterEntity;
import pl.pomoku.algorithmservice.repository.TraverseConverterRepository;
import pl.pomoku.algorithmservice.utils.HashUtils;

@Service
@RequiredArgsConstructor
public class TraverseConverterService {
    private final TraverseConverterRepository repository;

    @MeasureCalculationTime
    public TraverseConverterOutput getResult(TraverseConverterInput input) {
        int hash = HashUtils.hash(input);
        return repository.findByHash(hash)
                .map(TraverseConverterEntity::getOutput)
                .orElseGet(() -> {
                    TraverseConverterOutput output = TraverseConverter.convert(input);
                    repository.save(new TraverseConverterEntity(hash, input, output));
                    return output;
                });
    }
}

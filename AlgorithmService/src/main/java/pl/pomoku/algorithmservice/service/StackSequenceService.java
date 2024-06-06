
package pl.pomoku.algorithmservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pomoku.algorithmservice.algorithm.stackSequence.StackSequence;
import pl.pomoku.algorithmservice.annotations.MeasureCalculationTime;
import pl.pomoku.algorithmservice.dto.input.StackSequenceInput;
import pl.pomoku.algorithmservice.dto.output.StackSequenceOutput;
import pl.pomoku.algorithmservice.entity.StackSequenceEntity;
import pl.pomoku.algorithmservice.repository.StackSequenceRepository;
import pl.pomoku.algorithmservice.utils.HashUtils;

@Service
@RequiredArgsConstructor
public class StackSequenceService {
    private final StackSequenceRepository repository;

    @MeasureCalculationTime
    public StackSequenceOutput getResult(StackSequenceInput input) {
        int hash = HashUtils.hash(input);
        return repository.findByHash(hash)
                .map(StackSequenceEntity::getOutput)
                .orElseGet(() -> {
                    StackSequenceOutput output = new StackSequence(input.getInitArray()).execute(input.getElements());
                    repository.save(new StackSequenceEntity(hash, input, output));
                    return output;
                });
    }
}

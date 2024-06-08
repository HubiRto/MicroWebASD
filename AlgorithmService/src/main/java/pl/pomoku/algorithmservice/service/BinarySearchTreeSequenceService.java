package pl.pomoku.algorithmservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pomoku.algorithmservice.algorithm.tree.bst.BinarySearchTreeSequence;
import pl.pomoku.algorithmservice.annotations.MeasureCalculationTime;
import pl.pomoku.algorithmservice.dto.input.BinarySearchTreeSequenceInput;
import pl.pomoku.algorithmservice.dto.output.BinarySearchTreeSequenceOutput;
import pl.pomoku.algorithmservice.entity.BinarySearchTreeSequenceEntity;
import pl.pomoku.algorithmservice.repository.BinarySearchTreeSequenceRepository;
import pl.pomoku.algorithmservice.utils.HashUtils;

@Service
@RequiredArgsConstructor
public class BinarySearchTreeSequenceService {
    private final BinarySearchTreeSequenceRepository repository;

    @MeasureCalculationTime
    public BinarySearchTreeSequenceOutput getResult(BinarySearchTreeSequenceInput input) {
        int hash = HashUtils.hash(input);
        return repository.findByHash(hash)
                .map(BinarySearchTreeSequenceEntity::getOutput)
                .orElseGet(() -> {
                    BinarySearchTreeSequenceOutput output = new BinarySearchTreeSequence(input.getInitArray()).calculate(input.getOperations());
                    repository.save(new BinarySearchTreeSequenceEntity(hash, input, output));
                    return output;
                });
    }
}

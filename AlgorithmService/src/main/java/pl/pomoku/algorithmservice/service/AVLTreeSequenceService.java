package pl.pomoku.algorithmservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pomoku.algorithmservice.algorithm.tree.avl.AVLTreeSequence;
import pl.pomoku.algorithmservice.annotations.MeasureCalculationTime;
import pl.pomoku.algorithmservice.dto.input.AVLTreeSequenceInput;
import pl.pomoku.algorithmservice.dto.output.AVLTreeSequenceOutput;
import pl.pomoku.algorithmservice.entity.AVLTreeSequenceEntity;
import pl.pomoku.algorithmservice.repository.AVLTreeSequenceRepository;
import pl.pomoku.algorithmservice.utils.HashUtils;

@Service
@RequiredArgsConstructor
public class AVLTreeSequenceService {
    private final AVLTreeSequenceRepository repository;

    @MeasureCalculationTime
    public AVLTreeSequenceOutput getResult(AVLTreeSequenceInput input) {
        int hash = HashUtils.hash(input);
        return repository.findByHash(hash)
                .map(AVLTreeSequenceEntity::getOutput)
                .orElseGet(() -> {
                    AVLTreeSequenceOutput output = new AVLTreeSequence(input.getInitArray()).calculate(input.getOperations());
                    repository.save(new AVLTreeSequenceEntity(hash, input, output));
                    return output;
                });
    }
}

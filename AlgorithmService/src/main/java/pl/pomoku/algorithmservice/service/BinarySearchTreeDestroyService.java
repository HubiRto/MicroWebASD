package pl.pomoku.algorithmservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pomoku.algorithmservice.algorithm.tree.bst.BinarySearchTreeDestroy;
import pl.pomoku.algorithmservice.annotations.MeasureCalculationTime;
import pl.pomoku.algorithmservice.dto.input.BinarySearchTreeDestroyInput;
import pl.pomoku.algorithmservice.dto.output.BinarySearchTreeDestroyOutput;
import pl.pomoku.algorithmservice.entity.BinarySearchTreeDestroyEntity;
import pl.pomoku.algorithmservice.repository.BinarySearchTreeDestroyRepository;
import pl.pomoku.algorithmservice.utils.HashUtils;

@Service
@RequiredArgsConstructor
public class BinarySearchTreeDestroyService {
    private final BinarySearchTreeDestroyRepository repository;

    @MeasureCalculationTime
    public BinarySearchTreeDestroyOutput getResult(BinarySearchTreeDestroyInput input) {
        int hash = HashUtils.hash(input.getInitArray(), input.getRemoveArray());
        return repository.findByHash(hash)
                .map(BinarySearchTreeDestroyEntity::getOutput)
                .orElseGet(() -> {
                    BinarySearchTreeDestroyOutput output = BinarySearchTreeDestroy.calculate(input);
                    repository.save(new BinarySearchTreeDestroyEntity(hash, input, output));
                    return output;
                });
    }
}

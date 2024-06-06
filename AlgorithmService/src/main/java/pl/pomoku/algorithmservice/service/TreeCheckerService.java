
package pl.pomoku.algorithmservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pomoku.algorithmservice.algorithm.tree.treeChecker.TreeChecker;
import pl.pomoku.algorithmservice.annotations.MeasureCalculationTime;
import pl.pomoku.algorithmservice.dto.input.TreeCheckerInput;
import pl.pomoku.algorithmservice.dto.output.TreeCheckerOutput;
import pl.pomoku.algorithmservice.entity.TreeCheckerEntity;
import pl.pomoku.algorithmservice.repository.TreeCheckerRepository;
import pl.pomoku.algorithmservice.utils.HashUtils;

@Service
@RequiredArgsConstructor
public class TreeCheckerService {
    private final TreeCheckerRepository repository;

    @MeasureCalculationTime
    public TreeCheckerOutput getResult(TreeCheckerInput input) {
        int hash = HashUtils.hash(input.getTree());
        return repository.findByHash(hash)
                .map(TreeCheckerEntity::getOutput)
                .orElseGet(() -> {
                    TreeCheckerOutput output = new TreeChecker(input.getTree()).calculate();
                    repository.save(new TreeCheckerEntity(hash, input, output));
                    return output;
                });
    }
}

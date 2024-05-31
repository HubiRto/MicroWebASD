package pl.pomoku.algorithmservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pomoku.algorithmservice.algorithm.DepthFirstSearch;
import pl.pomoku.algorithmservice.annotations.MeasureCalculationTime;
import pl.pomoku.algorithmservice.dto.input.FirstSearchInput;
import pl.pomoku.algorithmservice.dto.output.FirstSearchOutput;
import pl.pomoku.algorithmservice.entity.DepthFirstSearchEntity;
import pl.pomoku.algorithmservice.repository.DepthFirstSearchRepository;
import pl.pomoku.algorithmservice.utils.HashUtils;

@Service
@RequiredArgsConstructor
public class DepthFirstSearchService {
    private final DepthFirstSearchRepository repository;

    @MeasureCalculationTime
    public FirstSearchOutput getResult(FirstSearchInput input) {
        int hash = HashUtils.hash(input.getGraph(), input.getStartIndex());
        return repository.findByHash(hash)
                .map(DepthFirstSearchEntity::getOutput)
                .orElseGet(() -> {
                    FirstSearchOutput output = new DepthFirstSearch().calculate(input);
                    repository.save(new DepthFirstSearchEntity(hash, input, output));
                    return output;
                });
    }
}

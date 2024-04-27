package pl.pomoku.algorithmservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.pomoku.algorithmservice.algorithm.BinSearch;
import pl.pomoku.algorithmservice.dto.input.BinSearchInput;
import pl.pomoku.algorithmservice.dto.output.BinSearchOutput;
import pl.pomoku.algorithmservice.entity.binSearch.BinSearchEntity;
import pl.pomoku.algorithmservice.repository.BinSearchRepository;
import pl.pomoku.algorithmservice.utils.HashUtils;

@Service
@RequiredArgsConstructor
public class BinSearchService {
    private final BinSearchRepository repository;

    public BinSearchOutput getResult(BinSearchInput input) {
        int hash = HashUtils.hash(input.getArr(), input.getX());
        return repository.findByHash(hash)
                .map(BinSearchEntity::getOutput)
                .orElseGet(() -> {
                    BinSearchOutput output = BinSearch.calculate(input);
                    repository.save(new BinSearchEntity(hash, input, output));
                    return output;
                });
    }
}

package pl.pomoku.algorithmservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pomoku.algorithmservice.annotations.MeasureCalculationTime;
import pl.pomoku.algorithmservice.dto.input.BinSearchInput;
import pl.pomoku.algorithmservice.dto.input.HoarePartitionInput;
import pl.pomoku.algorithmservice.dto.input.PartitionInput;
import pl.pomoku.algorithmservice.service.BinSearchService;
import pl.pomoku.algorithmservice.service.HoarePartitionService;
import pl.pomoku.algorithmservice.service.PartitionService;

@RestController
@RequestMapping("/api/v1/algorithm")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AlgorithmController {
    private final BinSearchService binSearchService;
    private final PartitionService partitionService;
    private final HoarePartitionService hoarePartitionService;

    @MeasureCalculationTime
    @PostMapping("/binary-search")
    public ResponseEntity<?> binSearch(@Valid @RequestBody BinSearchInput input) {
        return ResponseEntity.ok(binSearchService.getResult(input).getResponse());
    }

    @PostMapping("/partition")
    public ResponseEntity<?> partition(@Valid @RequestBody PartitionInput input) {
        return ResponseEntity.ok(partitionService.getResult(input).getResponse());
    }

    @PostMapping("/hoare-partition")
    public ResponseEntity<?> hoarePartition(@Valid @RequestBody HoarePartitionInput input) {
        return ResponseEntity.ok(hoarePartitionService.getResult(input).getResponse());
    }
}

package pl.pomoku.algorithmservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pomoku.algorithmservice.dto.input.BinSearchInput;
import pl.pomoku.algorithmservice.dto.input.HoarePartitionInput;
import pl.pomoku.algorithmservice.dto.input.PartitionInput;
import pl.pomoku.algorithmservice.service.BinSearchService;
import pl.pomoku.algorithmservice.service.HoarePartitionService;
import pl.pomoku.algorithmservice.service.PartitionService;

@RestController
@RequestMapping("/api/v1/algorithm")
@RequiredArgsConstructor
public class AlgorithmController {
    private final BinSearchService binSearchService;
    private final PartitionService partitionService;
    private final HoarePartitionService hoarePartitionService;

    @GetMapping("/binary-search")
    public ResponseEntity<?> binSearch(@Valid @RequestBody BinSearchInput input){
        return ResponseEntity.ok(binSearchService.getResult(input));
    }

    @GetMapping("/partition")
    public ResponseEntity<?> partition(@Valid @RequestBody PartitionInput input){
        return ResponseEntity.ok(partitionService.getResult(input));
    }

    @GetMapping("/hoare-partition")
    public ResponseEntity<?> hoarePartition(@Valid @RequestBody HoarePartitionInput input){
        return ResponseEntity.ok(hoarePartitionService.getResult(input));
    }
}

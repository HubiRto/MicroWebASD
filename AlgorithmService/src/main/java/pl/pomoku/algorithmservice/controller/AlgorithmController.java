package pl.pomoku.algorithmservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pomoku.algorithmservice.dto.input.*;
import pl.pomoku.algorithmservice.service.*;

@RestController
@RequestMapping("/api/v1/algorithm")
@RequiredArgsConstructor
public class AlgorithmController {
    private final BinSearchService binSearchService;
    private final PartitionService partitionService;
    private final HoarePartitionService hoarePartitionService;
    private final TraverseConverterService traverseConverterService;
    private final TreeCheckerService treeCheckerService;
    private final StackSequenceService stackSequenceService;
    private final BinarySearchTreeDestroyService binarySearchTreeDestroyService;
    private final BinarySearchTreeSequenceService binarySearchTreeSequenceService;

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

    @PostMapping("/traverse-converter")
    public ResponseEntity<?> traverseConverter(@Valid @RequestBody TraverseConverterInput input) {
        return ResponseEntity.ok(traverseConverterService.getResult(input).getResponse());
    }

    @PostMapping("/stack-sequence")
    public ResponseEntity<?> stackSequence(@Valid @RequestBody StackSequenceInput input) {
        return ResponseEntity.ok(stackSequenceService.getResult(input).getResponse());
    }

    @PostMapping("/tree-checker")
    public ResponseEntity<?> treeChecker(@Valid @RequestBody TreeCheckerInput input) {
        return ResponseEntity.ok(treeCheckerService.getResult(input).getResponse());
    }

    @PostMapping("/binary-serach-tree-destroy")
    public ResponseEntity<?> binarySearchTreeDestroy(@Valid @RequestBody BinarySearchTreeDestroyInput input) {
        return ResponseEntity.ok(binarySearchTreeDestroyService.getResult(input).getResponse());
    }

    @PostMapping("/binary-serach-tree-sequence")
    public ResponseEntity<?> binarySearchTreeSequence(@Valid @RequestBody BinarySearchTreeSequenceInput input) {
        return ResponseEntity.ok(binarySearchTreeSequenceService.getResult(input).getResponse());
    }
}

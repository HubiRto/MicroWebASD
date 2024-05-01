package pl.pomoku.algorithmservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pomoku.algorithmservice.annotations.Testt;
import pl.pomoku.algorithmservice.dto.input.BinSearchInput;
import pl.pomoku.algorithmservice.dto.input.HoarePartitionInput;
import pl.pomoku.algorithmservice.dto.input.PartitionInput;
import pl.pomoku.algorithmservice.dto.output.BinSearchOutput;
import pl.pomoku.algorithmservice.dto.output.HoarePartitionOutput;
import pl.pomoku.algorithmservice.dto.output.PartitionOutput;
import pl.pomoku.algorithmservice.dto.response.CalculateResponse;
import pl.pomoku.algorithmservice.service.BinSearchService;
import pl.pomoku.algorithmservice.service.HoarePartitionService;
import pl.pomoku.algorithmservice.service.PartitionService;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/algorithm")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AlgorithmController {
    private final BinSearchService binSearchService;
    private final PartitionService partitionService;
    private final HoarePartitionService hoarePartitionService;

    @Testt
    @PostMapping("/binary-search")
    public ResponseEntity<?> binSearch(@Valid @RequestBody BinSearchInput input) {
        long start = System.currentTimeMillis();
        BinSearchOutput output = binSearchService.getResult(input);
        long end = System.currentTimeMillis() - start;

        return ResponseEntity.ok(CalculateResponse.builder()
                .timestamp(LocalDateTime.now())
                .calculateTimeMilSec(end)
                .data(Map.of("result", output))
                .build());
    }

    @PostMapping("/partition")
    public ResponseEntity<?> partition(@Valid @RequestBody PartitionInput input) {
        long start = System.currentTimeMillis();
        PartitionOutput output = partitionService.getResult(input);
        long end = System.currentTimeMillis() - start;

        return ResponseEntity.ok(CalculateResponse.builder()
                .timestamp(LocalDateTime.now())
                .calculateTimeMilSec(end)
                .data(Map.of("result", output))
                .build());
    }

    @PostMapping("/hoare-partition")
    public ResponseEntity<?> hoarePartition(@Valid @RequestBody HoarePartitionInput input) {
        long start = System.currentTimeMillis();
        HoarePartitionOutput output = hoarePartitionService.getResult(input);
        long end = System.currentTimeMillis() - start;

        return ResponseEntity.ok(CalculateResponse.builder()
                .timestamp(LocalDateTime.now())
                .calculateTimeMilSec(end)
                .data(Map.of("result", output))
                .build());
    }
}

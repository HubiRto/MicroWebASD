package pl.pomoku.algorithmservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
public class AlgorithmController {
    private final BinSearchService binSearchService;
    private final PartitionService partitionService;
    private final HoarePartitionService hoarePartitionService;

    @GetMapping("/binary-search")
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

    @GetMapping("/partition")
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

    @GetMapping("/hoare-partition")
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

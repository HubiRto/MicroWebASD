package pl.pomoku.algorithmservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pomoku.algorithmservice.dto.input.CountingSortInput;
import pl.pomoku.algorithmservice.dto.input.InsertionSortInput;
import pl.pomoku.algorithmservice.dto.input.MergeSortInput;
import pl.pomoku.algorithmservice.service.CountingSortService;
import pl.pomoku.algorithmservice.service.InsertionSortService;
import pl.pomoku.algorithmservice.service.MergeSortService;

@RestController
@RequestMapping("/api/v1/algorithm/sort")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class SortersController {
    private final MergeSortService mergeSortService;
    private final InsertionSortService insertionSortService;
    private final CountingSortService countingSortService;

    @PostMapping("/merge-sort")
    public ResponseEntity<?> mergeSort(@Valid @RequestBody MergeSortInput input) {
        return ResponseEntity.ok(mergeSortService.getResult(input).getResponse());
    }

    @PostMapping("/insertion-sort")
    public ResponseEntity<?> insertionSort(@Valid @RequestBody InsertionSortInput input) {
        return ResponseEntity.ok(insertionSortService.getResult(input).getResponse());
    }

    @PostMapping("/counting-sort")
    public ResponseEntity<?> countingSort(@Valid @RequestBody CountingSortInput input) {
        return ResponseEntity.ok(countingSortService.getResult(input).getResponse());
    }
}

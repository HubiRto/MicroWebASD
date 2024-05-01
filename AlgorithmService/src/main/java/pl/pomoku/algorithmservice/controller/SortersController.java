package pl.pomoku.algorithmservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pomoku.algorithmservice.dto.input.MergeSortInput;
import pl.pomoku.algorithmservice.service.MergeSortService;

@RestController
@RequestMapping("/api/v1/algorithm/sort")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class SortersController {
    private final MergeSortService mergeSortService;
    @PostMapping("/merge-sort")
    public ResponseEntity<?> mergeSort(@Valid @RequestBody MergeSortInput input) {
        return ResponseEntity.ok(mergeSortService.getResult(input).getResponse());
    }
}

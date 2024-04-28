package pl.pomoku.algorithmservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pomoku.algorithmservice.algorithm.BinSearch;
import pl.pomoku.algorithmservice.dto.input.BinSearchInput;
import pl.pomoku.algorithmservice.service.BinSearchService;

@RestController
@RequestMapping("/api/v1/algorithm")
@RequiredArgsConstructor
public class AlgorithmController {
    private final BinSearchService binSearchService;

    @PostMapping("/binary-search")
    public ResponseEntity<?> binSearch(@Valid @RequestBody BinSearchInput input){
        return ResponseEntity.ok(binSearchService.getResult(input));
    }
}

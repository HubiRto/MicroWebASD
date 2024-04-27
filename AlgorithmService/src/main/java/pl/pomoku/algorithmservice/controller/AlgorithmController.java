package pl.pomoku.algorithmservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pomoku.algorithmservice.algorithm.BinSearch;
import pl.pomoku.algorithmservice.dto.input.BinSearchInput;
import pl.pomoku.algorithmservice.service.BinSearchService;

@RestController
@RequestMapping("/api/v1/algorithm")
@RequiredArgsConstructor
public class AlgorithmController {
    private final BinSearchService binSearchService;
    @GetMapping("/hoare-partition")
    public ResponseEntity<?> hoarePartition(){
        return null;
    }

    @GetMapping("/binary-search")
    public ResponseEntity<?> binSearch(@Valid @RequestBody BinSearchInput input){
        return ResponseEntity.ok(binSearchService.getResult(input));
    }
}

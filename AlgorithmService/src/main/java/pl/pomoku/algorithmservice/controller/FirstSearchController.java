package pl.pomoku.algorithmservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pomoku.algorithmservice.dto.input.DepthFirstSearchInput;
import pl.pomoku.algorithmservice.service.DepthFirstSearchService;

@RestController
@RequestMapping("/api/v1/algorithm/first-search")
@RequiredArgsConstructor
public class FirstSearchController {
    private final DepthFirstSearchService depthFirstSearchService;

    @PostMapping("/merge-sort")
    public ResponseEntity<?> depthFirstSearch(@Valid @RequestBody DepthFirstSearchInput input) {
        return ResponseEntity.ok(depthFirstSearchService.getResult(input).getResponse());
    }
}

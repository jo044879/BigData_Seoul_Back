package org.example.bigdata_seoul_back.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.bigdata_seoul_back.Dto.SeoulDataRequestDto;
import org.example.bigdata_seoul_back.Dto.SeoulDataResponseDto;
import org.example.bigdata_seoul_back.Service.SeoulDataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seoul-data")
@RequiredArgsConstructor
public class SeoulDataController {

    private final SeoulDataService seoulDataService;

    @PostMapping
    public ResponseEntity<SeoulDataResponseDto> save(@Valid @RequestBody SeoulDataRequestDto requestDto) {
        return ResponseEntity.ok(seoulDataService.save(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<SeoulDataResponseDto>> findAll() {
        return ResponseEntity.ok(seoulDataService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeoulDataResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(seoulDataService.findById(id));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<SeoulDataResponseDto>> findByCategory(@PathVariable String category) {
        return ResponseEntity.ok(seoulDataService.findByCategory(category));
    }
}

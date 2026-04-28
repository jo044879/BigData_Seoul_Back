package org.example.bigdata_seoul_back.Service;

import lombok.RequiredArgsConstructor;
import org.example.bigdata_seoul_back.Domain.SeoulData;
import org.example.bigdata_seoul_back.Dto.SeoulDataRequestDto;
import org.example.bigdata_seoul_back.Dto.SeoulDataResponseDto;
import org.example.bigdata_seoul_back.Repository.SeoulDataRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SeoulDataService {

    private final SeoulDataRepository seoulDataRepository;

    @Transactional
    public SeoulDataResponseDto save(SeoulDataRequestDto requestDto) {
        SeoulData saved = seoulDataRepository.save(requestDto.toEntity());
        return new SeoulDataResponseDto(saved);
    }

    public List<SeoulDataResponseDto> findAll() {
        return seoulDataRepository.findAll().stream()
                .map(SeoulDataResponseDto::new)
                .toList();
    }

    public SeoulDataResponseDto findById(Long id) {
        SeoulData seoulData = seoulDataRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 데이터가 없습니다. id=" + id));
        return new SeoulDataResponseDto(seoulData);
    }

    public List<SeoulDataResponseDto> findByCategory(String category) {
        return seoulDataRepository.findByCategory(category).stream()
                .map(SeoulDataResponseDto::new)
                .toList();
    }
}

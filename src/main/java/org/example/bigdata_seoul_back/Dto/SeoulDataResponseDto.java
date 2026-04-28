package org.example.bigdata_seoul_back.Dto;

import lombok.Getter;
import org.example.bigdata_seoul_back.Domain.SeoulData;

@Getter
public class SeoulDataResponseDto {

    private final Long id;
    private final String title;
    private final String content;
    private final String category;

    public SeoulDataResponseDto(SeoulData seoulData) {
        this.id = seoulData.getId();
        this.title = seoulData.getTitle();
        this.content = seoulData.getContent();
        this.category = seoulData.getCategory();
    }
}

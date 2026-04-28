package org.example.bigdata_seoul_back.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.example.bigdata_seoul_back.Domain.SeoulData;

@Getter
public class SeoulDataRequestDto {

    @NotBlank(message = "제목은 필수입니다.")
    private String title;

    private String content;

    @NotBlank(message = "카테고리는 필수입니다.")
    private String category;

    public SeoulData toEntity() {
        return SeoulData.builder()
                .title(title)
                .content(content)
                .category(category)
                .build();
    }
}

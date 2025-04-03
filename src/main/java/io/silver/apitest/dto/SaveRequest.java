package io.silver.apitest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveRequest {
    private String title;
    private String actor;
    private String contents;
}

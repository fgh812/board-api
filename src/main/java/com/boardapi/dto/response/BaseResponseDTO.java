package com.boardapi.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponseDTO {
    private String message;

    public BaseResponseDTO() {
        this.message = "성공";
    }

    public BaseResponseDTO(String message) {
        this.message = message;
    }
}

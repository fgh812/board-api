package com.boardapi.dto.response;

import com.boardapi.dto.BoardResultDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardDetailResponseDTO extends BaseResponseDTO {
    BoardResultDTO boardResultDTO;

    public BoardDetailResponseDTO(String message) {
        super(message);
    }
}

package com.boardapi.dto.response;

import com.boardapi.dto.BoardResultDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BoardListResponseDTO extends BaseResponseDTO {
    List<BoardResultDTO> boardResultDTOList;

    public BoardListResponseDTO(String message) {
        super(message);
    }
}

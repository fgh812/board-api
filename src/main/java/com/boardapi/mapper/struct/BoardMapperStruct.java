package com.boardapi.mapper.struct;

import com.boardapi.dto.*;
import com.boardapi.dto.request.*;
import com.boardapi.model.BoardConditionVO;
import com.boardapi.model.BoardResultVO;
import org.mapstruct.Mapper;
import java.util.List;

import static org.mapstruct.NullValueMappingStrategy.RETURN_NULL;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = IGNORE, nullValueMappingStrategy = RETURN_NULL)
public interface BoardMapperStruct {

    /* DTO -> VO */
    BoardConditionVO toBoardConditionVO(BoardDetailRequestDTO dto);
    BoardConditionVO toBoardConditionVO(BoardCreateRequestDTO dto);
    BoardConditionVO toBoardConditionVO(BoardUpdateRequestDTO dto);
    BoardConditionVO toBoardConditionVO(BoardDeleteRequestDTO dto);
    BoardConditionVO toBoardConditionVO(BoardUpdateRecmmRequestDTO dto);

    /* VO -> DTO */
    BoardResultDTO toBoardResultDTO (BoardResultVO resultVO);
    List<BoardResultDTO> toBoardResultDTOList (List<BoardResultVO> resultVOList);

}

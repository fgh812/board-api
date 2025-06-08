package com.boardapi.service;

import com.boardapi.dao.BoardDAO;
import com.boardapi.dto.request.*;
import com.boardapi.dto.response.BoardDetailResponseDTO;
import com.boardapi.dto.response.BoardListResponseDTO;
import com.boardapi.mapper.struct.BoardMapperStruct;
import com.boardapi.model.BoardConditionVO;
import com.boardapi.model.BoardResultVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardDAO boardDAO;

    private final BoardMapperStruct boardMapperStruct;


    /**
     * 목록 조회
     * @return
     */
    public BoardListResponseDTO selectFreeBoardList() {
        BoardListResponseDTO responseDTO = new BoardListResponseDTO();

        List<BoardResultVO> resultVOList = boardDAO.selectFreeBoardList();
        responseDTO.setBoardResultDTOList(boardMapperStruct.toBoardResultDTOList(resultVOList));

        return responseDTO;
    }

    /**
     * 상세 조회
     * @param dto
     * @return
     */
    public BoardDetailResponseDTO selectFreeBoardDetail(BoardDetailRequestDTO dto) {
        BoardDetailResponseDTO responseDTO = new BoardDetailResponseDTO();

        BoardResultVO resultVO = boardDAO.selectFreeBoardDetail(boardMapperStruct.toBoardConditionVO(dto));
        if (resultVO.getRecmmCnt() != null && resultVO.getRecmmCnt() > 5) {
            resultVO.setTitle("[베스트 추천] " + resultVO.getTitle());
        }
        responseDTO.setBoardResultDTO(boardMapperStruct.toBoardResultDTO(resultVO));

        return responseDTO;
    }

    /**
     * 등록
     * @param dto
     */
    public void insertFreeBoard(BoardCreateRequestDTO dto) {
        BoardConditionVO boardVO = boardMapperStruct.toBoardConditionVO(dto);
        boardVO.setRegDt(LocalDateTime.now());

        boardDAO.insertFreeBoard(boardVO);
    }

    /**
     * 수정
     * @param dto
     */
    public void updateFreeBoard(BoardUpdateRequestDTO dto) {
        BoardConditionVO boardVO = boardMapperStruct.toBoardConditionVO(dto);
        boardVO.setUpDt(LocalDateTime.now());

        boardDAO.updateFreeBoard(boardVO);
    }

    public void deleteFreeBoard(BoardDeleteRequestDTO dto) {
        BoardConditionVO boardVO = boardMapperStruct.toBoardConditionVO(dto);

        boardDAO.deleteFreeBoard(boardVO);
    }


    // TODO. 추천 수 증가
    public void updateFreeBoardRecmmCnt(BoardUpdateRecmmRequestDTO dto) {
        BoardConditionVO boardVO = boardMapperStruct.toBoardConditionVO(dto);

        boardDAO.updateFreeBoardRecmmCnt(boardVO);
    }

}

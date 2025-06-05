package com.boardapi.service;

import com.boardapi.dao.BoardDAO;
import com.boardapi.dto.BoardResultDTO;
import com.boardapi.dto.request.*;
import com.boardapi.dto.response.BoardDetailResponseDTO;
import com.boardapi.dto.response.BoardListResponseDTO;
import com.boardapi.model.BoardConditionVO;
import com.boardapi.model.BoardResultVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardDAO boardDAO;


    /**
     * 목록 조회
     * @return
     */
    public BoardListResponseDTO selectFreeBoardList() {
        BoardListResponseDTO responseDTO = new BoardListResponseDTO();

        List<BoardResultVO> resultVOList = boardDAO.selectFreeBoardList();
        List<BoardResultDTO> resultDTOList = new ArrayList<>();

        for (BoardResultVO resultVO : resultVOList) {
            BoardResultDTO resultDTO = new BoardResultDTO();
            resultDTO.setId(resultVO.getId());
            resultDTO.setTitle(resultVO.getTitle());
            resultDTO.setContent(resultVO.getContent());
            resultDTO.setRecmmCnt(resultVO.getRecmmCnt());
            resultDTO.setRegId(resultVO.getRegId());
            resultDTO.setRegDt(resultVO.getRegDt());
            resultDTO.setUpId(resultVO.getUpId());
            resultDTO.setUpDt(resultVO.getUpDt());

            resultDTOList.add(resultDTO);
        }
        responseDTO.setBoardResultDTOList(resultDTOList);

        return responseDTO;
    }

    /**
     * 상세 조회
     * @param dto
     * @return
     */
    public BoardDetailResponseDTO selectFreeBoardDetail(BoardDetailRequestDTO dto) {
        BoardDetailResponseDTO responseDTO = new BoardDetailResponseDTO();
        BoardConditionVO boardVO = new BoardConditionVO();
        boardVO.setId(dto.getId());

        BoardResultVO resultVO = boardDAO.selectFreeBoardDetail(boardVO);
        if (resultVO.getRecmmCnt() > 5) {
            resultVO.setTitle("[베스트 추천] " + resultVO.getTitle());
        }

        BoardResultDTO resultDTO = new BoardResultDTO();
        resultDTO.setId(resultVO.getId());
        resultDTO.setTitle(resultVO.getTitle());
        resultDTO.setContent(resultVO.getContent());
        resultDTO.setRecmmCnt(resultVO.getRecmmCnt());
        resultDTO.setRegId(resultVO.getRegId());
        resultDTO.setRegDt(resultVO.getRegDt());
        resultDTO.setUpId(resultVO.getUpId());
        resultDTO.setUpDt(resultVO.getUpDt());

        responseDTO.setBoardResultDTO(resultDTO);

        return responseDTO;
    }

    /**
     * 등록
     * @param dto
     */
    public void insertFreeBoard(BoardCreateRequestDTO dto) {
        BoardConditionVO boardVO = new BoardConditionVO();
        boardVO.setTitle(dto.getTitle());
        boardVO.setContent(dto.getContent());
        boardVO.setRegId(dto.getRegId());
        boardVO.setRegDt(LocalDateTime.now());

        boardDAO.insertFreeBoard(boardVO);
    }

    /**
     * 수정
     * @param dto
     */
    public void updateFreeBoard(BoardUpdateRequestDTO dto) {
        BoardConditionVO boardVO = new BoardConditionVO();
        boardVO.setId(dto.getId());
        boardVO.setTitle(dto.getTitle());
        boardVO.setContent(dto.getContent());
        boardVO.setUpId(dto.getUpId());
        boardVO.setUpDt(LocalDateTime.now());
        
        boardDAO.updateFreeBoard(boardVO);
    }

    public void deleteFreeBoard(BoardDeleteRequestDTO dto) {
        BoardConditionVO boardVO = new BoardConditionVO();
        boardVO.setId(dto.getId());

        boardDAO.deleteFreeBoard(boardVO);
    }

    
    // TODO. 추천 수 증가
    public void updateFreeBoardRecmmCnt() { }

}

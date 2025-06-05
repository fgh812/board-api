package com.boardapi.dao;

import com.boardapi.mapper.BoardMapper;
import com.boardapi.model.BoardConditionVO;
import com.boardapi.model.BoardResultVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardDAO {

    private final BoardMapper boardMapper;


    public List<BoardResultVO> selectFreeBoardList() { return boardMapper.selectFreeBoardList(); };

    public BoardResultVO selectFreeBoardDetail(BoardConditionVO boardVO) { return boardMapper.selectFreeBoardDetail(boardVO); };

    public void insertFreeBoard(BoardConditionVO boardVO) {
        boardMapper.insertFreeBoard(boardVO);
    };

    public void updateFreeBoard(BoardConditionVO boardVO) {
        boardMapper.updateFreeBoard(boardVO);
    };

    public void deleteFreeBoard(BoardConditionVO boardVO) {
        boardMapper.deleteFreeBoard(boardVO);
    };

    // TODO. 추천 수 증가
}

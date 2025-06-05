package com.boardapi.mapper;

import com.boardapi.model.BoardResultVO;
import com.boardapi.model.BoardConditionVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardResultVO> selectFreeBoardList();
    BoardResultVO selectFreeBoardDetail(BoardConditionVO boardVO);
    void insertFreeBoard(BoardConditionVO boardVO);
    void updateFreeBoard(BoardConditionVO boardVO);
    void deleteFreeBoard(BoardConditionVO boardVO);
    // TODO. 추천 수 증가
}

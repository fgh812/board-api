package com.boardapi.controller;

import com.boardapi.dto.request.*;
import com.boardapi.dto.response.BaseResponseDTO;
import com.boardapi.dto.response.BoardDetailResponseDTO;
import com.boardapi.dto.response.BoardListResponseDTO;
import com.boardapi.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/board")
@RequiredArgsConstructor
@Slf4j
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/free/list")
    public ResponseEntity<BoardListResponseDTO> selectFreeBoardList() {
        BoardListResponseDTO responseDTO = new BoardListResponseDTO();

        try {
            responseDTO = boardService.selectFreeBoardList();
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new BoardListResponseDTO(e.getMessage()));
        }
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/free/detail/{id}")
    public ResponseEntity<BoardDetailResponseDTO> selectFreeBoardDetail(@PathVariable Long id) {
        BoardDetailResponseDTO responseDTO = new BoardDetailResponseDTO();
        BoardDetailRequestDTO dto = new BoardDetailRequestDTO();
        dto.setId(id);

        try {
            responseDTO = boardService.selectFreeBoardDetail(dto);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new BoardDetailResponseDTO(e.getMessage()));
        }
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping("/free/create")
    public ResponseEntity<BaseResponseDTO> insertFreeBoard(@RequestBody BoardCreateRequestDTO dto) {
        try {
            boardService.insertFreeBoard(dto);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new BaseResponseDTO(e.getMessage()));
        }
        return ResponseEntity.ok().body(new BaseResponseDTO());
    }

    @PutMapping("/free/update")
    public ResponseEntity<BaseResponseDTO> updateFreeBoard(@RequestBody BoardUpdateRequestDTO dto) {
        try {
            boardService.updateFreeBoard(dto);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new BaseResponseDTO(e.getMessage()));
        }
        return ResponseEntity.ok().body(new BaseResponseDTO());
    }

    @DeleteMapping("/free/delete")
    public ResponseEntity<BaseResponseDTO> deleteFreeBoard(@RequestBody BoardDeleteRequestDTO dto) {
        try {
            boardService.deleteFreeBoard(dto);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new BaseResponseDTO(e.getMessage()));
        }
        return ResponseEntity.ok().body(new BaseResponseDTO());
    }

    // TODO. 추천 수 증가
    @PutMapping("/free/update/recmmCnt")
    public ResponseEntity<BaseResponseDTO> updateFreeBoardRecmmCnt(@RequestBody BoardUpdateRecmmRequestDTO dto) {
        try {
            boardService.updateFreeBoardRecmmCnt(dto);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new BaseResponseDTO(e.getMessage()));
        }
        return ResponseEntity.ok().body(new BaseResponseDTO());
    }
}

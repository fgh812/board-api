package com.boardapi.dto.request;

import lombok.Getter;

@Getter
public class BoardUpdateRequestDTO {
    private Long id;
    private String title;
    private String content;
    private String upId;
}

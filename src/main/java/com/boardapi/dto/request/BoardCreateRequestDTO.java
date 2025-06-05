package com.boardapi.dto.request;


import lombok.Getter;

@Getter
public class BoardCreateRequestDTO {
    private String title;
    private String content;
    private String regId;
}

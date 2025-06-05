package com.boardapi.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BoardConditionVO {
    private Long id;
    private String title;
    private String content;
    private Long recmmCnt;
    private String regId;
    private LocalDateTime regDt;
    private String upId;
    private LocalDateTime upDt;
}

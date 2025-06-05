package com.boardapi.model;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class BoardResultVO {
    private Long id;
    private String title;
    private String content;
    private Long recmmCnt;
    private String regId;
    private LocalDateTime regDt;
    private String upId;
    private LocalDateTime upDt;
}

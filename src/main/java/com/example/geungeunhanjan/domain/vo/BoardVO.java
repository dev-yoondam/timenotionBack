package com.example.geungeunhanjan.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Data
public class BoardVO {
    private Long boardId;
    private String boardTitle;
    private String boardContent;
    private boolean boardPublic;
    private LocalDateTime boardCreatedDate;
    private LocalDateTime boardUpdatedDate;
    private int boardViewCount;
    private String boardLifeCycle;
    private int boardLikeCount;
    private Long userId;
}
package com.example.myboard.dto;

import com.example.myboard.entity.Board;
import lombok.Builder;
import lombok.Data;

import java.util.List;


public class GetBoardDto {

    @Data
    @Builder
    public static class Response{
        private List<Board> boardList;


    }
    @Data
    @Builder
    public static class Board{
        private Long id;
        private String title;
        private String content;
    }
}

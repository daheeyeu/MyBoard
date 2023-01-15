package com.example.myboard.dto;

import lombok.Builder;
import lombok.Data;

public class TestDetailDto {
    @Data
    @Builder
    public static class Response{

        private Long id;
        private String title;
        private  String content;
    }

}

package com.example.myboard.dto;

import lombok.Getter;

public class CreateBoardDto {

    @Getter
    public static class Request{
        private String title;

        private String content;
    }
}

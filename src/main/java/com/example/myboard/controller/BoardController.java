package com.example.myboard.controller;


import com.example.myboard.dto.CreateBoardDto;
import com.example.myboard.dto.GetBoardDto;
import com.example.myboard.dto.TestDetailDto;
import com.example.myboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService; // bean 등록

    @PostMapping
    public ResponseEntity<Void> createBoard(@RequestBody CreateBoardDto.Request request){
        boardService.createBoard(request);
     return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity<GetBoardDto.Response> getBoard(){
        return  ResponseEntity.status(HttpStatus.OK).body(boardService.getBoardList());
    }

    @GetMapping("{boardId}")
    public ResponseEntity<TestDetailDto.Response> detailBoard(@PathVariable Long boardId){
        return ResponseEntity.status(HttpStatus.OK).body(boardService.getDetail(boardId));
    }

    @DeleteMapping("{boardId}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long boardId){
        boardService.deleteBoard(boardId);
        return ResponseEntity.status(HttpStatus.OK).build();

    }
}

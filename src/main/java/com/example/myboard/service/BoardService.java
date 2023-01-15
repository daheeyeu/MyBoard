package com.example.myboard.service;

import com.example.myboard.dto.CreateBoardDto;
import com.example.myboard.dto.GetBoardDto;
import com.example.myboard.dto.TestDetailDto;
import com.example.myboard.entity.Board;
import com.example.myboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class BoardService {

    private final BoardRepository boardRepository; //bean 등록

    public void createBoard(CreateBoardDto.Request request){

        // TODO:: Board Entity 생성 -> Builder 패턴 사용
        Board board = Board.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();

        // TODO:: 생성한 객체를 repository에 저장 즉, DB에 저장
        boardRepository.save(board);
    }
    
    public GetBoardDto.Response getBoardList(){

        List<GetBoardDto.Board> list = new ArrayList<>();
        // TODO:: DB에서 데이터를 가지고 온다.
        for (Board board : boardRepository.findAll()) {

            GetBoardDto.Board newBoard = GetBoardDto.Board.builder()
                    .id(board.getId())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .build();

            list.add(newBoard);
        }
        
        
        //TODO:: 가지고 온 데이터를 dto에 매핑
        return GetBoardDto.Response.builder()
                .boardList(list)
                .build();
    }

    public TestDetailDto.Response getDetail(Long boardId){
        //TODO::파라미터로 전달 받은 boardId를 이용해서 특정 데이터를 가져온다.
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("존재하는 데이터가 없습니다"));


        //TODO::받은 데이터를 Dto에 매핑시켜 리턴한다.
            return TestDetailDto.Response.builder()
                    .id(board.getId())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .build();



    }
}

package com.example.geungeunhanjan.mapper;

import com.example.geungeunhanjan.domain.vo.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    //게시글 등록하기
    int insertBoard(BoardVO boardVO);

    //특정 회원의 게시글 보기(마이페이지)
    List<BoardVO> selectBoard(Long userId);

}

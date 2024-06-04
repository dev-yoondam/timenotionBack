package com.example.geungeunhanjan.service.lifes;


import com.example.geungeunhanjan.domain.dto.FollowPage.FollowCriteria;
import com.example.geungeunhanjan.domain.dto.file.FollowDTO;
import com.example.geungeunhanjan.domain.vo.lifes.FollowVO;
import com.example.geungeunhanjan.domain.vo.user.UniVO;
import com.example.geungeunhanjan.mapper.lifes.FollowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowServiceImpe implements FollowService {

    //의존성 주입
    private final FollowMapper followMapper;

    public FollowServiceImpe(FollowMapper followMapper) {
        this.followMapper = followMapper;
    }
    //팔로우의 다음 시퀀스
    @Override
    public Long getFollowSeqNext() {
        return followMapper.getFollowSeqNext();
    }

    //팔로워 리스트 조회하기
    @Override
    public List<FollowDTO> selectFollower(Long userId) {
        return followMapper.selectFollower(userId);
    }

    @Override
    public FollowDTO selectFollowDetail(Long userId) {
        return followMapper.selectFollowDetail(userId);
    }

    @Override
    public UniVO selectFollowAbout(Long userId) {
        return followMapper.selectFollowAbout(userId);
    }
    //팔로잉 리스트 조회하기
//    @Override
//    public List<FollowDTO> selectFollowing() {
//        return followMapper.selectFollowing();
//    }


    @Override
    public List<FollowDTO> selectBoardCount(Long userId) {
        return followMapper.selectBoardCount(userId);
    }

    //팔로우 리스트 유저 클릭시 ; 팔로우 추가하기
    @Override
    public void insertFollow(FollowVO followVO) {
        followMapper.insertFollow(followVO);
    }
    //팔로우 리스트 유저 클릭시 ; 언팔로우 하기
    @Override
    public void deleteFollow(Long userId) {
        followMapper.deleteFollow(userId);
    }
    //페이징 처리
    @Override
    public List<FollowDTO> selectAllPageFollow(FollowCriteria followCriteria) {
        return followMapper.selectAllPageFollow(followCriteria);
    }

    @Override
    public int selectTotalFollow() {
        return followMapper.selectTotalFollow();
    }
}

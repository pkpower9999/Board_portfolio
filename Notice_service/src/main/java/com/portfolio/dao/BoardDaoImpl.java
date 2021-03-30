package com.portfolio.dao;

import java.util.List;

import com.portfolio.mapper.BoardMapper;
import com.portfolio.vo.CommentReqVO;
import com.portfolio.vo.CommentVO;
import com.portfolio.vo.GoodBadVO;
import com.portfolio.vo.PostRegistVO;
import com.portfolio.vo.PostVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class BoardDaoImpl implements BoardDao {

    @Autowired
    BoardMapper mapper;

    @Override
    public void insertPost(PostRegistVO vo) {
        mapper.insertPost(vo);
    }
    @Override
    public List<PostVO> getPostList(Integer offset, Integer board) {
        return mapper.getPostList(offset, board);
    }
    @Override
    public PostVO getPostBySeq(Integer no) {
        return mapper.getPostBySeq(no);
    }
    @Override
    public Integer getBoardPostCount(Integer board_seq) {
        return mapper.getBoardPostCount(board_seq);
    }
    @Override
    public void updatePost(PostVO vo) {
        mapper.updatePost(vo);
    }
    @Override
    public void deletePost(Integer seq) {
        mapper.deletePost(seq);
    }
    @Override
    public void updatePostCount(Integer seq) {
        mapper.updatePostCount(seq);        
    }

    @Override
    public void insertComment(CommentVO vo) {
        mapper.insertComment(vo);        
    }
    @Override
    public List<CommentVO> selectComment(CommentReqVO vo) {
        return mapper.selectComment(vo);
    }
    @Override
    public Integer selectCommentCount(CommentReqVO vo) {
        return mapper.selectCommentCount(vo);
    }

    @Override
    public void insertCommentGoodBad(GoodBadVO vo) {
        mapper.insertCommentGoodBad(vo);
    }
    @Override
    public GoodBadVO selectCommentGoodBad(GoodBadVO vo) {
        return mapper.selectCommentGoodBad(vo);
    }
    @Override
    public void updateCommentGoodbad(GoodBadVO vo) {
        mapper.updateCommentGoodbad(vo);
    }
    @Override
    public List<Integer> selectCommentLikesCount(Integer seq) {
        return mapper.selectCommentLikesCount(seq);
    }
    @Override
    public void deleteComment(Integer seq) {
        mapper.deleteComment(seq);        
    }

    @Override
    public void insertPostGoodBad(GoodBadVO vo) {
        mapper.insertPostGoodBad(vo);
    }
    @Override
    public GoodBadVO selectPostGoodBad(GoodBadVO vo) {
        return mapper.selectPostGoodBad(vo);
    }
    @Override
    public void updatePostGoodbad(GoodBadVO vo) {
        mapper.updatePostGoodbad(vo);        
    }
    @Override
    public List<Integer> selectPostLikesCount(Integer seq) {
        return mapper.selectPostLikesCount(seq);
    }
}

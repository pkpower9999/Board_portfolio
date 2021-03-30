package com.portfolio.service;

import java.util.List;

import com.portfolio.dao.BoardDao;
import com.portfolio.vo.CategoryVO;
import com.portfolio.vo.CommentReqVO;
import com.portfolio.vo.CommentVO;
import com.portfolio.vo.GoodBadVO;
import com.portfolio.vo.PostRegistVO;
import com.portfolio.vo.PostVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service
@Configurable
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardDao dao;

    @Override
    public void insertPost(PostRegistVO vo) {
        dao.insertPost(vo);
    }
    @Override
    public List<PostVO> getPostList(Integer offset, Integer board) {
        List<PostVO> postList = dao.getPostList(offset, board);
        return postList;
    }
    @Override
    public PostVO getPostBySeq(Integer no) {
        return dao.getPostBySeq(no);
    }
    @Override
    public Integer getBoardPostCount(Integer board_seq) {
        return dao.getBoardPostCount(board_seq);
    }
    @Override
    public void updatePost(PostVO vo) {
        dao.updatePost(vo);
    }
    @Override
    public void deletePost(Integer seq) {
        dao.deletePost(seq);
    }
    @Override
    public void updatePostCount(Integer seq) {
        dao.updatePostCount(seq);        
    }

    @Override
    public void insertComment(CommentVO vo) {
        dao.insertComment(vo);
    }
    @Override
    public List<CommentVO> selectComment(CommentReqVO vo) {
        return dao.selectComment(vo);
    }
    @Override
    public Integer selectCommentCount(CommentReqVO vo) {
        return dao.selectCommentCount(vo);
    }
    @Override
    public void insertCommentGoodBad(GoodBadVO vo) {
        dao.insertCommentGoodBad(vo);
    }
    @Override
    public GoodBadVO selectCommentGoodBad(GoodBadVO vo) {
        return dao.selectCommentGoodBad(vo);
    }
    @Override
    public void updateCommentGoodbad(GoodBadVO vo) {
        dao.updateCommentGoodbad(vo);
    }
    @Override
    public List<Integer> selectCommentLikesCount(Integer seq) {
        return dao.selectCommentLikesCount(seq);
    }
    @Override
    public void deleteComment(Integer seq) {
        dao.deleteComment(seq);        
    }

    @Override
    public void insertPostGoodBad(GoodBadVO vo) {
        dao.insertPostGoodBad(vo);        
    }
    @Override
    public GoodBadVO selectPostGoodBad(GoodBadVO vo) {
        return dao.selectPostGoodBad(vo);
    }
    @Override
    public void updatePostGoodbad(GoodBadVO vo) {
        dao.updatePostGoodbad(vo);        
    }
    @Override
    public List<Integer> selectPostLikesCount(Integer seq) {
        return dao.selectPostLikesCount(seq);
    }
}

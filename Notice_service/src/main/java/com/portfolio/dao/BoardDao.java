package com.portfolio.dao;

import java.util.List;

import com.portfolio.vo.CommentReqVO;
import com.portfolio.vo.CommentVO;
import com.portfolio.vo.GoodBadVO;
import com.portfolio.vo.PostRegistVO;
import com.portfolio.vo.PostVO;

import org.springframework.stereotype.Repository;

@Repository
public interface BoardDao {
    public void insertPost(PostRegistVO vo);
    public List<PostVO> getPostList(Integer offset, Integer board);
    public PostVO getPostBySeq(Integer no);
    public Integer getBoardPostCount(Integer board_seq);
    public void updatePost(PostVO vo);
    public void deletePost(Integer seq);
    public void updatePostCount(Integer seq);

    public void insertComment(CommentVO vo);
    public List<CommentVO> selectComment(CommentReqVO vo);
    public Integer selectCommentCount(CommentReqVO vo);
    public void insertCommentGoodBad(GoodBadVO vo);
    public GoodBadVO selectCommentGoodBad(GoodBadVO vo);
    public void updateCommentGoodbad(GoodBadVO vo);
    public List<Integer> selectCommentLikesCount(Integer seq);
    public void deleteComment(Integer seq);

    public GoodBadVO selectPostGoodBad(GoodBadVO vo);
    public void insertPostGoodBad(GoodBadVO vo);
    public void updatePostGoodbad(GoodBadVO vo);
    public List<Integer> selectPostLikesCount(Integer seq);

}

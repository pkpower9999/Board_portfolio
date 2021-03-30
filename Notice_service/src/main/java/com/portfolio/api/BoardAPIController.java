package com.portfolio.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.portfolio.service.BoardService;
import com.portfolio.vo.CommentReqVO;
import com.portfolio.vo.CommentVO;
import com.portfolio.vo.GoodBadVO;
import com.portfolio.vo.PostRegistVO;
import com.portfolio.vo.PostVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardAPIController {
    
    @Autowired
    BoardService service;

    @PostMapping("/api/write")
    public Map<String, String> postWrite(@RequestBody PostRegistVO vo){
        Map<String, String> map = new LinkedHashMap<>();
        service.insertPost(vo);
        map.put("result", "success");
        return map;

    }

    @GetMapping("/api/postCount")
    public Map<String, Integer> getPostCount(@RequestParam Integer board_seq){
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        Integer count = service.getBoardPostCount(board_seq);
        map.put("count", count);
        return map;
    }

    @PostMapping("/api/updatePost")
    public Map<String, String> updatePost(@RequestBody PostVO vo){
        Map<String, String> map = new LinkedHashMap<String, String>();

        service.updatePost(vo);
        map.put("result", "success");

        return map;
    }

    
    @DeleteMapping("/api/deletePost")
    public Map<String, String> deletePost(@RequestParam Integer seq){
        Map<String, String> map = new LinkedHashMap<String, String>();
        service.deletePost(seq);
        map.put("result", "success");

        return map;

    }

    @PatchMapping("/api/patchPostCnt")
    public Map<String, String> patchPostCnt(@RequestParam Integer post_seq){
        Map<String, String> map = new LinkedHashMap<String, String>();

        service.updatePostCount(post_seq);
        map.put("result", "success");
        return map;
    }

    @PostMapping("/api/insert_comment")
    public Map<String, String> postInsertComment(@RequestBody CommentVO vo) {
        Map<String, String> map = new LinkedHashMap<String, String>();
        service.insertComment(vo);
        return map;
    }

    @PostMapping("/api/comments")
    public Map<String, Object> postComments(@RequestBody CommentReqVO vo){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("count", service.selectCommentCount(vo));


        List<CommentVO> commentList = service.selectComment(vo);
        commentList.forEach(comment ->{
            Integer seq= comment.getCi_seq();
            List<Integer> likes = service.selectCommentLikesCount(seq);
            comment.setCi_like(likes.get(1));
            comment.setCi_dislike(likes.get(0));

        });


        map.put("data", commentList);
        return map;

    }

    @PostMapping("/api/comment_likes")
    public Map<String, Object> commentLikes(@RequestBody GoodBadVO vo){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        if(vo.getUser_seq() == null){
            map.put("message", "로그인 후 사용하실수 있습니다.");
            return map;
        }
       
        GoodBadVO resultVO = service.selectCommentGoodBad(vo);
        if(resultVO == null){
            service.insertCommentGoodBad(vo);
            if(vo.getGood_bad() ==0)
                map.put("message", "비추천 되었습니다");
            else
                map.put("message", "추천되었습니다.");

        }
        else {
            if(resultVO.getGood_bad() == vo.getGood_bad()){
                if(vo.getGood_bad() ==0)
                map.put("message", "이미 비추천 되었습니다");
                else
                map.put("message", "이미 추천하였습니다.");
            }
            else {
                //상태업데이트
                service.updateCommentGoodbad(vo);
                if(vo.getGood_bad() == 0){
                    map.put("message", "비추천 하였습니다.");
                }
                else {
                    map.put("message", "추천 하였습니다.");
                }
            }
        }
        return map;
    }

    @DeleteMapping("/api/delete_comment")
    public Map<String, String> deleteComment(@RequestParam Integer seq){
        Map<String, String> map = new LinkedHashMap<String, String>();
        service.deleteComment(seq);
        map.put("message", "삭제되었습니다");
        return map;
    }

    @PostMapping("/api/likes")
    public Map<String, Object> postLikes(@RequestBody GoodBadVO vo){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        if(vo.getUser_seq() == null){
            map.put("message", "로그인 후 사용하실수 있습니다.");
            return map;
        }
       
        GoodBadVO resultVO = service.selectPostGoodBad(vo);
        if(resultVO == null){
            service.insertPostGoodBad(vo);
            if(vo.getGood_bad() ==0)
                map.put("message", "비추천 되었습니다");
            else
                map.put("message", "추천되었습니다.");

        }
        else {
            if(resultVO.getGood_bad() == vo.getGood_bad()){
                if(vo.getGood_bad() ==0)
                map.put("message", "이미 비추천 되었습니다");
                else
                map.put("message", "이미 추천하였습니다.");
            }
            else {
                //상태업데이트
                service.updatePostGoodbad(vo);
                if(vo.getGood_bad() == 0){
                    map.put("message", "비추천 하였습니다.");
                }
                else {
                    map.put("message", "추천 하였습니다.");
                }
            }
        }
        return map;
    }


    @PostMapping("/api/freeWrite")
    public Map<String, String> freePostWrite(@RequestBody PostRegistVO vo){
        Map<String, String> map = new LinkedHashMap<>();
        service.insertPost(vo);
        map.put("result", "success");
        return map;

    }

    
    @GetMapping("/api/freePostCount")
    public Map<String, Integer> getFreePostCount(@RequestParam Integer board_seq){
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        Integer count = service.getBoardPostCount(board_seq);
        map.put("count", count);
        return map;
    }

    
    @DeleteMapping("/api/deleteFreePost")
    public Map<String, String> deleteFreePost(@RequestParam Integer seq){
        Map<String, String> map = new LinkedHashMap<String, String>();
        service.deletePost(seq);
        map.put("result", "success");

        return map;

    }

    @PostMapping("/api/freeBoardLikes")
    public Map<String, Object> freePostLikes(@RequestBody GoodBadVO vo){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        if(vo.getUser_seq() == null){
            map.put("message", "로그인 후 사용하실수 있습니다.");
            return map;
        }
       
        GoodBadVO resultVO = service.selectPostGoodBad(vo);
        if(resultVO == null){
            service.insertPostGoodBad(vo);
            if(vo.getGood_bad() ==0)
                map.put("message", "비추천 되었습니다");
            else
                map.put("message", "추천되었습니다.");

        }
        else {
            if(resultVO.getGood_bad() == vo.getGood_bad()){
                if(vo.getGood_bad() ==0)
                map.put("message", "이미 비추천 되었습니다");
                else
                map.put("message", "이미 추천하였습니다.");
            }
            else {
                //상태업데이트
                service.updatePostGoodbad(vo);
                if(vo.getGood_bad() == 0){
                    map.put("message", "비추천 하였습니다.");
                }
                else {
                    map.put("message", "추천 하였습니다.");
                }
            }
        }
        return map;
    }

    
    @PostMapping("/api/insert_freeBoard_comment")
    public Map<String, String> freePostInsertComment(@RequestBody CommentVO vo) {
        Map<String, String> map = new LinkedHashMap<String, String>();
        service.insertComment(vo);
        return map;
    }

    @PostMapping("/api/freeBoardcomments")
    public Map<String, Object> freePostComments(@RequestBody CommentReqVO vo){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("count", service.selectCommentCount(vo));


        List<CommentVO> commentList = service.selectComment(vo);
        commentList.forEach(comment ->{
            Integer seq= comment.getCi_seq();
            List<Integer> likes = service.selectCommentLikesCount(seq);
            comment.setCi_like(likes.get(1));
            comment.setCi_dislike(likes.get(0));

        });


        map.put("data", commentList);
        return map;

    }

    @PostMapping("/api/comment_freeBoard_likes")
    public Map<String, Object> freePostcommentLikes(@RequestBody GoodBadVO vo){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        if(vo.getUser_seq() == null){
            map.put("message", "로그인 후 사용하실수 있습니다.");
            return map;
        }
       
        GoodBadVO resultVO = service.selectCommentGoodBad(vo);
        if(resultVO == null){
            service.insertCommentGoodBad(vo);
            if(vo.getGood_bad() ==0)
                map.put("message", "비추천 되었습니다");
            else
                map.put("message", "추천되었습니다.");

        }
        else {
            if(resultVO.getGood_bad() == vo.getGood_bad()){
                if(vo.getGood_bad() ==0)
                map.put("message", "이미 비추천 되었습니다");
                else
                map.put("message", "이미 추천하였습니다.");
            }
            else {
                //상태업데이트
                service.updateCommentGoodbad(vo);
                if(vo.getGood_bad() == 0){
                    map.put("message", "비추천 하였습니다.");
                }
                else {
                    map.put("message", "추천 하였습니다.");
                }
            }
        }
        return map;
    }

    @DeleteMapping("/api/delete_freeBoard_comment")
    public Map<String, String> deleteFreePostComment(@RequestParam Integer seq){
        Map<String, String> map = new LinkedHashMap<String, String>();
        service.deleteComment(seq);
        map.put("message", "삭제되었습니다");
        return map;
    }

}

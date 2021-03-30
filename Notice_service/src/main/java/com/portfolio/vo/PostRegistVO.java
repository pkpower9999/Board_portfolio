package com.portfolio.vo;

public class PostRegistVO {
    private Integer board_seq;
    private Integer user_seq;
    private String post_title;
    private String post_content;

    public Integer getBoard_seq() {
        return this.board_seq;
    }

    public void setBoard_seq(Integer board_seq) {
        this.board_seq = board_seq;
    }

    public Integer getUser_seq() {
        return this.user_seq;
    }

    public void setUser_seq(Integer user_seq) {
        this.user_seq = user_seq;
    }

    public String getPost_title() {
        return this.post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getPost_content() {
        return this.post_content;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }

}

package com.portfolio.mapper;

import com.portfolio.vo.LoginVO;
import com.portfolio.vo.UserVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
	public Integer selectUserCntById(String userid);
	public void insertUser(UserVO vo);
    public Integer loginUser(LoginVO vo);
	public UserVO selectUserById(LoginVO vo);
}

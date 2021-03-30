package com.portfolio.dao;

import com.portfolio.vo.LoginVO;
import com.portfolio.vo.UserVO;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
	public Integer selectUserCntById(String userid);
	public void insertUser(UserVO vo);
    public Integer loginUser(LoginVO vo);
	public UserVO selectUserById(LoginVO vo);

}

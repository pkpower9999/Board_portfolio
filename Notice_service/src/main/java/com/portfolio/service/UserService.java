package com.portfolio.service;

import com.portfolio.vo.LoginVO;
import com.portfolio.vo.UserVO;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

@Service
@Configurable
public interface UserService {
    
	
	public boolean isDuplicatedUser(String userid);
	public Integer insertUser(UserVO vo);
    public boolean loginUser(LoginVO vo);
	public UserVO selectUserById(LoginVO vo);

		
	
}

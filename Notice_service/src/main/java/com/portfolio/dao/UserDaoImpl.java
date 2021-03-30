package com.portfolio.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.portfolio.mapper.UserMapper;
import com.portfolio.vo.LoginVO;
import com.portfolio.vo.UserVO;

@Repository
@Primary
public class UserDaoImpl implements UserDao {

	@Autowired
	UserMapper mapper;
	
	@Override
	public Integer selectUserCntById(String userid) {
		// TODO Auto-generated method stub
		return mapper.selectUserCntById(userid);
	}
	@Override
	public void insertUser(UserVO vo) {
		// TODO Auto-generated method stub
		mapper.insertUser(vo);
	}
	@Override
	public Integer loginUser(LoginVO vo) {
		// TODO Auto-generated method stub
		return mapper.loginUser(vo);
	}
	@Override
	public UserVO selectUserById(LoginVO vo) {
		// TODO Auto-generated method stub
		return mapper.selectUserById(vo);
	}
}

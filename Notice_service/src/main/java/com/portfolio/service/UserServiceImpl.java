package com.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import com.portfolio.dao.UserDao;
import com.portfolio.utils.AESAlgorithm;
import com.portfolio.vo.LoginVO;
import com.portfolio.vo.UserVO;

@Service
@Configurable
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao dao;
	
	@Override
	public boolean isDuplicatedUser(String userid) {
		return dao.selectUserCntById(userid) == 1;
	}
	@Override
	public Integer insertUser(UserVO vo) {
		if (vo.getUi_id().equals("") || vo.getUi_id() == null) {
            System.out.println("아이디 누락");
            return 400;
        }
        if (vo.getUi_pwd().equals("") || vo.getUi_pwd() == null) {
            System.out.println("비밀번호 누락");
            return 400;
        }
        if (vo.getUi_name().equals("") || vo.getUi_name() == null) {
            System.out.println("이름 누락");
            return 400;
        }
        if (vo.getUi_email().equals("") || vo.getUi_email() == null) {
            System.out.println("이메일 누락");
            return 400;
        }

		String pwd = vo.getUi_pwd();
		try{
			pwd = AESAlgorithm.Encrypt(pwd);
			vo.setUi_pwd(pwd);
		}
		catch(Exception e){
			System.out.println("암호화 실패 "+e.getMessage());
			return 500;
		}

		dao.insertUser(vo);
		return 200;
	}

	@Override
	public boolean loginUser(LoginVO vo) {
		// TODO Auto-generated method stub
		Integer result = dao.loginUser(vo);
		if (result == 1){
			return true;
		}
		return false;
	}

	@Override
	public UserVO selectUserById(LoginVO vo) {
		// TODO Auto-generated method stub
		return dao.selectUserById(vo);
	}
}

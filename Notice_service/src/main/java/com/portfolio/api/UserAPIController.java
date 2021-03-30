package com.portfolio.api;


import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.portfolio.service.UserService;
import com.portfolio.utils.AESAlgorithm;
import com.portfolio.vo.LoginVO;
import com.portfolio.vo.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAPIController {

	@Autowired
	UserService service;

	@PostMapping("/api/userAdd")
	public Map<String, String> userAdd(@RequestBody UserVO vo){
		Map<String, String> resultMap = new LinkedHashMap<String, String>();
		

		Integer result = service.insertUser(vo);
		if(result == 500 || result == 400){
			resultMap.put("result", "failed");
		} else {
			resultMap.put("result", "success");
		}

		return resultMap;

	}

	@PostMapping("/api/userchk")
	public Map<String, Boolean> userChk(@RequestBody UserVO user){

		Map<String, Boolean> map = new LinkedHashMap<String, Boolean>();
		boolean isDuplicated = service.isDuplicatedUser(user.getUi_id());
		map.put("result", isDuplicated);
		return map;

	}

	@PostMapping("/api/login")
    public Map<String, Boolean> postUserLogin(@RequestBody LoginVO vo, HttpSession session) {
        Map<String, Boolean> map = new LinkedHashMap<String, Boolean>();

        try {
            vo.setPwd(AESAlgorithm.Encrypt(vo.getPwd()));
        } catch (Exception e) {

        }
        boolean result = service.loginUser(vo);
        if (result == true) {
            UserVO userInfo = service.selectUserById(vo);
            session.setAttribute("userInfo", userInfo);
        } else {
            session.setAttribute("userInfo", null);

        }

        map.put("result", result);
        return map;
    }




	



	

	
}

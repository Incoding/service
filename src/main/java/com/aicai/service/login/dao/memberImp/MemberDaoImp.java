package com.aicai.service.login.dao.memberImp;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aicai.service.login.dao.MemberDao;
import com.aicai.service.login.domain.Member;

@Repository
public class MemberDaoImp implements MemberDao {
	@Autowired
	private SqlSessionTemplate	sqlSessionTemplate;
	@Override
	public Member login(String username, String md5pass) {
		System.out.println("logindao");
		String selectOne = "service.member.memberlogin";
		Map<String, String> paraMap = new HashMap<>();
		paraMap.put("username", username);
		paraMap.put("password", md5pass);
		Member a = sqlSessionTemplate.selectOne(selectOne, paraMap);
		if (a == null) {
			return new Member();
		}
		return a;
	}

}

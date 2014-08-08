package com.aicai.service.login.dao.memberImp;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aicai.service.login.dao.MemberDao;
import com.aicai.service.login.domain.Member;
import com.aicai.service.login.domain.Social;

@Repository
public class MemberDaoImp implements MemberDao {
	@Autowired
	private SqlSessionTemplate	sqlSessionTemplate;
	@Override
	public Member login(String username, String md5pass) {
		System.out.println("logindao");
		String selectOne = "testNamespace.getTop1UserResultMap";
		Social a = sqlSessionTemplate.selectOne(selectOne);
		System.out.println(a);
		return null;
	}

}

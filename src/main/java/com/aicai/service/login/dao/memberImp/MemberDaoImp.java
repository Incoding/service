package com.aicai.service.login.dao.memberImp;

import org.springframework.stereotype.Repository;

import com.aicai.service.login.dao.MemberDao;
import com.aicai.service.login.domain.Member;

@Repository
public class MemberDaoImp implements MemberDao {
	@Override
	public Member login(String username, String md5pass) {
		System.out.println("logindao");
		return null;
	}

}

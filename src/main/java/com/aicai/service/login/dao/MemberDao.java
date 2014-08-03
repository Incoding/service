package com.aicai.service.login.dao;

import com.aicai.service.login.domain.Member;

public interface MemberDao {
	public abstract Member login(String username, String md5pass);
}

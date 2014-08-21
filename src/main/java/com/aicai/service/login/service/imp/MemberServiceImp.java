package com.aicai.service.login.service.imp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aicai.service.login.dao.MemberDao;
import com.aicai.service.login.domain.Member;
import com.aicai.service.login.exception.BaseException;
import com.aicai.service.login.service.MemberServiceI;

@Service
public class MemberServiceImp implements MemberServiceI {
	@Autowired
	private MemberDao	memberDao;

	/* (non-Javadoc)
	 * @see com.aicai.service.login.service.MemberI#login(java.lang.String, java.lang.String, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public Member login(String username, String password,
			HttpServletRequest req, HttpServletResponse resp) {
		Member member = null;
		// 获取cookie里的加密字段,
		// 利用加密字段 到memcache中查找
		// TODO md5加密密码
		String md5pwd = DigestUtils.md5Hex(password);
		// TODO dao 到数据库中查找用户名和密码 memberdao.findUser(username,pwd);
		try {
			member = memberDao.login(username, md5pwd);
		} catch (Exception e) {
            throw new BaseException(e.getMessage(), e);
		}
		if (member == null) {
			// 返货modelresult可以判断,是返回了异常,还是返回正确结果,还是返回null.
			// 结合后端人员一起处理返回值,isBackResp
			return new Member();
		}
			// 重新刷新cookie,防止登陆过期

		return member;
	}
}

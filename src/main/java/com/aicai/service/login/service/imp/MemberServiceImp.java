package com.aicai.service.login.service.imp;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aicai.service.login.dao.MemberDao;
import com.aicai.service.login.domain.Member;
import com.aicai.service.login.domain.modelresult.ModelResult;
import com.aicai.service.login.service.MemberServiceI;
import com.alibaba.fastjson.JSONObject;

@Service
public class MemberServiceImp implements MemberServiceI {
	private transient Logger	logger	= LoggerFactory
												.getLogger(MemberServiceImp.class);
	@Autowired
	private MemberDao	memberDao;

	/* (non-Javadoc)
	 * @see com.aicai.service.login.service.MemberI#login(java.lang.String, java.lang.String, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ModelResult<Member> login(String username, String password,
			HttpServletRequest req, HttpServletResponse resp) {
		Member member = null;
		ModelResult<Member> modelResult = new ModelResult<Member>();
		// 获取cookie里的加密字段,
		// 利用加密字段 到memcache中查找
		// TODO md5加密密码
		String md5pwd = DigestUtils.md5Hex(password);
		// TODO dao 到数据库中查找用户名和密码 memberdao.findUser(username,pwd);
		try {
			member = memberDao.login(username, md5pwd);
		} catch (Exception e) {
			HashMap<String,String > map = new HashMap<>();
			map.put("username", username);
			logger.info("查询发生异常,inputParam{},异常堆栈:{}",
					JSONObject.toJSONString(map), e);
			return modelResult.withError("数据库查询异常", e);
		}
		if (member == null) {
			// 返货modelresult可以判断,是返回了异常,还是返回正确结果,还是返回null.
			// 结合后端人员一起处理返回值,isBackResp
			return modelResult.withModel(member);
		}
			// 重新刷新cookie,防止登陆过期

		return modelResult.withModel(member);
	}
}

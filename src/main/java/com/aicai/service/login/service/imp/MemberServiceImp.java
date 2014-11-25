package com.aicai.service.login.service.imp;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aicai.service.login.constants.LoginConstant;
import com.aicai.service.login.dao.MemberDao;
import com.aicai.service.login.domain.Member;
import com.aicai.service.login.domain.modelresult.ModelResult;
import com.aicai.service.login.service.MemberServiceI;
import com.aicai.service.util.LoginUtils;
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
		if(checkVcid(req) == null){
			return modelResult.withModel(new Member());
		}
		// 看是否有sso登陆过得cookie
		Member cookieMember = checkCookieInfo(req);
		if(cookieMember != null){
			return modelResult.withModel(cookieMember);
		}
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
			return modelResult.withModel(new Member());
		}
//		刷新membercache,中member信息
//		memClient.set(memKey,LoginConstant.getSSO_LOGIN_TIME_OUT(), member);//验证通过，返回member对象之前，刷新下缓存，以免超时
//		刷新cookie信息;

		return modelResult.withModel(member);
	}

	private Member checkCookieInfo(HttpServletRequest req) {
		String cookieVal = LoginUtils.getCookieVal(req, LoginConstant.getSSO_COOKIE_KEY());		
		if(cookieVal == null){
			return null;
		}
		//TODO 获取key
		String memberId = cookieVal.substring(0, 3);
		String memKey = memberId + LoginConstant.getSSO_LOGIN_KEY();
		// 到memchache中取这个memKey值 如果有值,则返回memcache中的member对象,这样就可以进行sso登陆
		Member member = null;
//		member = (Member)memClient.get(memKey);
		if(member == null){
			return null;
		}
//		刷新membercache,中member信息
//		memClient.set(memKey,LoginConstant.getSSO_LOGIN_TIME_OUT(), member);//验证通过，返回member对象之前，刷新下缓存，以免超时
//		刷新cookie信息;
		return member;
	}

	private String checkVcid(HttpServletRequest request) {
		String userCookieSign = LoginUtils.getCookieVal(request, "vcid");
    	if(userCookieSign == null) {
    		logger.info("缺少vcid,Referer[{}]",new Object[]{request.getHeader("Referer")});
    		return "";
    	}
    	return userCookieSign;
	}
}

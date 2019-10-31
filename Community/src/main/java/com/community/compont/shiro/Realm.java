package com.community.compont.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.community.mapper.Readermapper;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月10日下午2:17:17
 * 
 * @Todo: TODO
 */
public class Realm extends AuthorizingRealm {

	@Autowired
	Readermapper readermapper;
	// TODO:登录认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken info = (UsernamePasswordToken)token;
		String psd = readermapper.selectreader(info.getUsername());
		if (psd == null) {
			return null;
		}
		return new SimpleAuthenticationInfo("", psd, "");
	}

	// TODO:权限检查
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}


}

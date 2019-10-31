package com.community.compont.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Shiro配置类
 * 
 */
@Configuration
public class Shiroconfig {

	// 创建ShirofilterFactorybBean
	@Bean(name = "factoryBean")
	public ShiroFilterFactoryBean getShiroFilterFactorybBean(
			@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
		// 设置安全管理器
		factoryBean.setSecurityManager(securityManager);
		/**
		 * Shiro内置过滤器，可以实现权限相关的拦截器 常用的过滤器: anon: 无需认证（登录）可以访问 authc: 必须认证才可以访问
		 * user: 如果使用rememberMe的功能可以直接访问 perms： 该资源必须得到资源权限才可以访问
		 * role:该资源必须得到角色权限才可以访问
		 */
		// 添加Shiro内置过滤器
		Map<String, String> filterMap = new LinkedHashMap<String, String>();


		filterMap.put("/", "anon");
		filterMap.put("/loginpage", "anon");
		filterMap.put("/registerpage", "anon");
		filterMap.put("/login", "anon");
		filterMap.put("/register", "anon");
		filterMap.put("/detail", "anon");
		filterMap.put("/secondary_comment", "anon");
		filterMap.put("/*", "authc");

		// 授权过滤器
		// 注意：当前授权拦截后，shiro会自动跳转到未授权页面
		// filterMap.put("/addpage", "perms[user:addpage]");
		// filterMap.put("/updatepage", "perms[user:updatepage]");
		// 未登录是跳转登录页面
		factoryBean.setLoginUrl("/loginpage");

		// 设置未授权提示页面
		factoryBean.setUnauthorizedUrl("/loginpage");

		factoryBean.setFilterChainDefinitionMap(filterMap);

		return factoryBean;
	}

	@Bean(name = "securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("realm") Realm realm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

		// 关联realm
		securityManager.setRealm(realm);
		return securityManager;
	}

	@Bean("realm")
	public Realm realm() {
		return new Realm();
	}


}

package com.game;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月7日下午2:20:42
 * 
 * @Todo: TODO
 */
public class ProxyDemo {

	public static void main(String[] args) {
		Proxyinterface target = new Proxytarget();
		Proxyinterface proxy = (Proxyinterface) new Proxybilder(target).getproxy();
		proxy.proxy1();
	}


}

class Proxybilder {
	private Object proxy1;

	public Proxybilder(Object proxy) {
		this.proxy1 = proxy;
	}

	public Object getproxy() {
		return Proxy.newProxyInstance(proxy1.getClass().getClassLoader(), proxy1.getClass().getInterfaces(),
				new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("========================");
						Object invoke = method.invoke(proxy1, args);
				System.out.println("========================");
						return invoke;
			}
				});
		
	}
}

class Proxytarget implements Proxyinterface {

	//TODO:TODO
	@Override
	public void proxy1() {
		System.out.println("proxy1");

	}

	//TODO:TODO
	@Override
	public void proxy2() {
		// TODO Auto-generated method stub
		System.out.println("proxy2");

	}

}

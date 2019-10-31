package com.singleton;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年9月10日上午11:06:54
 * 
 * @Todo: 单例模式:懒汉式
 */
public class Singleton2 {

	private static Singleton2 singleton2 = null;

	private Singleton2() {
	}

	// 方法一
	public static Singleton2 getinstance() {
		if (singleton2 == null) {
			synchronized (Singleton2.class) {
				if (singleton2 == null) {
					try {
						singleton2 = new Singleton2();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return singleton2;
	}

	// 方法二
	private static class Singleton2_1 {
		private static Singleton2 singleton2_1 = new Singleton2();
	}

	public static Singleton2 getinstance2_1() {
		return Singleton2_1.singleton2_1;

	}
}

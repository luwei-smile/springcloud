package com.singleton;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年9月10日上午11:06:54
 * 
 * @Todo: 单例模式:饿汉式
 */
public class Singleton1 {

	private static final Singleton1 singleton1 = new Singleton1();

	private Singleton1() {

	}

	public static Singleton1 getinstance() {
		return singleton1;
	}
}

package com.singleton;

import com.algorithm.Socket01;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年9月10日上午11:11:05
 * 
 * @Todo: 单例模式测试
 */
public class Singleton_test {

	public static void main(String[] args) {
		/*
		 * Singleton1 getinstance1 = Singleton1.getinstance(); Singleton1
		 * getinstance2 = Singleton1.getinstance();
		 * 
		 * System.out.println(getinstance1 == getinstance2);
		 * 
		 * Singleton2 getinstance3 = Singleton2.getinstance(); Singleton2
		 * getinstance4 = Singleton2.getinstance();
		 * 
		 * System.out.println(getinstance3 == getinstance4);
		 * 
		 * Singleton2 getinstance5 = Singleton2.getinstance2_1(); Singleton2
		 * getinstance6 = Singleton2.getinstance2_1();
		 * 
		 * System.out.println(getinstance5 == getinstance6);
		 * 
		 * 
		 * Interface a = new Imp1(); a.add(); System.out.println(Interface.age);
		 * 
		 * System.out.println(args); for (String string : args) {
		 * System.out.println(string); } Solution solution = new Solution();
		 * solution.Find(); solution.ReplaceSpace();
		 * 
		 * 
		 * new Game_24().Get_answer();
		 */
		new Socket01().gethostInfo();
	}

}

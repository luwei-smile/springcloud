package com.algorithm;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月16日上午10:57:02
 * 
 * @Todo: TODO
 */
public class AAA {

	public static void main(String[] args) {
		String i1 = "aaa";
		String i2 = "aaa";
		String i3 = new String("aaa");
		String i4 = new String("aa" + "a");
		System.out.println(i1 == i2);
		System.out.println(i1.equals(i2));
		System.out.println(i3 == i4);
		System.out.println(i4.equals(i2));

		persion persion1 = new persion(i1);
		persion persion2 = new persion(i1);
		System.out.println(persion1 == persion2);
		System.out.println(persion1.equals(persion2));
	}
}

class persion {
	private String i;

	public persion(String i) {
		this.i = i;
	}
}

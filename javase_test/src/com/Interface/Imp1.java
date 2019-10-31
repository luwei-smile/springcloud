package com.Interface;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年9月18日下午3:25:00
 * 
 * @Todo: TODO
 */
public class Imp1 implements Interface {

	public static void main(String[] args) {
		Tread1 A = new Tread1(1);

		Thread a = new Thread(A);
		a.start();
		Thread b = new Thread(A);
		b.start();
		Thread c = new Thread(A);
		c.start();
		System.out.println(16 >> 2);

		ArrayList<String> list = new ArrayList<String>();
		list.add("4123");
		list.add("23");
		list.add("3");
		list.add("123");
		Collections.sort(list);
		System.out.println(list);

	}
	//TODO:TODO
	@Override
	public void add() {
		System.out.println("Imp1");
	}

	// @Todo:TODO
	public void delete() {
		System.out.println("delete");

	}
}

class Tread1 implements Runnable {

	private int i;

	public Tread1(int i) {
		this.i = i;
	}

	// TODO:TODO
	@Override
	public void run() {
		System.out.println(i + Thread.currentThread().getName());
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}


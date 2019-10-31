package com.game;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年9月20日下午12:06:09
 * 
 * @Todo: 24点答案
 */
public class Game_24 {
	private List<Integer> list = new ArrayList<Integer>();
	private Integer[] Add = { 0, 0, 0, 0, 0, 0 };
	private Integer[] Multiple = { 0, 0, 0, 0, 0, 0 };
	private Integer[] Reduce = { 0, 0, 0, 0, 0, 0 };
	private Integer[] Divide = { 0, 0, 0, 0, 0, 0 };

	// @Todo:两数相加
	private Integer add(Integer a, Integer b) {
		return b + a;

	}

	// @Todo:两数减 a-b
	private Integer reduce(Integer a, Integer b) {
		if (a < b) {
			System.out.println("a-b错误!!!");
			return -1;
		}
		return a - b;

	}

	// @Todo:两数相乘
	private Integer multiple(Integer a, Integer b) {
		return b * a;

	}

	// @Todo:两数相除
	private Integer divide(Integer a, Integer b) {
		if (a < b || a % b != 0) {
			System.out.println("a/b错误!!!");
			return -1;
		}

		return a / b;
		// TODO Auto-generated method stub

	}

	// @Todo:数字排序
	private void rank(Integer[] number) {
		int temp = 0;
		for (int i = 0; i < number.length; i++) {
			for (int j = i + 1; j < number.length; j++) {
				if (number[i] < number[j]) {
					temp = number[i];
					number[i] = number[j];
					number[j] = temp;
				}

			}
		}

	}
	
	// @Todo:方法一:两两组合-----不可取
	private void Answer_01(Integer[] number) {
		Integer temp = 0;

		// 列举出所有可能的加减乘除的结果
		for (int i = 0; i < number.length - 1; i++) {
			for (int j = i + 1; j < number.length; j++, temp++) {
				Add[temp] = add(number[i], number[j]);
				Multiple[temp] = multiple(number[i], number[j]);
				Divide[temp] = divide(number[i], number[j]);
				Reduce[temp] = reduce(number[i], number[j]);
			}
		}

		for (int i = 0; i < 3; i++) {
			list.add(add(Add[i], Multiple[5 - i]));
			list.add(multiple(Add[i], Multiple[5 - i]));
			list.add(divide(Add[i], Multiple[5 - i]));
			list.add(reduce(Add[i], Multiple[5 - i]));
		}

	}
	

	// @Todo:TODO
	public void Get_answer() {
		String subject = "2,1,8,9";// 35 14 7 10 5 2
		String[] split = subject.split(",");
		Integer[] number = { 0, 0, 0, 0 };
		for (int i = 0; i < split.length; i++) {
			number[i] = new Integer(split[i]);
		}
		try {
			rank(number);
			if (false)
			throw new Exception();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Answer_01(number);

		System.out.println(list);
	}
}

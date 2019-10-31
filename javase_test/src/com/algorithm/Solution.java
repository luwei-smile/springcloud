package com.algorithm;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年9月20日上午9:49:36
 * 
 * @Todo: 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 *        请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution {

	public boolean Find() {
		int target = 9;
		int[][] test = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		int len = test.length;
		System.out.println(len);
		for (int i = 0; i <= len; i++) {
			for (int j = 0; j < test[i].length; j++) {
				if (target == test[i][j])
					return true;
			}
		}
		return false;
    }

	public String ReplaceSpace() {
		StringBuffer str = new StringBuffer("sd sds dsd");
		while (str.indexOf(" ") != -1) {
			System.out.println("1111111111111");
			int start = str.indexOf(" ");
			str.replace(start, start + 1, "%20");
			System.out.println(str);
		}
		System.out.println(str);

		return str.toString();

	}

}

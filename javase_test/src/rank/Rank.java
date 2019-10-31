package rank;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.Random;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月2日下午3:26:34
 * 
 * @Todo: 选择排序
 */
public class Rank {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		// list.add(35);
		// list.add(52);
		// list.add(11);
		// list.add(6);
		// list.add(8);
		// list.add(11);
		// list.add(3);
		// list.add(23);
		// list.add(35);
		// list.add(44);
		Random random = new Random(new Date().getTime());
		System.out.println("选择排序:");
		for (int i = 0; i < 10; i++) {
			list.add(random.nextInt(99));
		}
		System.out.println(list);
		new Choice().rank(list);
		System.out.println(list);
		list.clear();

		System.out.println("直接插入排序:");
		for (int i = 0; i < 10; i++) {
			list.add(random.nextInt(99));
		}
		System.out.println(list);
		new direct().rank(list);
		System.out.println(list);
		list.clear();

		System.out.println("希尔排序:");
		for (int i = 0; i < 10; i++) {
			list.add(random.nextInt(99));
		}
		System.out.println(list);
		new shell().rank(list);
		System.out.println(list);
	}

	
}


class Choice {
	// @Todo:选择排序
	public void rank(ArrayList<Integer> list) {
		Integer temp = null;
		Integer index = null;
		Integer k = 0;

		for (int i = 0; i < list.size() - 1; i++) {
			temp = list.get(i);
			index = i;
			for (int j = i + 1; k < list.size() - j; j++) {// 0-1=9 4-5=5
				if (list.get(j) < temp) {
					temp = list.get(j);// 6
					index = j;// 5
				}

			}
			k = 0;
			temp = list.get(i);
			list.set(i, list.get(index));
			list.set(index, temp);
		}
	}
}

class direct {// size = 1
	// @Todo:直接插入排序
	public void rank(ArrayList<Integer> list) {
		LinkedList<Integer> temp = new LinkedList<Integer>();
		temp.add(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			for (int j = 0; j<temp.size(); j++) {
				if (temp.get(j) > list.get(i)) {
					temp.add(j, list.get(i));
					break;
				}
			}
			if (i == temp.size()) {
				temp.add(list.get(i));
			}
		}
		list.clear();
		list.addAll(temp);
	}
}

class shell {
	// @Todo:TODO
	public void rank(ArrayList<Integer> list) {
		int size = list.size() / 2;
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int i = 0; size > 2; i++) {
			for (int j = 0; j < list.size(); j += size) {
				temp.add(j);// 记录加入元素的下标
				temp.add(list.get(j));
			}
			new Choice().rank(temp);
			for (int j = 0; j < temp.size(); j += 2) {
				System.out.println(temp);
				list.set(temp.get(j), temp.get(j + 1));
				System.out.println(temp.size() + "=======" + j);
			}
			size /= 2;
			temp.clear();
		}
		System.out.println(list);
		new Choice().rank(list);
	}
}

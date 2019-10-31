package com.Interface;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年9月18日下午3:25:00
 * 
 * @Todo: 数组策略排序
 */
public class Imp2 {
	public static void main(String[] args) {

		Integer[] age = { 25, 10, 15, 20, 8, 13 };
		ComparatASC asc = new ComparatASC();
		ComparatDESC desc = new ComparatDESC();
		Arrays.sort(age, desc);
		System.out.println("age = " + Arrays.toString(age));

		// 自定义排序
		String[] order = { "语文", "数学", "英语", "物理", "化学", "生物", "政治", "历史", "地理", "总分" };
		final List<String> definedOrder = Arrays.asList(order);
		ComparatDEFINE define = new ComparatDEFINE(definedOrder);
		Collections.sort(definedOrder, define);
		System.out.println("definedOrder = " + definedOrder);

	}
}

class ComparatASC implements Comparator<Integer> {

		// TODO:升序
		@Override
		public int compare(Integer o1, Integer o2) {
			if (o1 > o2) {
				return -1;
			} else {
				return 1;
			}
	}

}

	class ComparatDESC implements Comparator<Integer> {

		// TODO:降序
		@Override
		public int compare(Integer o1, Integer o2) {
			if (o1 > o2) {
				return 1;
			} else {
				return -1;
			}
		}
	}

class ComparatDEFINE implements Comparator<String> {

		private final List<String> definedOrder;

		public ComparatDEFINE(List<String> definedOrder) {
			this.definedOrder = definedOrder;
		}

	// TODO:自定义排序
		@Override
		public int compare(String o1, String o2) {
			int io1 = definedOrder.indexOf(o1);
			int io2 = definedOrder.indexOf(o2);
		return io2 - io1;
		}
	}



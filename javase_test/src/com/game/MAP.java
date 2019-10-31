package com.game;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年10月6日下午9:04:22
 * 
 * @Todo: TODO
 */
public class MAP {

	//@Todo:TODO
	public static void main(String[] args) {

		Map<people, String> map = new HashMap<>();
		map.put(new people("qw", 12), "1");
		map.put(new people("qw", 12), "2");
		ArrayList<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(2);
		list.add(4);
		Iterator<Integer> iterator = list.iterator();
		System.out.println(iterator.hasNext());
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		list.sort(new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				Integer l1 = (Integer) o1;
				Integer l2 = (Integer) o2;
				if (l1 < l2) {
					return 1;
				}
				return -1;
			}

		});

		try {
			FileInputStream stream = new FileInputStream("D:/text.txt");
			byte[] temp = new byte[1024];
			int len;
			len = stream.read(temp);
			System.out.println("==" + len);
			while ((len = stream.read(temp)) != -1) {
				System.out.println(len);
				String file = new String(temp, 0, len);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list);
	}

}

class people {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "people [name=" + name + ", age=" + age + "]";
	}

	public people(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}


}

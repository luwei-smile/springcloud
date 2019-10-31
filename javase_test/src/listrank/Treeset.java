package listrank;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Auther 卢伟
 * 
 * @Time 2019年9月29日下午7:47:07
 * 
 * @Todo: TreeSet自定义排序
 */
public class Treeset {

	//@Todo:TODO
	public static void main(String[] args) {

		Comparator<people> com = new Comparator<people>() {
			@Override
			public int compare(people o1, people o2) {
				int i = o1.getGroup().compareTo(o2.getGroup());
				if (i == 0) {
					i = o1.getAge() - o2.getAge();
				}
				return i;
			}
		};

		TreeSet<people> ts = new TreeSet<people>(com);
		ts.add(new people("长春c", "aa", 2));
		ts.add(new people("啊啊a", "dbb", 3));
		ts.add(new people("订单d", "ee", 5));
		ts.add(new people("版本b", "cc", 1));
		ts.add(new people("嗯嗯e", "add", 4));
		ts.add(new people("方法f", "cdd", 3));
		ts.add(new people("刚刚g", "dd", 4));

		Iterator<people> iterator = ts.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}

class people {
	private String name;
	private String group;
	private int age;

	public people(String name, String group, int age) {
		super();
		this.name = name;
		this.group = group;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "people [name=" + name + ", group=" + group + ", age=" + age + "]";
	}

}

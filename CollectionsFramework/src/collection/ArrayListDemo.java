package collection;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {

		ArrayList al = new ArrayList();
		al.add(105);
		al.add("ABC");
		al.add('B');
		
		for(Object a:al) {
			System.out.println(a);
		}

	}

}

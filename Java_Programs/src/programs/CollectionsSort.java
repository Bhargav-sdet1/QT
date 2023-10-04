package programs;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsSort {

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(123);
		al.add(234);
		al.add(135);
		al.add(345);
		al.add(111);
		
		System.out.println("Before Sort"+al);
		Collections.sort(al);
		System.out.println("After Sort"+al);
		Collections.reverse(al);
		System.out.println("Reverse Sort"+al);
	}

}

package programs;

import java.util.Scanner;

public class ScannerClassDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String");
		String name = sc.next();
		System.out.println("Entered String is: " + name);
	
		StringBuffer sb = new StringBuffer(name);
		sb.reverse();
		String str2=sb.toString();
		if(name.equalsIgnoreCase(str2))
		{
			System.out.println("It's a Palindrome string");
		}
		else
		{
			System.out.println("Not a Palindrome String");
		}

	}

}

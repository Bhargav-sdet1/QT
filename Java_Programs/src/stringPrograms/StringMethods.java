package stringPrograms;

public class StringMethods {

	public static void main(String[] args) {
		String str="This is Selenium Java";
		String str1="This is selenium Java";
		
		System.out.println(str.length());
		System.out.println(str.charAt(5));
		System.out.println(str.indexOf('s'));
		System.out.println(str.indexOf('s',str.indexOf('s')+1));
		
		//String comparision
		System.out.println(str.equals(str1));
		System.out.println(str.equalsIgnoreCase(str1));
		
		//Substring
		System.out.println(str.substring(8, 16));
		System.out.println(str.substring(8));
		
		//trim
		String s="    hello world "; 
		System.out.println(s.trim());
		System.out.println(s.replace(" ", ""));
		
		//split
		String test = "Hello_World_Selenium_Java";
		String testval[]=test.split("_");
		for(String v:testval)
		{
			System.out.println(v);
		}
		//concat
		String a ="hello";
		String b="world";
		int x=100;
		int y=200;
		
		System.out.println(a+b+x+y);
		System.out.println(x+y+a+b);
		System.out.println(a+b+(x+y));
		

	}

}

package stringPrograms;

public class StringMethods {

	public static void main(String[] args) {
		String str="This is Selenium Java";
		
		System.out.println(str.length());
		System.out.println(str.charAt(5));
		System.out.println(str.indexOf('s'));
		System.out.println(str.indexOf('s',str.indexOf('s')+1));
		

	}

}

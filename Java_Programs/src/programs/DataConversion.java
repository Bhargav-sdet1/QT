package programs;

public class DataConversion {

	public static void main(String[] args) {
		//String -> int, double, boolean
		String s = "200";
		int i = Integer.parseInt(s);
		System.out.println(i);
		
		String s1 = "300.23";
		double d = Double.parseDouble(s1);
		System.out.println(d);
		
		String s2 = "true";
		boolean b = Boolean.parseBoolean(s2);
		System.out.println(b);
		
		//int, double, boolean, char->String
		
		int i4= 999;
		String s4= String.valueOf(i4);
		System.out.println(s4);
		
		double d1= 333.33;
		String s3=String.valueOf(d1);
		System.out.println(s3);
		
		boolean b1= false;
		String s5= String.valueOf(b1);
		System.out.println(s5);
		
		char ch= 'g';
		String s6= String.valueOf(ch);
		System.out.println(s6);


		

	}

}

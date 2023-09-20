package programs;

public class StringBufferDemo {

	public static void main(String[] args) {
		
		StringBuffer sb1= new StringBuffer("Selenium");
		//StringBuffer sb2=sb1.append(" with java");
		//StringBuffer sb2 =sb1.replace(1, 2, "a");
		//StringBuffer sb2 =sb1.delete(1, 3);
		String sb2 =sb1.toString();
		System.out.println(sb1);
		//System.out.println(sb2);
		String sb3=sb2.replace('S', 'M');
		System.out.println(sb3);
		System.out.println(sb2);
		

	}

}

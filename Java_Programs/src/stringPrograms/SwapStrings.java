package stringPrograms;

public class SwapStrings {

	public static void main(String[] args) {
		String a ="Bhargav is Ram";
		String b ="Vithika is Manisha";
		System.out.println("Before Swaping");
		System.out.println("a value is:"+a);
		System.out.println("b value is:"+b);
		a=a+b;
		b=a.substring(0,a.length()-b.length());
		a=a.substring(b.length());
		System.out.println("After Swaping");
		System.out.println("a value is:"+a);
		System.out.println("b value is:"+b);
			
	}

}

package nalabs_Programs;

public class MethodOverloadingwithNullArgument {

	public static void  test(Object o)
	{
		System.out.println("Object method");
	}
	public static void test(String s)
	{
		System.out.println("String method");
	}
	public static void main(String[] args) {
		test(null);
	}

}

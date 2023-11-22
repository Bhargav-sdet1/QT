package nalabs_Programs;

public class DoubleMinValue {

	public static void main(String[] args) {
		System.out.println(Double.MIN_VALUE);//positive number
		System.out.println(Float.MIN_VALUE);//positive number

		System.out.println(Integer.MIN_VALUE);//negative number
		System.out.println(Long.MIN_VALUE);//negative number

		System.out.println(Math.min(Double.MIN_VALUE, 0.0));//0.0
		System.out.println(Math.min(Double.MIN_VALUE, Double.NEGATIVE_INFINITY));//0.0
	

	}

}

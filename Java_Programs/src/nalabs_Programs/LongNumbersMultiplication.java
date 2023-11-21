package nalabs_Programs;

public class LongNumbersMultiplication {

	public static void main(String[] args) {
		//will not give the exact o/p 
		long longwithoutL=1000*60*60*24*365;
		System.out.println(longwithoutL);
		
		//will give the exact o/p 
		long longwithL=1000*60*60*24*365L;
		System.out.println(longwithL);

	}

}

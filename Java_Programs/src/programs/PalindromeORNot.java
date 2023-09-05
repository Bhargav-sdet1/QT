package programs;

public class PalindromeORNot {

	public static void main(String[] args) {
		int num=9559;
		int orgNum=num;
		int rev=0;
		int rem;
		
		while(num!=0)
		{
			rem= num%10;
			rev= rev*10+rem;
			num=num/10;
		}
		if(orgNum==rev)
		{
			System.out.println("Palindrome");
		}
		else
		{
			System.out.println("Not a Palindrome");
		}
		
		
	}

}

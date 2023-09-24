package programs;

public class StringBufferPalindrome {

	public static void main(String[] args) {
		String str = "Madam";
		
		StringBuffer sb = new StringBuffer(str);
		sb.reverse();
		String str2=sb.toString();
		if(str.equalsIgnoreCase(str2))
		{
			System.out.println("Palindrome string");
		}
		else
		{
			System.out.println("Not a Palindrome String");
		}

	}

}

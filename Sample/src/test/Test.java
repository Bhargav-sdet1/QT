package test;

public class Test {

	public static void main(String[] args) {
		String input = "ABCDE";
		char ch[]=input.toCharArray();

		for (int i = 0; i < ch.length; i++) {
			for (int j = 0; j < i+1; j++) {
				System.out.print(ch[i]);
			}
			System.out.println();
		}
	}

}

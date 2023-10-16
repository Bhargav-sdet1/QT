package arrayPrograms;

public class LargestandSmallestinArray {

	public static void main(String args[]) {
		int numbers[] = { -10, 55551, 2, 9, 999, 1999 };

		int smallest = numbers[0];
		int largest = numbers[0];

		for (int i = 1; i < numbers.length; i++) {
			if(numbers[i]>largest)
			{
				largest=numbers[i];
			}
			else if(numbers[i]<smallest)
			{
				smallest=numbers[i];
			}
		}
		System.out.println("Smallest number is:"+smallest);
		System.out.println("Largest number is:"+largest);

	}
}

package nalabs_Programs;

public class DuplicateElements {

	public static void main(String[] args) {
		
		String names[]= {"java","c","python","java","c","ruby","python"};
		int count=0;
		
		for(int i=0;i<names.length;i++)
		{
			for(int j=i+1;j<names.length;j++)
			{
				if(names[i].equals(names[j]))
				{
					count++;
					System.out.println("Duplicate element is: "+names[i]);
				}
			}
		}
		System.out.println("No. of Duplicates: "+count);

	}

}

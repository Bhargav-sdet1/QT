package nalabs_Programs;

public class DuplicateElements {

	public static void main(String[] args) {
		
		String names[]= {"java","c","python","java","c","ruby"};
		
		for(int i=0;i<names.length;i++)
		{
			for(int j=i+1;j<names.length;j++)
			{
				if(names[i].equals(names[j]))
				{
					System.out.println("Duplicate element is: "+names[i]);
				}
			}
		}

	}

}

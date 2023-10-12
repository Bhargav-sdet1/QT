package nalabs_Programs;

import java.util.HashSet;
import java.util.Set;

public class DuplicateElementsHashSet {

	public static void main(String[] args) {
		
		String names[]= {"java","c","python","java","ruby","c"};
		int count=0;
		
		Set<String> namesele=new HashSet<String>();
		
		for(String name:names)
		{
			if(namesele.add(name)==false)
			{
				count++;
				System.out.println("Duplicate ele is: "+name);
			}
		}
		System.out.println("No. of Duplicate ele: "+count);
	}

}

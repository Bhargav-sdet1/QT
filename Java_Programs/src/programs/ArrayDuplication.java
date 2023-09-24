package programs;

import java.util.Arrays;

public class ArrayDuplication {

	public static void main(String[] args) {
		
		int a[]= {11,3,16,8,10}; 
		int b[]={12,3,10,12,30};
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		for(int k=0;k<a.length;k++)
		{
			for(int l=0;l<b.length;l++)
			{
				if(a[k]==b[l])
				{
					System.out.println("Duplicate:"+a[k]);
				}
			}
		}

	}

}

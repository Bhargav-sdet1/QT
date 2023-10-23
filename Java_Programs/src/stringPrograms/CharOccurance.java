package stringPrograms;

import java.util.HashMap;

public class CharOccurance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="bhargav";
		// Converting String into array
		char ch[]=s.toCharArray();
		// Creating Map
		HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
		// Iterating array elements
		for(char c:ch)
		{
		   if(hm.containsKey(c))
		   {
		      // Storing value into Map
		      hm.put(c,hm.get(c)+1);
		   }
		   else
		   {
		      // Storing value into Map
		      hm.put(c,1);
		   }
		}
		// Print values
		System.out.println(hm);
	}

}

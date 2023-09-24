package programs;

public class StarPyramid {

	public static void main(String[] args) {

		int row=5;
		
		for(int i=0;i<row;i++)
		{
			//inner loop work for space
			for (int j=row-i; j>1; j--)   
			{  
			//prints space between two stars  
			System.out.print(" ");   
			}   
			for(int j=0;j<=i;j++){
				System.out.print("* ");
			}
			System.out.println();
		}

	}

}

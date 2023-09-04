package pack1;

public class Swap2without3rd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=2, b=3;
		System.out.println("a before swap is "+a+" b before swap is "+b);
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("a after swap is "+a+" b after swap is "+b);


	}

}

package Practise;

public class GenericMethodPractise {

	public static void main(String[] args) {
		int sum = add(20,30);
		System.out.println(sum);
		System.out.println(add(sum,80));
		add(90,30);
		int sub=subtract(80,40);
		System.out.println(sub);
		
		int mul=multiply(80,40);
		System.out.println(mul);
	}
	
	public static int add(int a, int b) {
		int c=a+b;
		return c;

	}
	
	public static int subtract(int a, int b) {
		int c=a-b;
		return c;

	}
	
	public static int multiply(int a, int b) {
		int c=a*b;
		return c;

	}
	
	
	
	
}
package euler;

/**
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
public class Six {
	public static long six(){
		final int MAX = 100;
		return squareOfSums(MAX)-sumOfSquares(MAX);
	}
	
	public static long sumOfSquares(int max){
		long total = 0;
		for(int i=1;i<=max;i++){
			total+=i*i;
		}
		
		return total;
	}
	
	public static long squareOfSums(int max){
		long total = 0;
		for(int i=1;i<=max;i++){
			total += i;
		}
		return total*total;
	}
	
	public static void main(String... args){
		System.out.println(sumOfSquares(10));
		System.out.println(squareOfSums(10));
		
		System.out.println(squareOfSums(10)-sumOfSquares(10));
		
		System.out.println(six());
	}
}

package euler;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10 001st prime number?
 */
public class Seven {

	public static int seven(){
		int count = 0;
		int i = 1;
		
		while(true){
			i++;
			if(isPrime(i)){
				count++;
				
				if(count==10001){
					return i;
				}
			}
		}
	}
	
	private static boolean isPrime(int num){
		for(int i=2;i<=Math.sqrt(num);i++){
			if(num%i==0){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String... args){
		System.out.println(seven());
	}
}

package euler;

import java.util.Collections;

import org.junit.Test;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 */
public class Ten {

	@Test
	public void siv(){
		sieve();
	}

	@Test
	public void inc(){
		incremental();
	}


	public static double sieve(){
		final int UPPER_BOUND = 2000000;

		boolean[] set = new boolean[UPPER_BOUND];

		for(int i=2;i<UPPER_BOUND;i++){
			if(!set[i]){
				for(int k=i*2;k<UPPER_BOUND;k+=i){
					set[k] = true;
				}
			}
		}

		double total = 0;
		for(int i=2;i<set.length;i++){
			if(!set[i]){
				total+=i;
			}
		}

		return total;
	}

	public static double incremental(){
		final int UPPER_BOUND = 2000000;

		double total = 0;
		for(int i=2;i<UPPER_BOUND;i++){
			if(isPrime(i)){
				total+=i;
			}
		}

		return total;
	}

	private static boolean isPrime(int input){
		for(int i=2;i<=Math.sqrt(input);i++){
			if(input%i==0){
				return false;
			}
		}
		return true;
	}
	public static void main(String... args){
		System.out.println(sieve());
	}
}

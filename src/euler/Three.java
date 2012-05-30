package euler;

import java.util.ArrayList;
import java.util.List;
import static utility.MiscUtil.*;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
 */
public class Three {
	private static final int PRIME_COUNT = 1000;
	private static final int[] PRIMES = new int[PRIME_COUNT];
			
	public static int three(){
		final long NUM = 600851475143L;
		final long GROUP_MAX = 10;


		List<Integer> groups = new ArrayList<Integer>();
		long total;
		while(true){
			while(total<NUM){
				groups.add(e)
			}
		}

		return 0;
	}

	private static int[] ofGroup(int groupNum,int[] holder,int[] previousIndexes){
		
	}

	private static boolean isPrime(int num){
		for(int i=2;i<=Math.sqrt(num);i++){
			if(num%i==0){
				return false;
			}
		}
		return true;
	}

	private static void primes(){
		final int limit = 10000;
		List<Integer> primes = new ArrayList<Integer>();

		for(int i=2;i<limit;i++){
			if(isPrime(i)){
				primes.add(i);
			}
		}

		for(int i=0;i<primes.size();i++){
			PRIMES[i] = primes.get(i);
		}
		
		
	}

	public static void main(String... args){
		System.out.println(three());

		printArr(PRIMES);
		//System.out.println(isPrime(7));

	}
}

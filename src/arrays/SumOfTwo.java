package arrays;
import static utility.MiscUtil.*;

public class SumOfTwo {
	public static int sumOfTwo(int[] input){
		int largeOne = Integer.MIN_VALUE;
		int largeTwo = Integer.MIN_VALUE;

		for(int i:input){
			if(i>largeOne){
				largeTwo = largeOne;
				largeOne = i;
			}
			else if(i>largeTwo){
				largeTwo = i;
			}
		}

		return largeOne+largeTwo;
	}

	public static void main(String... args){
		final int SIZE = 10;
		int[] input = new int[SIZE];

		for(int i=0;i<input.length;i++){
			input[i] = randBetween(0, 100);
		}
		shuffle(input);
		printArr(input);
		
		System.out.println(sumOfTwo(input));
	}
}
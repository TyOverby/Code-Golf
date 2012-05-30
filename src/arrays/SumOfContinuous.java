package arrays;

import static utility.MiscUtil.*;

public class SumOfContinuous {

	public static int sumOfContinuous(int[] input){
		int largest = Integer.MIN_VALUE;
		
		for(int start=0;start<input.length;start++){
			for(int end=start+1;end<input.length;end++){
				int total = total(input,start,end);
				if(total>largest){
					largest = total;
				}
			}
		}
		
		return largest;
	}
	
	public static int total(int[] array, int startPos, int endPos){
		int total=0;
		for(int i=startPos;i<=endPos;i++){
			total+=array[i];
		}
		
		return total;
	}
	
	public static void main(String... args){
		final int SIZE = 10;
		final int RANGE = 10;
		int[] input = new int[SIZE];
		
		for(int i=0;i<input.length;i++){
			input[i] = randBetween(-RANGE, RANGE);
		}
		printArr(input);
		
		System.out.println(sumOfContinuous(input));
	}
}

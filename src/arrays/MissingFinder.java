package arrays;

import static utility.MiscUtil.*;

public class MissingFinder {
	public static int missingFinder(int[] input){
		boolean[] bVector = new boolean[input.length+1];
		for(int i:input){
			bVector[i]=true;
		}
		
		for(int i=0;i<bVector.length;i++){
			if(!bVector[i]){
				return i;
			}
		}
		
		return -1;
	}
	
	public static void main(String... args){
		final int SIZE = 10;
		
		int[] input = new int[SIZE-1];
		int missing = (int) Math.floor(Math.random()*SIZE);
		for(int i=0,k=0;i<SIZE;i++){
			if(i!=missing){
				input[k]=i;
				k++;
			}
		}
		shuffle(input);
		printArr(input);
		
		System.out.println(missingFinder(input));
	}
}

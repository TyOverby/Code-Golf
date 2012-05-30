package arrays;

import static utility.MiscUtil.*;

public class DoubleFinder {

	public static int doubleFinder(int[] input){
		for(int i=0;i<input.length;i++){
			for(int k=i+1;k<input.length;k++){
				if(input[i]==input[k]){
					return input[i];
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String... args){
		final int SIZE = 10000;
		
		int[] input = new int[SIZE];
		for(int i=0;i<input.length;i++){
			input[i] =i;
		}
		int randomIndex = (int) Math.floor(Math.random()*SIZE);
		int randomValue = (int) Math.floor(Math.random()*SIZE);
		input[randomIndex]=randomValue;
		
		shuffle(input);
//		printArr(input);
		
		System.out.println();
		System.out.println(doubleFinder(input));
	}
}

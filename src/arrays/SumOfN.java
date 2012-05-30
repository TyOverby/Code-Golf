package arrays;
import static utility.MiscUtil.*;

public class SumOfN {
	public static int sumOfN(int[] input, int n){
		int[] queue = new int[n];
		fill(queue,0);
		
		for(int i=0;i<input.length;i++){
			for(int k=0;k<n;k++){
				if(input[i]>queue[k]){
					insert(queue,k,input[i]);
					break;
				}
			}
		}
		return total(queue);
	}
	
	private static int total(int[] input){
		int total = 0;
		for(int i:input){
			total+=i;
		}
		return total;
	}
	
	private static void insert(int[] array, int pos, int value){
		for(int i=array.length-2;i>=pos;i--){
			array[i+1]=array[i];
		}
		array[pos]=value;
	}
	
	
	public static void main(String... args){
		final int SIZE = 10;
		int[] input = new int[SIZE];
		
		for(int i=0;i<input.length;i++){
			input[i]=randBetween(0, 9);
		}
		
		printArr(input);
		System.out.println(sumOfN(input,3));
	}
}

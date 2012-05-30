package utility;

public class MiscUtil {
	public static void shuffle(int[] input){
		for(int i=0;i<input.length;i++){
			int newLocation = randBetween(i+1,input.length-1);
			swap(input,i,newLocation);
		}
	}
	
	public static void fill(int[] array, int fillValue){
		for(int i=0;i<array.length;i++){
			array[i] = fillValue;
		}
	}
	
	private static void swap(int[] array,int startLoc, int endLoc){
		int temp = array[startLoc];
		array[startLoc] = array[endLoc];
		array[endLoc]   = temp; 
	}
	
	public static int randBetween(int start, int end){
		return (int) (Math.floor(Math.random()*(end-start))+start);
	}
	
	public static void printArr(int[] input){
		System.out.print("[");
		for(int i=0;i<input.length;i++){
			System.out.print(input[i]);
			if(i!=input.length-1){
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}
}

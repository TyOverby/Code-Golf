package euler;
/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class Five {

	public static int five(){
		int num=0;
		
		while(true){
			num+=20;
			
			if(validate(num)){
				return num;
			}
		}
	}
	
	private static boolean validate(int input){
		for(int i=2;i<=20;i++){
			if(validateNum(input, i)==false){
				return false;
			}
		}
		return true;
	}
	
	private static boolean validateNum(int input, int mod){
		return (input%mod==0);
	}
	
	public static void main(String... args){
		System.out.println(five());
	}
}

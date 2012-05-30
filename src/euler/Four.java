package euler;

/**
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 99.
 * 
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Four {
	public static int four(){
		final int END_POINT   = 999;
		
		int max = Integer.MIN_VALUE;
		
		for(int i=END_POINT;i>0;i--){
			for(int k=i;k>0;k--){
				int mult = i*k;
				if(mult<max){
					return max;
				}
				if(isPalindrome(mult)){
					if(mult>max){
						max = mult;
					}
				}
			}
		}
		
		return max;
	}
	
	public static boolean isPalindrome(int input){
		String in = ""+input;
		
		for(int i=0;i<in.length()/2;i++){
			int head = i;
			int tail = in.length()-1-i;
			
			if(in.charAt(head)!=in.charAt(tail)){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String... args){
		System.out.println(four());
		
		System.out.println(isPalindrome(123454321));
	}
}

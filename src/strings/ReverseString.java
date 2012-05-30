package strings;

public class ReverseString {
	public static char[] reverseString(char[] input){
		char[] buffer = new char[input.length];
		for(int i=0,k=input.length-i-1;i<input.length;i++,k=input.length-i-1){
			buffer[k]=input[i];
			System.out.println(k+" "+i);
		}
		
		return buffer;
	}
	
	public static void main(String... args){
		char[] input = "This is a test".toCharArray();
		System.out.println(reverseString(input));
		
	}
}

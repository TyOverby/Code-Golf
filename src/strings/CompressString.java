package strings;

public class CompressString {
	public static String compressString(char[] input){
		String toReturn="";
		char previousChar =input[0];
		int count = 1;
		
		for(int i=1;i<input.length;i++){
			if(input[i]==previousChar){
				count++;
			}
			else{
				toReturn += count+""+previousChar+" ";
				previousChar = input[i];
				count=1;
			}
		}
		
		// We need to catch the final grouping
		toReturn += count+""+previousChar+" ";
		return toReturn;
	}
	
	public static void main(String... args){
		char[] input = "aaabbbbbbccd".toCharArray();
		System.out.println(compressString(input));
	}
}

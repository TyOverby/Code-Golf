package strings;

public class RemoveUnderscores {
	public static char[] removeUnderscores(char[] chars){
		char[] buffer = new char[chars.length];
		int curpos=0;

		for(int i=0;i<chars.length;i++){
			if(i>0){
				if(chars[i]=='_'&&chars[i-1]=='_'){
					// Don't add the underscore character here
				}
				else{
					buffer[curpos]=chars[i];
					curpos++;
				}
			}
			else{
				buffer[curpos]=chars[i];
				curpos++;
			}
		}
		
		return buffer;
	}


	public static void main(String... args){
		char[] input ="___this__is_a____test".toCharArray();
		
		System.out.println(removeUnderscores(input));

	}
}

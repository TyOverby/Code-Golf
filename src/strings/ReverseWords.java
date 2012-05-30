package strings;

import java.util.ArrayList;
import java.util.List;

public class ReverseWords {
	
	public static String reverseWords(String input){
		// Create a new list of all of the words in the string
		List<String> words = new ArrayList<String>();
		// Prepare a string to return
		String toReturn ="";
		// Keep track of the position of the last word that we grabbed.
		int lastPosition = 0;
		
		// Loop through all of the characters in the input string.
		for(int i=0;i<input.length();i++){
			// If the character is a space, or we have reached the end of the string, 
			// Add the substring from the last position to the current position and then
			// make the "last position", the current position
			if(input.charAt(i)==' ' || i==input.length()-1){
				words.add(input.substring(lastPosition, i+1).trim());
				lastPosition = i+1;
			}
		}
		
		// Add all of the words back into the string to return in reverse order
		for(int i=words.size()-1;i>=0;i--){
			toReturn+=words.get(i)+" ";
		}
		return toReturn;
	}
	
	public static void main(String... args){
		String input ="This is a test";
		
		System.out.println(reverseWords(input));
	}

}

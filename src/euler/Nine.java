package euler;

/**
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class Nine {

	public static int nine(){
		final int UPPER_BOUND = 1000;
		
		for(int a=1;a<UPPER_BOUND;a++){
			for(int b=1;b<UPPER_BOUND;b++){
				int cSquared = a*a+b*b;
				
				if(isIntSquared(cSquared)){
					int c = (int)(Math.sqrt(cSquared)+0.1);
					System.out.println("working");
					if(a+b+c==1000){
						return a*b*c;
					}
				}
			}
		}
		
		return -1;
	}
	
	private static boolean isIntSquared(int input){
		for(int i=0;i<Math.sqrt(input)+1;i++){
			if(i*i==input){
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String... args){
		System.out.println(nine());
	}
}

import org.junit.Test;
import static utility.MiscUtil.*;


public class MiscUtilTest {
	@Test
	public void testRandomRange(){
		int start = 5;
		int end   = 10;

		System.out.println(randBetween(start, end));
	}

	@Test 
	public void testShuffle(){
		final int SIZE = 10;
		int[] array = new int[SIZE];

		for(int i=0;i<SIZE;i++){
			array[i] = i;		
		}
		
		for(int i:array){
			System.out.print(i+" ");
		}
		
		System.out.println();
		shuffle(array);
		
		for(int i:array){
			System.out.print(i+" ");
		}
	}
}

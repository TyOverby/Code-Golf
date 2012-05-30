package tied_list;

import java.util.ArrayList;
import java.util.List;

import tied_list.TiedList.Group;

public class TiedListTest {
//	public static void testGroupInsert(){
//		Group<Integer> g = new Group<Integer>(4);
//		g.add(5);
//		g.add(10);
//		g.add(3);
//		
//		System.out.println(g.toString());
//		
//		g.insert(1, 999);
//		
//		System.out.println(g.toString());
//	}
//	
//	public static void testGroupTruncate(){
//		Group<Integer> group = new Group<Integer>(5);
//		
//		for(int i=0;i<3;i++){
//			group.add(i);
//		}
//		
//		System.out.println(group.toString());
//		
//		group.truncate();
//		
//		System.out.println(group.toString());
//		
//	}
//	
	public static void testTiedList(){
		TiedList<Integer> tiedList = new TiedList<Integer>(3);
		
		for(int i=0;i<20;i++){
			tiedList.add(i);
		}
		
		System.out.println(tiedList.toString());
	}
	
	public static void testListInsert(){
		TiedList<Integer> tiedList = new TiedList<Integer>(3);
		
		for(int i=0;i<10;i++){
			tiedList.add(i);
		}
		
		System.out.println(tiedList.toString());
		
		tiedList.add(5,999);
		System.out.println(tiedList.toString());
	}
	
	public static void testAddCollection(){
		List<Integer> collection = new ArrayList<Integer>();
		
		TiedList<Integer> tiedList = new TiedList<Integer>(3);
		
		for(int i=0;i<12;i++){
			collection.add(i);
		}
		
		tiedList.add(1);
		
		
		tiedList.addAll(collection);
		
		System.out.println(tiedList);
		
	}
	
	public static void testGet(){
		TiedList<Integer> tiedList = new TiedList<Integer>(3);
		
		for(int i=0;i<40;i++){
			tiedList.add(i);
		}
		
		System.out.println(tiedList.get(20));
	}

	public static void testIndexOf(){
		TiedList<Integer> tiedList = new TiedList<Integer>(3);
		
		for(int i=0;i<40;i++){
			tiedList.add(i);
		}
		
		System.out.println(tiedList.indexOf(0));
	}
	
	public static void main(String... args){
		testIndexOf();
	}
}

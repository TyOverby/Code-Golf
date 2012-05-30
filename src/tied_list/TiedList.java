package tied_list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TiedList<E> implements List<E> {
	public static class Group<E>{
		private int maxSize;
		private List<Group<E>> parentList;

		public Object[] arr;
		private int length = 0;

		public Group(int size,List<Group<E>> parent){
			this.maxSize = size;
			this.arr = new Object[size];
			
			this.parentList = parent;
		}

		public void add(E element){
			arr[length++]=element;
		}
		public void remove(int pos){
			Object[] newArr = new Object[arr.length-1];

			if(pos>0){
				System.arraycopy(arr, 0, newArr, 0, pos);
				System.arraycopy(arr, pos+1, newArr, pos, maxSize-1-pos);
			}
			else{
				System.arraycopy(arr, 1, newArr, 0, maxSize-1);
			}
			this.arr = newArr;
			length--;
			maxSize--;

			if(maxSize<=0){
				if(parentList!=null){
					parentList.remove(this);
				}
			}
		}

		public void insert(int pos, E element){
			if(pos<length ){//&& pos>0){
				if(isFull()){
					Object[] newArr = new Object[arr.length+1];

					System.arraycopy(arr, 0, newArr, 0, pos);
					newArr[pos] = element;
					System.arraycopy(arr, pos, newArr, pos+1, maxSize-pos);

					this.arr = newArr;
					length++;
					maxSize++;
				}
				else{
					System.arraycopy(arr, pos, arr, pos+1, maxSize-pos-1);
					arr[pos] = element;
					length++;
				}
			}
//			else if(pos==0){
//				
//				
//			}
			else{
				throw new IndexOutOfBoundsException(""+(pos<length-1)+"=="+pos);
			}
		}

		public void truncate(){
			if(!isFull()){
				Object[] newArr = new Object[length];
				System.arraycopy(arr, 0, newArr, 0, length);
				this.arr = newArr;
			}
			if(length==0){
				parentList.remove(this);
			}
		}

		public boolean isFull(){
			return maxSize<=length;
		}
		public boolean isEmpty(){
			return length>0;
		}

		public int length(){
			return length;
		}
		public int maxSize(){
			return maxSize;
		}

		public String toString(){
			int arrowPos=0;
			String arrow = "";
			String array="("+length+")[";
			for(int i=0;i<arr.length;i++){
				if(i==length-1){
					arrowPos = array.length();
				}

				if(arr[i]!=null){
					String added = arr[i].toString()+", ";
					array += added;
				}else{
					String added = "<null>, ";
					array+=added;
				}
			}
			array = array.substring(0, array.length()-2)+"]";
			for(int i=0;i<arrowPos;i++){
				arrow+=" ";
			}
			arrow += "^";

			return array+"\n"+arrow;
		}
	}

	private final int GROUP_SIZE;

	private LinkedList<Group<E>> groupList = new LinkedList<Group<E>>();
	private int size = 0;

	public TiedList(int groupSize){
		this.GROUP_SIZE = groupSize;

		groupList.add(new Group<E>(groupSize,groupList));
	}
	public TiedList(){
		this(10);
	}

	private Group<E> grow(){
		Group<E> newGroup = new Group<E>(GROUP_SIZE,groupList);
		groupList.add(newGroup);

		return newGroup;
	}

	@Override
	public boolean add(E element) {
		// Check all of the current groups.  If one has an empty slot, add it to that one;
		Group<E> lastGroup = groupList.getLast();
		if(!lastGroup.isFull()){
			lastGroup.add(element);
		}
		else{
			grow().add(element);
		}

		return true;
	}


	public String toString(){
		String toReturn ="";
		for(Group<E> group:groupList){
			toReturn+=group.toString()+"\n";
		}
		return toReturn;
	}

	@Override
	public void add(int index, E element) {
		int totalPosition=0;
		
		for(Group<E> group:groupList){
			totalPosition+=group.maxSize;
			if(totalPosition>=index){
				int diff = totalPosition-index;
				System.out.println("diff "+diff);
				group.insert(group.maxSize-diff,element);
				return;
			}
		}
	}

	@Override
	public boolean addAll(Collection<? extends E> collection) {
		// Truncate the last group because we are going to be creating a bunch more groups
		groupList.getLast().truncate();
		
		int count = 0;
		Group<E> group = new Group<E>(GROUP_SIZE,groupList);
		for(E o:collection){
			if(count<GROUP_SIZE){
				System.out.println("old");
				group.add(o);
				count++;
			}
			else{
				System.out.println("new");
				groupList.add(group);
				group=new Group<E>(GROUP_SIZE,groupList);
				
				group.add(o);
				count=1;
			}
		}
		
		return true;
	}

	@Override
	public boolean addAll(int arg0, Collection arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		this.groupList.clear();

	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) {
		int totalPosition=0;
		
		for(Group<E> group:groupList){
			totalPosition+=group.maxSize;
			if(totalPosition>index){
				int diff = totalPosition-index;
				System.out.println("diff "+diff);
				return (E) group.arr[group.maxSize-diff];
			}
		}
		
		throw new IndexOutOfBoundsException(": "+index);
	}

	@Override
	public int indexOf(Object arg0) {
		for(int i=0;true;i++){
			if(get(i).equals(arg0)){
				return i;
			}
		}
	}

	@Override
	public boolean isEmpty() {
		if(groupList.isEmpty()){
			return true;
		}
		else{
			if(groupList.getFirst().isEmpty()){
				return true;
			}
		}
		
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E remove(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object set(int arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}

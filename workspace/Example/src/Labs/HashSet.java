package Labs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class HashSet<T> implements Set<T> {
	private ArrayList<LinkedList<T>> structure;
	private int size;
	public HashSet() {
		clear();
	}
	@Override
	public void clear() {
		// Let the garbage collector to the actual work for us :-)
		structure = new ArrayList<LinkedList<T>>();
		for (int i = 0; i < 13; i++) {
			structure.add(new LinkedList<T>());
		}
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean add(T arg0) {

		try{
			if(!contains(arg0)){
			int index = arg0.hashCode()%13;
			if(structure.get(index).isEmpty()){
				LinkedList<T> a = new LinkedList<T>();
				a.add(arg0);
				structure.add(index,a);
			}
			else {
				structure.get(index).add(arg0);
			}
			size++;
			return true;
			}
			
		}
		catch (Exception e)
		{
			return false;
		}
		return false;

	}

	@Override
	public boolean contains(Object o) {
		int index = o.hashCode() %13;
		LinkedList<T> a = structure.get(index);
		if(a.isEmpty())
		{
			return false;
		}
		else{
			if(a.contains(o)){
				return true;
			}
		}

		return false;
	}
	@Override
	public boolean remove(Object o) {
		int index = o.hashCode() %13;
		LinkedList<T> a = structure.get(index);
		if(a.contains(o))
		{
			a.remove(o);
			size--;
			return true;
			
		}
		else {
			return false;
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int i = 0;
			Iterator<T> iterator = structure.get(0).iterator();
			{
				update();
			}
			private void update() {
				if (i >= 12) return; // should it be i >= 12 ??
				while(!iterator.hasNext()) {
					i++;
					iterator = structure.get(i).iterator();
				}
			}
			@Override
			public boolean hasNext() {
				update();
				return iterator.hasNext();
			}
			@Override
			public T next() {
				update();
				return iterator.next();
			}
		};
	}

	public boolean addAll(Collection arg0) {
		try{
			for(Object o:arg0){
				this.add((T) o);
			}
			return true;
		}
		catch(ClassCastException e){
			return false;
		}

	}


	public boolean containsAll(Collection arg0) {

		for(Object o:arg0){
			if(!this.contains(o))
			{
				return false;
			}
		}
		return true;

	}
	
	public boolean removeAll(Collection arg0) {
		//remove only if you have everything in the collection
		for(Object o:arg0){
			if(contains(arg0)){
				this.remove(o);
			}
			return true;
		}
			return false;
	}

	
	public Object[] toArray() {
		// TODO Auto-generated method stub
		Object[] anArray = new Object[13];
		
		for(int i = 0; i < 13; i++){
			LinkedList<T> a = new LinkedList<T>();
			for(T t:structure.get(i)){
				a.add(t);
			}
			anArray[i] = a;
		}
		
		return anArray;
	}

	// Don't bother implementing, unless you want to do reflection.
	
	public <T> T[] toArray(T[] a) {
		
		//check if a is large enough or create a new object 
		//T[] anArray = (T[]) new Object[13];
		//if it is large enough
		for(int i = 0; i < 13; i++){
			LinkedList<T> b = new LinkedList<T>();
			for(Object o:structure.get(i)){
				b.add((T) o);
			}
			a[i] = (T) b;
		}
		
		return a;
	}

	// Don't bother implementing.
	
	public boolean retainAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * The ArrayMerge class represents a generic collection that merges and manipulates arrays.
 * @author Elijah McCray
 * @author Anna Sloan
 * @version 4
 */


/**
 * 
 */
public class ArrayMerge <R>{
    // fields
    private int dSize;
	private ArrayList<R> data;
    private ArrayList<R> merged = new ArrayList<R>();
    public static final int DEFAULT_CAPACITY = 10;
    private StringBuilder sequence;


    /**
	 * Constructs an ArrayMerge with the specified initial capacity.
     *
     * @param size the initial capacity of the ArrayMerge
     */
	public ArrayMerge(int size){
		this.dSize = size;
		data = new ArrayList<R>(dSize);
    }
    
    /**
     * Constructs an ArrayMerge with a default capacity.
     */
    public ArrayMerge(){ // finished
        //creates a set of some initial size.
        this(DEFAULT_CAPACITY); 
    }

    /**
     * Constructs an ArrayMerge based on the elements of the provided collection.
     */
    public ArrayMerge(ArrayMerge<? extends R> collection) throws IllegalArgumentException{
        // creates a set based on collection
    	this(DEFAULT_CAPACITY);
    	if(collection == null) {
    		throw new IllegalArgumentException("This collection is invalid");
    	}
        	for(int i = 0; i < collection.data.size(); i++) {
        		this.data.add(collection.data.get(i));
        	}
    }

    /**
     * Adds an element to the collection.
     *
     * @param element the element to be added
     * @return true if the element was successfully added, false otherwise
     * @throws IllegalArgumentException if the provided element is null
     */
    public boolean add(R element) throws IllegalArgumentException {
		boolean result = false;
		if(element == null) {
			throw new IllegalArgumentException("This is an invalid element");
		}
		if (data.contains(element) == true) {
			result = false;
		} else {
			data.add(element);
			result = true;
		}
		if (data.size() > DEFAULT_CAPACITY) {
			dSize += DEFAULT_CAPACITY;
		}
		return result;
	}


	/**
	 * Removes all elements from the collection.
	 */
    public void clear(){
    	data.clear();
    }

    /**
     * Checks whether the collection contains the specified element.
     *
     * @param input the element to be checked for containment in the collection
     * @return true if the collection contains the specified element, false otherwise
     * @throws IllegalArgumentException if the provided input is null
     */
	public boolean contains(Object input) { 
		boolean result = false;
		if(input == null) {
			throw new IllegalArgumentException("This input is invalid");
		}
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).equals(input) != false) {
				result = true;
			}
		}
		return result;
	}

    /**
     * Checks whether the collection contains all elements in the collection.
     *
     * @param collection the collection to be checked for containment in this collection
     * @return true if this collection contains all elements in the collection or false otherwise.
     * @throws IllegalArgumentException if the provided collection is null
     */
    public boolean containsAll(ArrayMerge<?> collection) throws IllegalArgumentException { 
        boolean result = false;
        if(collection == null) {
        	throw new IllegalArgumentException("This collection is invalid");
		}
		for (int i = 0; i < collection.size(); i++) {
			if (data.contains(collection.get(i)) == true) {
				result = true;
			} else if(data.contains(collection.get(i)) == false){
				result = false;
				break;
			}

		}
		return result;
	}

	/**
	 * Compares this collection with the specified object for equality.
     *
     * @param other the object to be compared for equality with this collection
     * @return true if the specified object is equal to this collection, false otherwise
	 */
    public boolean equals(Object other){
        boolean equal = (other == this);
		ArrayMerge<R> test = (ArrayMerge<R>) other;
		if (!equal && test instanceof ArrayMerge) {
			if (this.isEmpty() == true && test.isEmpty() == true) {
				equal = true;
			}
			if (this.size() == test.size()) {
				if (this.containsAll(test)) {
					equal = true;
				}
			}
		} else {
			equal = false;
		}
		if (this.isEmpty() || test.isEmpty()) {
			if (this.isEmpty() == true && test.isEmpty() == false) {
				equal = false;
			} else {
				equal = true;
			}
		}
		return equal;
	}

    /**
     * Returns the element at the specified position in the collection.
     *
     * @param index the index of the element to return
     * @return the element at the specified position in the collection
     * @throws NoSuchElementException if the index is out of range
     */
    public R get(int index) throws  NoSuchElementException{
    	if(index > this.data.size()) {
    		throw new NoSuchElementException("This index is invalid");
    	}
        return this.data.get(index);
    }

    /**
     * Returns the capacity of the collection.
     *
     * @return the capacity of the collection
     */
    public int getCapacity(){ 
        return dSize;
    }

    /**
     * Checks whether the collection is empty.
     *
     * @return result true if the collection is empty, false otherwise
     */
    public boolean isEmpty(){
        boolean result;

        if (data.size() == 0){ // checks if the array is empty or not.
            result = true;
        } else {
        	result = false;
        }
        return result;
    }

    /**
     * Merges the elements of the specified collection into this collection at the specified offset.
     *
     * @param collection the collection whose elements are to be merged into this collection
     * @param offset     the offset at which to merge the elements of the collection
     * @throws IllegalArgumentException if the provided collection is null
     */
    public void merge (ArrayMerge<? extends R> collection, int offset) throws 
					IllegalArgumentException {

        try{
        	if(this.isEmpty() == false && collection.isEmpty() == false) {
        		for(int x = 0; x < collection.size(); x++) {
        			if(x == offset) {
        				continue;
        			}
        			if(x == offset+1) {
        				continue;
        			}
        			data.add(offset+x, collection.get(x));
        		}
        		for(int y = collection.size()+offset; y < collection.size()+offset+offset; y++) {
        			if(y == collection.size()+offset && data.contains(collection.get
								(y-(offset+offset)))) {
        				continue;
        			}
        			if(data.contains(collection.get(y-(offset+offset)))) {
            			data.add(y, collection.get(y-(offset+offset)));
        				data.set(data.size()-1, collection.get(collection.size()-1));
        			} else {
            			data.add(y, collection.get(y-(offset+offset)));
        			}
        			if(y == collection.size()+offset+1 && data.contains(collection.get
								(y-(offset+offset)))) {
        				break;
					}
				}
			}
		}
        catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Removes the first occurrence of the specified element from the collection.
     *
     * @param o the element to be removed from the collection
     * @return true if the element was removed successfully, false otherwise
     * @throws IllegalArgumentException if the provided element is null
     */
    public boolean remove(R o) throws IllegalArgumentException{
        try{
            for (int i = 0; i < data.size(); i++){ // loops through array until finds,
                if (data.get(i) == o){   		// what it is looking for then removes it.
                	data.remove(o);			
                    return true;
                }
            }
        }
        catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            return false;
        }
        return false;
    }


    /**
     * Retains only the elements in the collection that are contained in the specified collection.
     *
     * @param collection the collection containing the elements to be retained in this collection
     * @return true if the collection was modified as a result of this operation, false otherwise
     * @throws IllegalArgumentException if the provided collection is null
     */
    public boolean retainAll(ArrayMerge<?> collection) throws IllegalArgumentException{
        try{
        	boolean result = false;
        	for(int i = 1; i < data.size(); i++) {
        		if(collection.contains(data.get(0)) == false) {
        			data.remove(data.get(0));
        			result = true;
        			i = 0;
        		}
        		if(collection.contains(data.get(i)) == false) {
        			data.remove(data.get(i));
        			result = true;
        		}
        	}
            return result;
        }
        catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }

    /**
     * Returns the number of elements in the collection.
     *
     * @return the number of elements in the collection
     */
    public int size(){
    	int counter = 0;
        for (int i = 0; i < data.size(); i++) {
           if (data.get(i) != null) {
               counter++;
           }
        }
        return counter;
    }

    /**
     * Unmerges the elements previously merged into this collection at the specified offset.
     *
     * @param offset the offset at which to unmerge the elements from the collection
     */
    public void unMerge(int offset){ 
        for(int i = 1; i < data.size(); i++) {
        	if(offset+i >= data.size()) {
        		break;
        	}
        	if(i != offset && i != offset+1) {
        		data.remove(data.get(offset+i));
        	}
        	
        }
        for(int x = offset; x < data.size(); x+=offset) {
        	data.remove(data.get(x));
        }
        dSize = dSize/2;
    }

    /**
     * Returns a string representation of the collection.
     *
     * @return a string representation of the collection
     */
    public String toString(){
    	sequence = new StringBuilder("<");
        if(data.isEmpty()) {
            sequence.append(">");
            return sequence.toString();
        }
        for(int i = 0; i < data.size(); i++) {
        	if(i < data.size()-1) {
        		sequence.append(data.get(i));
        		sequence.append(", ");
        	} else {
        		sequence.append(data.get(i));
        	}
        }
        sequence.append(">");
        return sequence.toString();
    }
}

package datastructures;

import java.lang.reflect.Array;
import java.util.Arrays;
import exceptions.InvalidSizeException;
import exceptions.MaximumCapacityException;

//ArrayList<E> extends AbstractList<E>implements List<E>
//public class Item<T extends Comparable<T>> implements Comparable<Item> {
public class ArrayList<E extends Comparable<E>> {
	private final static int DEFCAP = 50;
	private int origCap;
	private int numElements;
	private E[] list;
	private Class<E> elementType;

	/*
	 * Method Name : ArrayList Parameters : None Return value(s) : None Partners
	 * : None Description : constructor which initializes the Arraylist object.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList() {
		origCap = DEFCAP;
		list = (E[]) new Object[this.origCap];
		numElements = 0;
	}

	/*
	 * Method Name : ArrayList Parameters : size, an int Return value(s) : None
	 * Partners : None Description : constructor which initializes the arraylist
	 * object and sets the attributes to the values passed.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList(int size) throws InvalidSizeException {
		/*
		 * numElements = 0; try{ if (size < DEFCAP) { origCap = size; list =
		 * (E[]) Array.newInstance(et, origCap); } else { throw new
		 * InvalidSizeException("Index out of Range"); } } catch
		 * (InvalidSizeException e){ throw new
		 * InvalidSizeException(e.getMessage()); }
		 */
		// numElements = 0;
		if (size < DEFCAP && size > 1) {
			origCap = size;
			list = (E[]) new Object[this.origCap];
		} else {
			throw new InvalidSizeException("Index out of Range");
		}
	}

	/*
	 * Method Name : addItem Parameters : ArralyLIst Item Return value(s) : None
	 * Partners : None Description : Method adds item to the ArrayList.
	 */
	public void addItem(E item) throws MaximumCapacityException {
		if (numElements == list.length) {
			if (list.length > DEFCAP) {
				throw new MaximumCapacityException("Arraylist is full. Item cannot be inserted");
			} else {
				enlarge();
			}
		}
		list[numElements] = item;
		numElements++;
	}

	/*
	 * Method Name : removeItem Parameters : ArralyLIst Item Return value(s) :
	 * None Partners : None Description : Method to remove item from the
	 * ArrayList.
	 */
	public E removeItem(int index) throws IndexOutOfBoundsException {
		/*
		 * E returnValue = list[pos]; if (pos == 0) { list =
		 * Arrays.copyOfRange(list, 1, pos); } else if (pos == DEFCAP) { list =
		 * Arrays.copyOfRange(list, 0, pos - 1); } else if (pos > 0 && pos <
		 * DEFCAP) { list = concat(Arrays.copyOfRange(list, 0, pos),
		 * Arrays.copyOfRange(list, pos + 1, origCap)); } else { throw new
		 * IndexOutOfBoundsException("Index out of Range"); } return
		 * returnValue;
		 */
		//int pos = findItemPos(item);

		if (list.length >= DEFCAP) {
			throw new IndexOutOfBoundsException("Index out of Range");
		} else {
			E temp = null;
			list[index] = list[numElements - 1];
			temp = list[index];
			numElements--;
			return temp;
		}

	}

	
	public int findItem(E item) {
        for (int i = 0; i < numElements; i++) {
            if (list[i].getKey() == item.getKey()) {
                return i;
            }
        }
        return -1;
    }
	
	
	/*@SuppressWarnings("unchecked")
	private E[] concat(E[] a, E[] b) {
		int aLen = a.length;
		int bLen = b.length;
		E[] c = (E[]) Array.newInstance(elementType, aLen + bLen);
		System.arraycopy(a, 0, c, 0, aLen);
		System.arraycopy(b, 0, c, aLen, bLen);
		return c;
	}*/

	/*
	 * Method Name : findItem Parameters : ArralyLIst Item Return value(s) :
	 * None Partners : None Description : Method to find an item in the
	 * ArrayList.
	 */
	/*
	 * public int findItem(E item) { for (int i = 0; i < numElements; i++) { if
	 * (list[i].getKey() == item.getKey()) { return i; } } return -1; }
	 */

	/*
	 * Method Name : findItemByKey Parameters : key Return value(s) : ArrayList
	 * Item Partners : None Description : Method to find an item by key in the
	 * ArrayList.
	 */
	/*
	 * public int findItemByKey(int key) { for (int i = 0; i < numElements; i++)
	 * { if (list[i].getKey() == key) { return i; } } return -1; }
	 */

	/*
	 * Method Name : isEmpty Parameters : None Return value(s) : boolean
	 * Partners : None Description : Method to check if the arraylist is empty.
	 */
	public boolean isEmpty() {
		if (numElements == 0)
			return true;
		else
			return false;
	}

	/*
	 * Method Name : lengthIs Parameters : None Return value(s) : numelements,
	 * an int Partners : None Description : Method to return number of elements.
	 */
	public int lengthIs() {
		return numElements;
	}

	/*
	 * Method Name : clear Parameters : None Return value(s) : None Partners :
	 * None Description : Method to clear elements in the arraylist.
	 */
	public void clear() {
		numElements = 0;
		if (list.length > origCap) {
			@SuppressWarnings("unchecked")
			E[] orig = (E[]) Array.newInstance(elementType, origCap);

			for (int x = 0; x < orig.length; x++) {
				orig[x] = list[x];
			}

			orig = list;
		}
	}

	/*
	 * Method Name : toString Parameters : None Return value(s) : Formatted
	 * String, a string Partners : None Description : Method to format the input
	 * values into required format
	 */
	public String toString() {

		String tempStr = "";
		if (isEmpty()) {
			tempStr = "\t*** No Items ***";
		} else {
			for (int i = 0; i < numElements; i++) {
				tempStr += list[i] + "\n";
			}
		}
		return tempStr;
	}

	public E getItem(int index) throws IndexOutOfBoundsException {
		if (index > DEFCAP || index < 0) {
			throw new IndexOutOfBoundsException("Index is out of range");
		} else {
			return list[index];
		}
	}

	public void setItem(int index, E item) throws IndexOutOfBoundsException {
		if (index > DEFCAP || index < 0) {
			throw new IndexOutOfBoundsException("Index is out of range");
		} else {
			list[index] = item;
		}
	}

	/*
	 * Method Name : equals Parameters : Arraylist, a object Return value(s) :
	 * boolean Partners : None Description : Method to compare passed my
	 * arraylist object with current object and gives true or false
	 */
	public boolean equals(ArrayList<E> otherList) {
		boolean areEqual = true;
		if (otherList == null)
			areEqual = false;
		else if (otherList == this)
			areEqual = true;
		else if (list.length != otherList.list.length)
			areEqual = false;
		else {
			// compare all items in the lists for equality
			int x = 0;
			while (x < list.length && areEqual) {
				if (!list[x].equals(otherList.list[x]))
					areEqual = false;
				x++;
			}
		}
		return areEqual;
	}

	/*
	 * Method Name : enlarge Parameters : None Return value(s) : None Partners :
	 * None Description : Method to enlarge the ArrayList by the value of
	 * origCap
	 */
	private void enlarge() throws MaximumCapacityException {

		int i = 0;

		i = origCap + list.length;

		if (i >= DEFCAP) {
			throw new MaximumCapacityException("The item cannot be added");
			// System.out.println("The item cannot be added");
		} else {
			@SuppressWarnings("unchecked")
			E[] larger = (E[]) Array.newInstance(elementType, origCap + list.length);
			for (int x = 0; x < list.length; x++) {
				list[x] = larger[x];
			}

			list = larger;
		}
	}

	public void sort() {
	}

}

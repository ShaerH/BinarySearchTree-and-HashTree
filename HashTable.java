public class HashTable {
	static private class ListNode {
		/*
		 * This creates nodes which will be used for the linked list of arrays
		 */
		Object key;
		Object value;
		ListNode next;
	}

	private ListNode[] table;// this makes the linked list into arrays.

	

	public HashTable() {
		// this makes the array a size of 50 if there is know set size from the
		// main.
		table = new ListNode[50];
	}

	public HashTable(int Size) {
		// if the user wishes to make a specific size, this will input that size
		// as the new array
		table = new ListNode[Size];
	}

	void dump() {
		/*
		 * All this does is simply display the elements in the linked list of
		 * arrays
		 */
		System.out.println();
		for (int i = 0; i < table.length; i++) {

			System.out.print(i + ":");
			ListNode list = table[i];
			while (list != null) {
				System.out.print(" " + list.key + "," + list.value);
				list = list.next;
			}
			System.out.println();
		}
	}

	private int hash(Object key) {
		/*
		 * The makes the key value which is the last 4 digits of the
		 * student/faculty id number. It returns a number between 0 and 1000 to
		 * be placed within that range.
		 */
		return (Integer) key % 1000;
	}

	public void add(Object key, Object value) {
		/*
		 * This method adds each student and faculty member into the hash linked list of arrays use there id number.
		 * every key value which is between 0 and 1000 is plays in the same play in the linked list.
		 * If the keys are identical then there will be multiple items in the array.
		 * Else place the value in the array
		 */
		int bucket = hash(key);
		ListNode list = table[bucket];
		while (list != null) {
			if (list.key.equals(key))
				break;
			list = list.next;
		}
		if (list != null) {

			list.value = value;
		}
		ListNode newNode = new ListNode();
		newNode.key = key;
		newNode.value = value;
		newNode.next = table[bucket];
		table[bucket] = newNode;
		
	}

	public void delete(Object key) {
		/*
		 * This method deletes specific values within the linked list using the key value inputed my the user.
		 * Once the key is found it then links to the next value removing the link to the element that is trying to be deleted.
		 */
		int bucket = hash(key);
		if (table[bucket] == null) {

			return;
		}
		if (table[bucket].key.equals(key)) {

			table[bucket] = table[bucket].next;
			
			return;
		}

		ListNode prev = table[bucket];
		ListNode curr = prev.next;
		while (curr != null && !curr.key.equals(key)) {
			curr = curr.next;
			prev = curr;
		}

		if (curr != null) {
			prev.next = curr.next;
			
		}
	}

}

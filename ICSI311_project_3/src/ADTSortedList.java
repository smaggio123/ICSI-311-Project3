/**
 * Interface of the sorted list
 * @author Steven Maggio
 *
 * @param <E>
 */
public interface ADTSortedList<E> {

	/**
	 * Returns the head node
	 * @return this.head The head node
	 */
	Node<E> getHead();

	/**
	 * Sets the head node
	 * @param n The head node
	 */
	void setHead(Node<E> n);

	/**
	 * Inserts node into the list
	 * @param n The node being added to the list
	 */
	void insertNode(Node<E> n);

	/**
	 * Deletes a node from the tree if its value matches str
	 * @param str
	 */
	void deleteElement(String str);

	/**
	 * Deletes an object from the list
	 * @param obj The object being deleted
	 */
	void deleteElement(Object obj);

	/**
	 * Delete the node at the specified position in the list
	 * @param index The index of the node being removed
	 */
	void deleteElement(int index);

	/**
	 * Empties the list
	 */
	void clearList();

	/**
	 * Returns the reference to the node at the specified position
	 * @param index The index of the node to return
	 * @return temp node if the node exists, null otherwise
	 */
	Node<E> get(int index);

	/**
	 * Determines if the list is empty or not
	 * @return true if empty, false otherwise
	 */
	boolean isEmpty();

	/**
	 * Returns the size of the list
	 * @return count The size of the list
	 */
	int size();
	
	/**
	 * Overrides the toString method
	 * Appends all of the values of the list's nodes to a string
	 * @return str The string containing the list
	 */
	public String toString();

	/**
	 * Finds the index of the node in the list
	 * @param value The value being searched for
	 * @return The index of the node, -1 if the node is not found
	 */
	int find(E value);
	
	
	
	
	
}

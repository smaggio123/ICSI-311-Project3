/**
 * This is the node class for a doubly linked list
 * @author Steven Maggio
 *
 * @param <E>
 */
public class Node<E> {
	
	private Node<E> nextNode;	//Points to next node
	private Node<E> prevNode;	//Points to previous node
	private E value;			//The value of the node
	
	/**
	 * Initializes the node with no parameters
	 */
	public Node() {
		this.prevNode=null;
		this.nextNode=null;
		this.value=null;
	}
	/**
	 * Initializes the node with 1 parameter
	 * @param v The value of the node
	 */
	public Node(E v) {
		this.prevNode=null;
		this.nextNode=null;
		this.value=v;
	}
	/**
	 * Initializes the node with 3 parameters
	 * @param pn Pointer to the previous node
	 * @param nn Pointer to the next node
	 * @param v	 The value of the node
	 */
	public Node(Node<E> pn,Node<E> nn,E v) {
		this.prevNode=pn;
		this.nextNode=nn;
		this.value=v;
	}
	
	/**
	 * Returns the next node.
	 * @return this.nextNode The next node
	 */
	public Node<E> getNext() {
		return this.nextNode;
	}
	
	/**
	 * Returns the previous node.
	 * @return this.prevNode The previous node
	 */
	public Node<E> getPrev() {
		return this.prevNode;
	}
	
	/**
	 * Returns the value of the node.
	 * @return this.value The value of the node
	 */
	public E getValue() {
		return this.value;
	}
	
	/**
	 * Sets the next node
	 * @param nn The next node
	 */
	public void setNext(Node<E> nn) {
		nextNode = nn;
	}
	
	/**
	 * Sets the previous node.
	 * @param pn The previous node
	 */
	public void setPrev(Node<E> pn) {
		prevNode = pn;
	}
	
	/**
	 * Sets the value of the node.
	 * @param v The value of the node
	 */
	public void setValue(E v) {
		this.value = v;
	}
	
	/**
	 * Compares the values of this node and other node
	 * @param other The other node being compared
	 * @return -1 if less than, 0 if equal, 1 if greater than
	 */
	public int compareValue(Node<E> other) {
		//Getting the class of the node.
		String nodeType =value.getClass().getSimpleName();
		//If the node is Integer type.
		if(nodeType.equalsIgnoreCase("Integer")) {
			Integer otherValue=(Integer)other.getValue();
			Integer thisValue= (Integer)this.getValue();
			//Returns the difference in values
			return thisValue-otherValue;
		}
		//If the node type is String
		else if(nodeType.equalsIgnoreCase("String")){
			String otherValue=""+other.getValue();
			String thisValue=""+this.getValue();
			//Compares the strings
			return thisValue.compareTo(otherValue);
			
		}
		//If the node type is Contact
		else if(nodeType.equalsIgnoreCase("Contact")){
			String otherValue=""+other.getValue();
			String thisValue=""+this.getValue();
			//Splitting the string up into first name, last name, and phone number
			String [] thisArray = thisValue.split(" ");
			String [] otherArray = otherValue.split(" ");
			//Getting the last names
			String thisLastName=thisArray[1];
			String otherLastName=otherArray[1];
			//Compares the last names
			return thisLastName.compareTo(otherLastName);
		}
		else {
			String otherValue=""+other.getValue();
			String thisValue=""+this.getValue();
			//Compares the values
			return thisValue.compareTo(otherValue);
		}
	}
}

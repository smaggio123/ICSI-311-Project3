/**
 * The SortedList class
 * Only deals with the last names found in testcases.txt
 * @author Steven Maggio
 *
 * @param <E>
 */
public class SortedList<E extends Comparable<E>> implements ADTSortedList<E>{
	
	private Node<E> head;	//The first node of the list
	private int count;		//The size of the list
	
	
	/**
	 * Initializes the sorted list with no parameters
	 */
	public SortedList() {
		this.head=null;
		count=0;
	}
	
	/**
	 * Initializes the sorted list with a parameter
	 * @param n The head node
	 */
	public SortedList(Node<E> n) {
		this.head=n;
	}
	
	/**
	 * Returns the head node
	 * @return this.head The head node
	 */
	@Override
	public Node<E> getHead(){
		return this.head;
	}
	
	/**
	 * Sets the head node
	 * @param n The head node
	 */
	@Override
	public void setHead(Node<E>n){
		this.head=n;
	}
	
	/**
	 * Inserts node into the list
	 * @param n The node being added to the list
	 */
	@Override
	public void insertNode(Node<E> n) {
		//If the list is empty
		if(count==0) {
			//Sets the node to head
			head=n;
			count++;
		}
		else {
			count++;
			Node<E> tempNode = head;	//Keeps track of current node
			Node<E> nextNode = head;	//Keeps track of next node
			
			//finding where to put node
			int index=0;	//Holds the resulting index that should be where to put the node
			boolean nextIsNull=false;
			//While there is a next node and the nodes are still alphabetically correct
			while(nextIsNull!=true&&nextNode.compareValue(n)<0) {
				index++;
				//Setting the next node
				tempNode=nextNode;
				
				//If there is a next node, set tempNode to next node, set to null otherwise
				if(nextNode.getNext()!=null) {
					nextNode=nextNode.getNext();
				}
				else {
					nextIsNull=true;
				}
			}
			
			//If node needs to be inserted at the head of the list
			if(index==0) {
				n.setNext(tempNode);
				tempNode.setPrev(n);
				head = n;
			}
			//If node needs to be inserted somewhere in the middle of the list
			else if(tempNode.getNext()!=null) {
				n.setNext(nextNode);
				n.setPrev(tempNode);
				tempNode.setNext(n);
				nextNode.setPrev(n);
			}
			//If node needs to be inserted at the end of the list
			else {
				n.setNext(null);
				tempNode.setNext(n);
				n.setPrev(tempNode);
			}
			
		}
		
	}
	
	/**
	 * Deletes a node from the tree if its value matches str
	 * @param str
	 */
	@Override
	public void deleteElement(String str) {
		//The node that is being deleted
		Node<E> tempNode = new Node<E>(head.getPrev(),head.getNext(),head.getValue());
		boolean foundValue=false;
		//Looking for the node in the list
		for(int i=0;i<this.count;i++) {
			//Gets value of the node
			String tempNodeValue=""+tempNode.getValue();
			
			//If the nodes are equal
			if(tempNodeValue.equalsIgnoreCase(str)) {
				foundValue=true;
				//exit the loop
				break;
			}
			
			tempNode=tempNode.getNext();
		}
		
		if(foundValue) {
			//Inserting the node into the list
			Node<E> beforeNode=tempNode.getPrev();
			Node<E> afterNode=tempNode.getNext();
			beforeNode.setNext(afterNode);
			afterNode.setPrev(beforeNode);
			tempNode=null;
			//Decrementing the size of the list
			count--;
		}
		else{
			System.out.println("Entry not found");
		}
	}
	
	/**
	 * Deletes an object from the list
	 * @param obj The object being deleted
	 */
	@Override
	public void deleteElement(Object obj) {
		Node<E> tempNode = head;
		boolean foundValue=false;
		//Looking for the object in the list
		for(int i=0;i<this.count;i++) {
			String thisValue =""+tempNode.getValue();
			String otherValue = ""+obj;
			//If the object is found
			if(thisValue.compareTo(otherValue)==0) {
				//Node is found so exit loop
				foundValue=true;
				break;
			}
			
			//If node was not found, go to next node
			tempNode=tempNode.getNext();
			
		}
		
		
		//If the node was found
		if(foundValue) {
			//Delete the node from the list
			Node<E> beforeNode=tempNode.getPrev();
			Node<E> afterNode=tempNode.getNext();
			beforeNode.setNext(afterNode);
			afterNode.setPrev(beforeNode);
			tempNode=null;
			count--;
		}
		else{
			System.out.println("Entry not found");
		}
	}
	
	/**
	 * Delete the node at the specified position in the list
	 * @param index The index of the node being removed
	 */
	@Override
	public void deleteElement(int index) {
		//Holds current node
		Node<E> tempNode = new Node<E>(head.getPrev(),head.getNext(),head.getValue());
		boolean found=false;
		//Searching list for index
		for(int i=0;i<=index;i++) {
			//Once the position is found
			if(i==index) {
				found=true;
				//Exit loop
				break;
			}
			else if(tempNode.getNext()!=null) {
				//Gets next node for check next iteration
				tempNode=tempNode.getNext();
			}
			else {
				//If the node is not found
				System.out.println("Entry not found");
				break;
			}
		}
		if(found) {
			//Delete the node from the list
			Node<E> beforeNode=tempNode.getPrev();
			Node<E> afterNode=tempNode.getNext();
			beforeNode.setNext(afterNode);
			afterNode.setPrev(beforeNode);
			tempNode=null;
			//Decrements the size of the list
			count--;
		}
	}
	
	/**
	 * Empties the list
	 */
	@Override
	public void clearList() {
		//If head is null, then there is no more list
		head=null;
		//Since there are no elements, the size of the list is set to zero
		count=0;
	}
	
	/**
	 * Returns the reference to the node at the specified position
	 * @param index The index of the node to return
	 * @return temp node if the node exists, null otherwise
	 */
	@Override
	public Node<E> get(int index) {
		//The current node
		Node<E> tempNode = head;
		//Finding the node
		for(int i=0;i<=index;i++) {
			//If this is the proper index
			if(i==index) {
				//Returns the node we are looking for
				return tempNode;
			}
			//Gets the next node if it exists
			if(tempNode.getNext()!=null) {
				tempNode=tempNode.getNext();
			}
			//If the node isn't found
			else {
				System.out.println("Entry not found");
				break;
			}
		}
		//The node was not found, therefore, returns null
		return null;
	}
	
	/**
	 * Determines if the list is empty or not
	 * @return true if empty, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return count==0;
	}
	/**
	 * Returns the size of the list
	 * @return count The size of the list
	 */
	@Override
	public int size() {
		return count;
	}
	
	/**
	 * Overrides the toString method
	 * Appends all of the values of the list's nodes to a string
	 * @return str The string containing the list
	 */
	@Override
	public String toString() {
		//Current node
		Node<E> tempNode = new Node<E>(head.getPrev(),head.getNext(),head.getValue());
		//String to append values to
		String str="";
		//Keeps track of index for a nicer looking output
		int index=0;
		while(tempNode.getNext()!=null) {
			str+=index+". "+tempNode.getValue()+"\n";
			tempNode=tempNode.getNext();
			index++;
		}
		//Appending the last element in the list
		str+=index+". "+tempNode.getValue();
		
		return str;
	}
	
	/**
	 * The equals method
	 * @param otherList The other list
	 * @return true if the lists are equivalent, false otherwise
	 */
	public boolean equals(SortedList<E> otherList) {
		Node<E> thisThisList=new Node<E>(this.getHead().getPrev(),this.getHead().getNext(),this.getHead().getValue());
		Node<E> thisOtherList=new Node<E>(otherList.getHead().getPrev(),otherList.getHead().getNext(),otherList.getHead().getValue());
		//Testing that the list sizes match
		if(this.size()==otherList.size()) {
			for(int i=0;i<count;i++) {
				//Determines if the values of the node are equivalent
				boolean nodesEqual=thisThisList.compareValue(thisOtherList)==0;
				thisThisList = thisThisList.getNext();
				thisOtherList = thisOtherList.getNext();
				//If the nodes being compared are not equivalent
				if(!nodesEqual) {
					return false;
				}				
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Finds the index of the node in the list
	 * @param value The value being searched for
	 * @return The index of the node, -1 if the node is not found
	 */
	@Override
	public int find(E value) {
		//Current node
		Node<E> tempNode= head;
		int index=0;
		boolean nextNodeIsNull=false;
		while(nextNodeIsNull!=true) {
			String thisValue =""+tempNode.getValue();
			String otherValue = ""+value;
			//If the value is found
			if(thisValue.compareTo(otherValue)==0) {
				//Returns where the node is
				return index;
			}
			//If the value is not found
			index++;
			//Gets the next node if it exists
			if(tempNode.getNext()!=null) {
				tempNode=tempNode.getNext();
			}
			else {
				//The node was not found
				return -1;
			}
		}
		//The node was not found
		return -1;
	}
}

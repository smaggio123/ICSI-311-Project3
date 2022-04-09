/**
 * This is the address book class.
 * Deals with contact information found in testCases.txt
 * @author Steven Maggio
 *
 */
public class AddressBook implements ADTAddressBook{
	
	private SortedList<Contact<String>> list = new SortedList<Contact<String>>(); //The list for the address book
	
	/**
	 * The constructor of the address book
	 */
	public AddressBook() {
		
	}
	
	/**
	 * Finds the contact in the address book
	 * @param c The contact being searched for
	 * @return The position where the contact was found
	 */
	@Override
	public int findContact(Contact c) {
		return list.find(c);
	}
	
	/**
	 * Inserts contact into the address book
	 * @param c The contact being inserted
	 */
	@Override
	public void insertContact(Contact c) {
		//Makes a node with the contact information
		Node<Contact<String>> n = new Node<Contact<String>>(null,null,c);
		list.insertNode(n);
	}
	
	/**
	 * Deletes a contact from the address book
	 * @param c The contact being deleted
	 */
	@Override
	public void deleteContact(Contact c) {
		list.deleteElement(c);
	}
	
	/**
	 * Clears the address book
	 */
	@Override
	public void clearBook() {
		list.clearList();
	}
	
	/**
	 * Determines if the address book is empty
	 * @return true if the address book is empty, false otherwise
	 */
	@Override
	public boolean bookIsEmpty() {
		return list.isEmpty();
	}
	
	/**
	 * Returns a reference to the contact in the specified position
	 * @param index The position to receive the contact from
	 * @return Reference to the contact, null if the contact doesn't exist
	 */
	@Override
	public Node<Contact<String>> getContact(int index) {
		return list.get(index);
	}
	
	/**
	 * Returns the size of the address book
	 * @return size of the address book
	 */
	@Override
	public int bookSize() {
		return list.size();
	}
	
	/**
	 * Finds the contacts with the same area code, inserts the contacts into a sorted list, and returns the sorted list
	 * @param areaCode The area code to look for
	 * @return tempList The sorted list containing the contacts with the same area code
	 */
	@Override
	public SortedList<Contact<String>> getSameAreaCode(String areaCode){
		//The sorted list that will contain the resulting contact
		SortedList<Contact<String>> tempList = new SortedList<Contact<String>>();
		for(int i=0;i<list.size();i++) {
			Contact thisContact = list.get(i).getValue();
			//Getting the area code of the contact
			String thisAreaCode = thisContact.getPhoneNumber().substring(0,3);
			//If the area code is the one being searched for
			if(thisAreaCode.equals(areaCode)) {
				//Make a node with the contact info
				Node<Contact<String>> tempNode = new Node<Contact<String>>(thisContact);
				//Add the contact to the list
				tempList.insertNode(tempNode);	
			}
		}
		return tempList;
	}
	
	/**
	 * Finds the contacts with the same last name, inserts the contacts into a sorted list, and returns the sorted list
	 * @param lastName The last name to look for
	 * @return tempList The sorted list containing the contacts with the same last name
	 */
	@Override
	public SortedList<Contact<String>> getSameLastName(String lastName){
		//The sorted list that will contain the resulting contact
		SortedList<Contact<String>> tempList = new SortedList<Contact<String>>();
		for(int i=0;i<list.size();i++) {
			Contact thisContact = list.get(i).getValue();
			//Getting the last name of the contact
			String thisLastName = thisContact.getLastName();
			//If the last name is the one being searched for
			if(thisLastName.equalsIgnoreCase(lastName)) {
				//Make a node with the contact info
				Node<Contact<String>> tempNode = new Node<Contact<String>>(thisContact);
				//Add the contact to the list
				tempList.insertNode(tempNode);
			}
		}
		return tempList;
	}
	
	
	/**
	 * Overrides the toString method
	 * @return A string containing all of the contact info from the address book
	 */
	@Override
	public String toString() {
		return list.toString();
	}
	
	/**
	 * Returns the sorted list of the address book
	 * @return list The sorted list of the address book
	 */
	@Override
	public SortedList<Contact<String>> getList(){
		return list;
	}
	
	/**
	 * The equals method
	 * Compares to address books to see if they are equal
	 * @param other The other address book
	 * @return true if they are equal, false otherwise
	 */
	@Override
	public boolean equals(AddressBook other) {
		return this.list.equals(other.getList());
	}
}

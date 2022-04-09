/**
 * Interface of the address book
 * @author Steven Maggio
 *
 */
public interface ADTAddressBook {

	/**
	 * Finds the contact in the address book
	 * @param c The contact being searched for
	 * @return The position where the contact was found
	 */
	int findContact(Contact c);

	/**
	 * Inserts contact into the address book
	 * @param c The contact being inserted
	 */
	void insertContact(Contact c);

	/**
	 * Deletes a contact from the address book
	 * @param c The contact being deleted
	 */
	void deleteContact(Contact c);

	/**
	 * Clears the address book
	 */
	void clearBook();

	/**
	 * Determines if the address book is empty
	 * @return true if the address book is empty, false otherwise
	 */
	boolean bookIsEmpty();

	/**
	 * Returns a reference to the contact in the specified position
	 * @param index The position to receive the contact from
	 * @return Reference to the contact, null if the contact doesn't exist
	 */
	Node<Contact<String>> getContact(int index);

	/**
	 * Returns the size of the address book
	 * @return size of the address book
	 */
	int bookSize();

	/**
	 * Finds the contacts with the same area code, inserts the contacts into a sorted list, and returns the sorted list
	 * @param areaCode The area code to look for
	 * @return tempList The sorted list containing the contacts with the same area code
	 */
	SortedList<Contact<String>> getSameAreaCode(String areaCode);

	/**
	 * Finds the contacts with the same last name, inserts the contacts into a sorted list, and returns the sorted list
	 * @param lastName The last name to look for
	 * @return tempList The sorted list containing the contacts with the same last name
	 */
	SortedList<Contact<String>> getSameLastName(String lastName);
	
	/**
	 * Overrides the toString method
	 * @return A string containing all of the contact info from the address book
	 */
	public String toString();

	/**
	 * Returns the sorted list of the address book
	 * @return list The sorted list of the address book
	 */
	SortedList<Contact<String>> getList();

	/**
	 * The equals method
	 * Compares to address books to see if they are equal
	 * @param other The other address book
	 * @return true if they are equal, false otherwise
	 */
	boolean equals(AddressBook other);
	
}

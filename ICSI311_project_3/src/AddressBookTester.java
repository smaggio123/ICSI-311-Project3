import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The address book tester class
 * @author Steven Maggio
 *
 */
public class AddressBookTester {
	
	AddressBook book = new AddressBook();	//The address book being tested
	AddressBook originalBook = new AddressBook(); //The book that won't change after inserting is done
	
	/**
	 * Calls the methods that test specific methods in the sorted list class
	 * @throws FileNotFoundException
	 */
	public void start() throws FileNotFoundException {
		//Tests the insert method
		initializeList();
		
		System.out.println("Printing book:");
		//Tests the toString method
		System.out.println(book);
		
		System.out.println();
		
		//The area code to search for
		String areaCode = "212";
		//Tests the get same area code method
		this.testGetSameAreaCode(areaCode);
		
		System.out.println();
		
		//The last name to look for
		String getSameLastNameStr = "Dilliard";
		//Tests the get same last name method
		this.testGetSameLastName(getSameLastNameStr);
		
		System.out.println();
		
		//Testing equals method
		testIsEqual();
		
		System.out.println();
		
		//Making the contact
		String firstName="Allene";
		String lastName="Iturbide";
		String phoneNumber="715-662-6764";
		//The contact to search for
		Contact searchContact=new Contact(firstName,lastName,phoneNumber);
		
		//Tests the find method
		testFind(searchContact);
		
		System.out.println();
		
		//Tests the size method
		testSize();
		
		System.out.println();
		
		//Tests the delete method
		testDeleteContact(searchContact);
		
		System.out.println();
		
		//Testing equals method again to show changes to the list
		testIsEqual();
		
		System.out.println();
		
		//Tests the size method to show the changes to the list
		testSize();
		
		System.out.println();
		
		//Tests the find method again to show changes made to the list
		testFind(searchContact);
		
		System.out.println();
		
		//The index to search for
		int index=7;
		//Tests the get method
		testGet(index);
		
		//Tests the clear method
		testClear();
		
	}
	
	/**
	 * Initializes the list by inserting values read from the text file
	 * @throws FileNotFoundException
	 */
	public void initializeList() throws FileNotFoundException {
		//Making the scanner that will read the file
		String path = "C:\\Users\\smagg\\ICSI311_java_workspace\\ICSI311_project_3\\testCases.txt";
		File file = new File(path);
		Scanner fileReader = new Scanner(file);
		
		//Reading the file
		while(fileReader.hasNextLine()) {
			
			String fileLine = fileReader.nextLine();
			/*
			 * The read string is in the format: firstName lastName phoneNumber
			 * splitting the string gets each aspect of the contact
			 */
			String [] inputArray = fileLine.split(" ");
			String firstName = inputArray[0];
			String lastName = inputArray[1];
			String phoneNumber = inputArray[2];
			//initializing the contacts
			Contact temp = new Contact(firstName,lastName,phoneNumber);
			Contact temp2 = new Contact(firstName,lastName,phoneNumber);
			//Inserts the contacts into the address book
			book.insertContact(temp);
			originalBook.insertContact(temp2);
			
		}
		fileReader.close();
		
	}
	
	/**
	 * Tests the find method
	 * @param c The contact being searched for
	 */
	public void testFind(Contact c) {
		System.out.println("Testing find");
		System.out.println(c+" found at: "+book.findContact(c));
		
	}
	
	/**
	 * Tests the delete method
	 * @param c The contact being deleted
	 */
	public void testDeleteContact(Contact c) {
		System.out.println("Testing delete");
		book.deleteContact(c);
		System.out.println("Deleted: "+c);
	}
	
	/**
	 * Tests the get method
	 * @param index The index of the contact
	 */
	public void testGet(int index) {
		System.out.println("Testing get");
		System.out.println("Contact at position: "+index+" is: "+book.getContact(index) +" whose value is: " + book.getContact(index).getValue());
	}
	
	/**
	 * Tests the size method
	 */
	public void testSize() {
		System.out.println("Book size is: "+book.bookSize());
	}
	
	/**
	 * Tests the isEmpty method
	 */
	public void testEmpty() {
		System.out.println("Testing empty");
		/*
		 * I really wanted to practice using ternary operators here
		 * This line of code means that the value of output is "empty" or "not empty" depending on the isEmpty() function
		 */
		String output = book.bookIsEmpty() ? (output="Book is empty") : (output="Book is not empty");
		System.out.println(output);
	}
	
	/**
	 * Tests the clear method
	 */
	public void testClear() {
		System.out.println("Testing clear");
		System.out.println();
		
		//Determines if the address book is empty
		testEmpty();
		
		System.out.println();
		
		//Clears the book
		book.clearBook();
		System.out.println("Cleared book");
		
		System.out.println();
		
		//Determines if the address book is empty again to show changes to the address book
		testEmpty();
	}
	
	/**
	 * Tests the getSameAreaCode method
	 * @param ac The area code to look for
	 */
	public void testGetSameAreaCode(String ac) {
		System.out.println("Testing get same area code");
		//Get the list containing the contacts with the same area code
		SortedList<Contact<String>> l = new SortedList<Contact<String>>(book.getSameAreaCode(ac).getHead());
		System.out.println("The list of contacts with the area code: "+ac);
		System.out.println(l);
	}
	
	/**
	 * Tests the getSameLastName method
	 * @param ln The last name to look for
	 */
	public void testGetSameLastName(String ln) {
		System.out.println("Testing get same last name");
		//Get the list containing the contacts with the same last name
		SortedList<Contact<String>> l = new SortedList<Contact<String>>(book.getSameLastName(ln).getHead());
		System.out.println("The list of contacts with the same last name: "+ln);
		System.out.println(l);
	}
	
	/**
	 * Tests the equals method
	 */
	public void testIsEqual() {
		System.out.println("Testing equal()");
		//Testing equals method
		System.out.println("current book is the same as the original = "+book.equals(originalBook));
	}
}

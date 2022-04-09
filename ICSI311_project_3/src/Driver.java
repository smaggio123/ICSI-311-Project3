import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This is the driver class.
 * @author Steven Maggio
 *
 */
public class Driver {

	/**
	 * Main method. Starts program.
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		//Starts the program
		start();
	}
	
	/**
	 * Since the test classes produce a large output, the user can choose which class to test during the run.
	 * @throws FileNotFoundException
	 */
	public static void start() throws FileNotFoundException{
		Scanner input = new Scanner(System.in);
		
		//Asking which class to test
		System.out.println("Which class do you wish to test (Enter a corresponding number)?");
		
		//The classes to test
		System.out.println("[0] SortedList (using last names)");
		System.out.println("[1] SortedList (using numbers)");
		System.out.println("[2] Contact");
		System.out.println("[3] AddressBook");
		int selection = input.nextInt();
		
		//Calls class specified by user
		switch(selection) {
		//Testing the SortedList class
		case 0:
			System.out.println("Going to test SortedList (String) class");
			System.out.println();
			testSortedList();
			break;
		//Testing the SortedList class with integer values
		case 1:
			System.out.println("Going to test SortedList (Integer) class");
			System.out.println();
			testSortedListWithIntegers();
			break;
		//Testing the Contact class
		case 2:
			System.out.println("Going to test Contact class");
			System.out.println();
			testContact();
			break;
		//Testing the AddressBook class
		case 3:
			System.out.println("Going to test AddressBook class");
			System.out.println();
			testAddressBook();
			break;
		//If the input was not one of the options
		default:
			System.out.println("Please select one of the valid options");
		}
		input.close();
	}
	
	
	/**
	 * Tests the SortedList class with string test cases
	 * Initializes a testing class and calls the tester's start() method to test the methods.
	 * @throws FileNotFoundException
	 */
	public static void testSortedList() throws FileNotFoundException {
		//Create an instance of the ADT sorted list and save its reference.
		SortedList<String> list = new SortedList<String>();
		
		SortedListTester tester = new SortedListTester(list);
		//Runs tests
		tester.start();
	}
	
	/**
	 * Tests SortedList class with integer test cases
	 * Initializes a testing class and calls the tester's start() method to test the methods.
	 * @throws FileNotFoundException
	 */
	public static void testSortedListWithIntegers() throws FileNotFoundException {
		//Create an instance of the ADT sorted list and save its reference.
		SortedList<Integer> list = new SortedList<Integer>();
		
		SortedListIntegerTester tester = new SortedListIntegerTester(list);
		//Runs tests
		tester.start();
		
	}
	
	/**
	 * Tests the Contact class.
	 * Makes a contact object from the input file as the test subject.
	 * Another contact object (Tom Hanks) is made to compare the two objects (to test the equals method).
	 * @throws FileNotFoundException
	 */
	public static void testContact() throws FileNotFoundException {
		System.out.println();
		System.out.println("Testing Contact class");
		String path = "C:\\Users\\smagg\\ICSI311_java_workspace\\ICSI311_project_3\\testCases.txt";
		
		File file = new File(path);
		
		Scanner fileReader = new Scanner(file);
		
		//Getting the first line from the file
		String fileLine = fileReader.nextLine();
		
		fileReader.close();
		
		//The file's input layout is: firstName lastName phoneNumber, so splitting the string will get each piece of info.
		String [] inputArray = fileLine.split(" ");
		
		//Making the first Contact object
		String firstName = inputArray[0];
		
		String lastName = inputArray[1];
		
		String phoneNumber = inputArray[2];
		
		Contact contact = new Contact(firstName,lastName,phoneNumber);
		
		ContactTester tester= new ContactTester(contact);
		
		//Making the second Contact object
		String newFirstName = "Tom";
		String newLastName = "Hanks";
		String newPhoneNumber = "123-456-7890";
		Contact contact2 = new Contact(newFirstName, newLastName, newPhoneNumber);

		//Comparing the two contact objects BEFORE the tester is run
		System.out.println();
		System.out.println("Comparing\n"+contact+"\nto\n"+contact2);
		System.out.println("Are they equal="+contact.equals(contact2));
		System.out.println();
		//Printing the results of the comparison
		System.out.println("Testing the contact (toString): "+contact);
		
		//Testing the Contact class
		tester.start(newFirstName, newLastName, newPhoneNumber);
		
		//Comparing the two contact objects AFTER the tester is run
		System.out.println();
		System.out.println("Comparing\n"+contact+"\nto\n"+contact2);
		System.out.println("Are they equal="+contact.equals(contact2));
	
	}

	/**
	 * Tests the AddressBook class.
	 * @throws FileNotFoundException
	 */
	public static void testAddressBook() throws FileNotFoundException {
		AddressBookTester tester = new AddressBookTester();
		//Runs tests
		tester.start();
	}
}

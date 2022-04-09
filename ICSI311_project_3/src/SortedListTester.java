import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The SortedList Tester class
 * Uses a file of Strings as input
 * @author Steven Maggio
 *
 */
public class SortedListTester {
	
	SortedList<String> list;	//The list being tested
	SortedList<String> otherList;	//The list being compared to list list
	
	/**
	 * Initializes the tester
	 * @param l	The list to be tested
	 */
	public SortedListTester(SortedList<String> l) {
		list = l;
		otherList = new SortedList<String>();
	}
	
	/**
	 * calls the methods that test specific methods in the sorted list class
	 * @throws FileNotFoundException
	 */
	public void start() throws FileNotFoundException {
		
		//Tests the isEmpty method
		testEmpty();
		
		System.out.println();

		//Tests the insert method
		testInsert();
		
		System.out.println();
		
		//Testing the equals method
		testIsEqual();
		
		System.out.println();

		//prints list to show changes made to the list
		printList();
		
		System.out.println();
		
		//Tests the size method
		testSize();
		
		System.out.println();
		
		//Tests the isEmpty method to show changes made to the list
		testEmpty();
		
		System.out.println();
		
		//Name to delete
		String deleteName = "Rim";
		//This method will delete deleteName from the list.
		deleteFromList(deleteName);
		
		
		System.out.println();
		
		//Index of node to delete
		int positionDelete = 25;
		//Deletes the node at the position found in the list
		deleteFromListAtPosition(positionDelete);
		
		System.out.println();
		
		
		//Testing the equals method again to show change in the list
		testIsEqual();
		
		
		System.out.println();
		
		//Index to retrieve the node
		int getIndex=5;
		//Getting the node at the specified index
		testGet(getIndex);
		
		System.out.println();
		
		//Name to look up
		String searchName="Venere";
		//Finding the position of searchName in the list
		findInList(searchName);
		
		System.out.println();
		
		//Tests the clear method
		testClear();
	}
	
	/**
	 * Initializes the list by inserting values read from the text file
	 * @throws FileNotFoundException
	 */
	public void testInsert() throws FileNotFoundException{
		System.out.println("Making list");
		
		//Making the scanner that will read the file
		String path = "C:\\Users\\smagg\\ICSI311_java_workspace\\ICSI311_project_3\\testCases.txt";
		File file = new File(path);
		Scanner fileReader = new Scanner(file);
		
		//Reading the file
		while(fileReader.hasNextLine()) {
			String fileLine = fileReader.nextLine();
			//The read string is in the format: firstName lastName phoneNumber
			//splitting the string gets each aspect of the contact
			String [] inputArray = fileLine.split(" ");
			//Gets the last name from the string
			String lastName = inputArray[1];
			//Makes a node with the last name
			Node<String> node = new Node<String>(lastName);
			//Makes the same node, but is added to a different list
			Node<String> node2 = new Node<String>(lastName);
			//Inserts the node into the list
			list.insertNode(node);
			//Inserts other node into other list
			otherList.insertNode(node2);
		}
		System.out.println();
		fileReader.close();
	}
	
	/**
	 * Tests the toString method
	 */
	public void printList(){
		System.out.println("Tesing print list");
		System.out.println(list);
	}
	
	/**
	 * Tests deleting elements from the list
	 * @param name The name to delete from the list
	 */
	public void deleteFromList(String name) {
		System.out.println("Tesing delete (name)");
		
		//If the name is in the list
		if(list.find(name)!=-1) {
			//Outputting where the name was found before deleting the name from the list
			System.out.println(name + " originally found at position: " + list.find(name));
			
			//Deleting the name from the list
			list.deleteElement(name);
			
			System.out.println("Deleted "+name + " from list");
			
			//Printing the list to show the result of deleting the name from the list
			System.out.println("Resulting list is:");
			printList();
		}
		else {
			//If the name wasn't in the list
			System.out.println("ERROR: Could not find the name in the list");
		}
	}
	
	/**
	 * Tests the delete at position method
	 * @param index The index of the name to be deleted
	 */
	public void deleteFromListAtPosition(int index) {
		System.out.println("Tesing delete (index)");
		
		//Says the name found at the index
		System.out.println(list.get(index).getValue() + " was found at position: " + index);			
		
		//Deletes at the index
		list.deleteElement(index);
		System.out.println("Deleted element at position: "+index);
		
		//Printing out the result of the deletion
		System.out.println("Resulting list is:");
		printList();
	}
	
	/**
	 * Tests the get method
	 * @param index The index of the name to get
	 * @throws FileNotFoundException
	 */
	public void testGet(int index) throws FileNotFoundException {
		System.out.println("Testing get method");
		System.out.println("Element at position: "+index + " is: " + list.get(index).getValue());
	}
	
	/**
	 * Tests the find method
	 * @param name The name to look for
	 * @throws FileNotFoundException
	 */
	public void findInList(String name) throws FileNotFoundException {
		System.out.println("Tesing find");
		System.out.println("'"+name + "' is found at index: " + list.find(name));
	}
	
	/**
	 * Tests the isEmpty method
	 */
	public void testEmpty() {
		System.out.println("Testing isEmpty");
		//I really wanted to practice using ternary operators
		//This means that the out put is "empty" or "not empty" depending on the isEmpty() function
		String output = list.isEmpty() ? (output="List is empty") : (output="List is not empty");
		System.out.println(output);
		
	}
	
	/**
	 * Tests the clear method
	 */
	public void testClear() {
		System.out.println("Test clearing list");
		
		//Tests is empty before clearing the list
		testEmpty();
		
		//Clears the list
		list.clearList();
		System.out.println("List cleared");
		
		//Tests is empty after clearing the list
		testEmpty();
	}
	
	/**
	 * Tests the size method
	 */
	public void testSize() {
		System.out.println("Testing size method");
		System.out.println("Size of list is: " +list.size());
	}
	
	/**
	 * Tests the equals method
	 */
	public void testIsEqual() {
		System.out.println("Testing equal()");
		System.out.println("current list is equal to the original list = "+list.equals(otherList));
	}
}

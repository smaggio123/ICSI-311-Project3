import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The SortedList Tester class
 * Uses a file of integers as input
 * @author Steven Maggio
 *
 */
public class SortedListIntegerTester {
	
	SortedList<Integer> list;	//The list being tested
	SortedList<Integer> otherList;	//The list being compared to list list
	
	/**
	 * Initializes the tester
	 * @param l	The list to be tested
	 */
	public SortedListIntegerTester(SortedList<Integer> l) {
		list = l;
		otherList = new SortedList<Integer>();
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
		Integer deleteNum = 685;
		//This method will delete deleteNum from the list.
		deleteFromList(deleteNum);
		
		
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
		
		//Number to look up
		Integer searchNum=343;
		//Finding the position of searchNum in the list
		findInList(searchNum);
		
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
		String path = "C:\\Users\\smagg\\ICSI311_java_workspace\\ICSI311_project_3\\numberTestCases.txt";
		File file = new File(path);
		Scanner fileReader = new Scanner(file);
		
		//Reading the file
		while(fileReader.hasNextLine()) {
			String fileLine = fileReader.nextLine();
			Integer number = Integer.parseInt(fileLine);
			//Makes a node with the number
			Node<Integer> node = new Node<Integer>(number);
			//Makes the same node, but is added to a different list
			Node<Integer> node2 = new Node<Integer>(number);
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
	 * @param num The number to delete from the list
	 */
	public void deleteFromList(Integer num) {
		System.out.println("Tesing delete (int)");
		
		//If the number is in the list
		if(list.find(num)!=-1) {
			//Outputting where the number was found before deleting the number from the list
			System.out.println(num+ " originally found at position: " + list.find(num));
			
			//Deleting the number from the list
			list.deleteElement(num);
			
			System.out.println("Deleted "+num + " from list");
			
			//Printing the list to show the result of deleting the number from the list
			System.out.println("Resulting list is:");
			printList();
		}
		else {
			//If the number wasn't in the list
			System.out.println("ERROR: Could not find the number in the list");
		}
	}
	
	/**
	 * Tests the delete at position method
	 * @param index The index of the number to be deleted
	 */
	public void deleteFromListAtPosition(int index) {
		System.out.println("Tesing delete (index)");
		
		//Says the number found at the index
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
	 * @param index The index of the number to get
	 * @throws FileNotFoundException
	 */
	public void testGet(int index) throws FileNotFoundException {
		System.out.println("Testing get method");
		System.out.println("Element at position: "+index + " is: " + list.get(index).getValue());
	}
	
	/**
	 * Tests the find method
	 * @param num The number to look for
	 * @throws FileNotFoundException
	 */
	public void findInList(Integer num) throws FileNotFoundException {
		System.out.println("Tesing find");
		System.out.println(num + " is found at index: " + list.find(num));
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
		
		testEmpty();
		
		list.clearList();
		System.out.println("List cleared");
		
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

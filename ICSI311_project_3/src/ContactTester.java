/**
 * The Contact Tester class
 * @author Steven Maggio
 */
public class ContactTester {
	
	Contact contact;	//The contact being tested
	
	/**
	 * Initializes the tester
	 * @param c The contact to be tested
	 */
	public ContactTester(Contact c) {
		contact = c;
	}
	
	/**
	 * Calls the methods that test specific methods in the contact class
	 * @param fn	//First name of contact
	 * @param ln	//Last name of contact
	 * @param pn	//Phone number of contact
	 */
	public void start(String fn,String ln, String pn) {
		//testing getFirstName
		this.testGetFirstName();
		
		System.out.println();

		//testing getLastName
		this.testGetLastName();
		
		System.out.println();
		
		//testing getPhoneNumber
		this.testGetPhoneNumber();
		
		System.out.println();
		
		//testing setFirstName
		this.testSetFirstName(fn);
		
		System.out.println();
		
		//testing setLastName
		this.testSetLastName(ln);
		
		System.out.println();
		
		//testing setPhoneNumber
		this.testSetPhoneNumber(pn);
	}
	
	/**
	 * Tests the getFirstName() method
	 */
	public void testGetFirstName() {
		System.out.println("Testing getting first name");
		System.out.println("First name is: " + contact.getFirstName());
	}
	
	/**
	 * Tests the getLastName() method
	 */
	public void testGetLastName() {
		System.out.println("Testing getting last name");
		System.out.println("Last name is: " + contact.getLastName());
	}
	
	/**
	 * Tests the getPhoneNumber() method
	 */
	public void testGetPhoneNumber() {
		System.out.println("Testing getting phone number");
		System.out.println("Phone number is: " + contact.getPhoneNumber());
	}
	
	/**
	 * Tests the setFirstName() method
	 * @param fn New first name
	 */
	public void testSetFirstName(String fn) {
		System.out.println("Testing setting first name to '"+ fn + "'");
		contact.setFirstName(fn);
		System.out.println(this);
	}
	
	/**
	 * Tests the setLastName() method
	 * @param ln New last name
	 */
	public void testSetLastName(String ln) {
		System.out.println("Testing setting last name to '"+ ln + "'");
		contact.setLastName(ln);
		System.out.println(this);
	}
	
	/**
	 * Tests the setPhoneNumber() method
	 * @param pn New phone number
	 */
	public void testSetPhoneNumber(String pn) {
		System.out.println("Testing setting phone number to '"+ pn + "'");
		contact.setPhoneNumber(pn);
		System.out.println(this);
	}
	
	/**
	 * Tests the toString method
	 * @return str The string containing contact info
	 */
	public String toString() {
		//Appends the contact info to the string
		String str="First name: "+ contact.getFirstName() + " Last name: " + contact.getLastName() + " Phone number: " + contact.getPhoneNumber();
		return str;
	}
}

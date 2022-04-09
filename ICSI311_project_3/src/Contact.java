/**
 * The Contact class
 * @author Steven Maggio
 *
 * @param <E>
 */
public class Contact<E> implements Comparable<Contact<E>>{
	
	private String firstName;	//First name of contact
	private String lastName;	//Last name of contact
	private String phoneNumber;	//Phone number of contact
	
	/**
	 * Initializes contact with no parameters
	 */
	public Contact() {
		firstName="";
		lastName="";
		phoneNumber="";
	}
	
	/**
	 * Initializes contact with 3 parameters
	 * @param fn	First name of contact
	 * @param ln	Last name of contact
	 * @param pn	phone number of contact
	 */
	public Contact(String fn, String ln,String pn) {
		firstName=fn;
		lastName=ln;
		phoneNumber=pn;
	}
	
	/**
	 * Returns first name.
	 * @return firstName First name of contact
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Returns last name
	 * @return lastName The last name of the contact
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Returns the phone number of the contact
	 * @return phoneNumber The phone number of the contact
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * Sets the first name of the contact
	 * @param fn The first name of the contact
	 */
	public void setFirstName(String fn) {
		firstName = fn;
	}
	
	/**
	 * Sets the last name of the contact
	 * @param ln The last name of the contact
	 */
	public void setLastName(String ln) {
		lastName = ln;
	}
	
	/**
	 * Sets the phone number of the contact
	 * @param pn The phone number of the contact
	 */
	public void setPhoneNumber(String pn) {
		phoneNumber = pn;
	}
	
	/**
	 * Overrides the toString method
	 * returns a string containing the contact's: first name, last name, and phone number
	 * @return str The string containing the contact info
	 */
	public String toString() {
		String str=firstName +" "+lastName+ " "+phoneNumber;
		return str;
	}
	
	/**
	 * Overrides the equals method
	 * @param other The other contact
	 * @return true if both contacts contain same info, false otherwise
	 */
	public boolean equals(Contact other) {
		//Getting info of first contact
		String thisFirstName=this.getFirstName();
		String thisLastName=this.getLastName();
		String thisPhoneNumber=this.getPhoneNumber();
		
		//Getting info of second contact
		String otherFirstName=other.getFirstName();
		String otherLastName=other.getLastName();
		String otherPhoneNumber=other.getPhoneNumber();
		
		//Evaluating contacts for equivalence
		boolean isFirstEqual = thisFirstName.equals(otherFirstName);
		boolean isSecondEqual = thisLastName.equals(otherLastName);
		boolean isPhoneEqual = thisPhoneNumber.equals(otherPhoneNumber);
		
		if(isFirstEqual && isSecondEqual && isPhoneEqual) {
			//If contacts are equivalent
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Overrides the compareTo method
	 * @param o The other contact
	 * @return the result of the compareTo method
	 */
	@Override
	public int compareTo(Contact<E> o) {
		// TODO Auto-generated method stub
		return this.getLastName().compareTo(o.getLastName());
	}
	
	
}

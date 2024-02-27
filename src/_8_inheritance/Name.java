package _8_inheritance;

public class Name {
	private String first; // First name
	private String last; // Last name

	public Name() {
	} // end default constructor

	public Name(String firstName, String lastName) {
		first = firstName;
		last = lastName;
	} // end constructor

	public void setName(String firstName, String lastName) {
		setFirst(firstName);
		setLast(lastName);
	} // end setName

	public String getName() {
		return toString();
	} // end getName

	public void setFirst(String firstName) {
		first = firstName;
	} // end setFirst

	public String getFirst() {
		return first;
	} // end getFirst

	public void setLast(String lastName) {
		last = lastName;
	} // end setLast

	public String getLast() {
		return last;
	} // end getLast

	public String toString() {
		return first + " " + last;
	} // end toString

} // end Name

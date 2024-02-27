
public abstract class Employee extends Object {

	Name name;

	public Employee(String fname, String lname) {

		name = new Name(fname, lname);

	}

	public abstract double earnings();

	public String toString() {

		return name.toString();

	}

}

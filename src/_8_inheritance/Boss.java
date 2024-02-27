package _8_inheritance;
public final class Boss extends Employee {

	double salary;

	public Boss(String fname, String lname, int salary) {

		super(fname, lname);

		this.salary = salary;

	}

	public double earnings() {

		return salary;
	}

	public String toString() {

		return super.toString() + " " + "Earnings: " + earnings();

	}

}

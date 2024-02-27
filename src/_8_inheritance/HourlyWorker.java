package _8_inheritance;

public final class HourlyWorker extends Employee {

	double wage;
	double hour;

	public HourlyWorker(String fname, String lname, double wage, double hour) {

		super(fname, lname);

		this.wage = wage;
		this.hour = hour;

	}

	public double earnings() {

		return wage * hour;

	}

	public String toString() {

		return super.toString() + " " + "Earnings: " + earnings();

	}

}

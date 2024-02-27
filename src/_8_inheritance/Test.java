
public class Test {

    // Polymorphic method that can handle any subclass of Employee
    public static void printEarnings(Employee emp){

        System.out.println(emp.earnings());

    }

    public static void main(String args[]) {

        Boss b = new Boss("Sally", "Smith", 80000);

        HourlyWorker h = new HourlyWorker("Bob", "Cat", 13.75, 40);

        // Non-polymorphic call to toString() method
        System.out.println(b);
        System.out.println(h);

        Employee emps[] = new Employee[2];

        emps[0] = b;
        emps[1] = h;

        // Polymorphic call to earnigs() method
        for (Employee emp : emps)
            System.out.println(emp.earnings());


        //Passing references to a polymorphic method

        for( Employee emp: emps){

            printEarnings(emp);

        }



        Object emps2[] = new Object[2];

        emps2[0] = b;
        emps2[1] = h;

        // Polymorphic call to earnings() method but casted to retrieve the subclass reference
        for (Object emp : emps2)
            System.out.println(((Employee)emp).earnings());

            

        }



    }

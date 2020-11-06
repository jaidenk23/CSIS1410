//Jaiden Kazemini

public class Main {

	public static void main(String[] args) {

		Employee e1 = new Employee(123456);
		Employee e2 = new Employee(654321);
		Employee e3 = new Employee(246810);

		e1.setFirstName("Harry");
		e1.setLastName("Johnson");
		e1.setStatus("F");
		e1.setAge((byte) 38);
		e1.setSalary(70000);
		e1.setTitle("Assistant-Manager");

		e2.setFirstName("Heather");
		e2.setLastName("Oswald");
		e2.setStatus("P");
		e2.setAge((byte) 27);
		e2.setSalary(45000);
		e2.setTitle("Human Resources");

		e3.setFirstName("Cory");
		e3.setLastName("Smith");
		e3.setStatus("T");
		e3.setAge((byte) 31);
		e3.setSalary(60000);
		e3.setTitle("Accountant");

		try {
			e1.printEmployee();
			e2.printEmployee();
			e3.printEmployee();
		} catch (Exception e) {
		}
		
		
		Salary s = new Salary();
		System.out.println(s.print());
		
		Hourly h = new Hourly();
		System.out.println(h.print());
		
		Commission c = new Commission(10);
		System.out.println(c.print());
	}

}

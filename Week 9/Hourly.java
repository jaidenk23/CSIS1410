
public class Hourly {
	Employee emp;
	
	public Hourly() {
		emp = new Employee(0);
		emp.setSalary(emp.salary / 2080); // 2080 = 40 * 52
	}
	
	public double print() {
		return emp.salary;
	}
}

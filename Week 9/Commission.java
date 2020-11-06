
public class Commission {
	int customersHelped;
	Employee emp;
	
	public Commission(int c) {
		customersHelped = c;
		emp = new Employee(0);
		emp.setSalary((c + emp.salary / 2080) * 2080);
	}
	
	public double print() {
		return emp.salary;
	}

}
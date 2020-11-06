
public class Salary{
	Employee emp;
	
	public Salary() {
		emp = new Employee(0);
		emp.setSalary(emp.salary);
	}
	
	public double print() {
		return emp.salary;
	}
}
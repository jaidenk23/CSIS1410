//Jaiden Kazemini

public class Employee {

	int employeeID;
	String firstName;
	String lastName;
	byte age;
	String title;
	private double salary;
	String status;

	public Employee(int employeeID) {

		this.employeeID = employeeID;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;

	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		if (status.equals("T")) {
			this.status = "Temp";
			return;
		}
		
		if (status.equals("F")) {
			this.status = "Full-time";
			return;
	}	
		if (status.equals("P")) {
			this.status = "Part-time";
			return;
}	
		if (status.equals("S"))
			this.status = "Seasonal";
		
		else
			this.status = "Unknown";
	}

	public void printEmployee() {

		System.out.println("Name: " + this.firstName + " " + this.lastName);
		System.out.println("Status: " + this.status);
		System.out.println("Age: " + this.age);
		System.out.println("Title: " + this.title);
		System.out.println("Salary: " + this.salary);
		System.out.println("Employee ID: " + this.employeeID + "\n");
	}
}

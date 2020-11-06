import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//Jaiden Kazemini

public class Employee {

	int employeeID;
	String firstName;
	String lastName;
	byte age;
	String title;
	double salary;
	String status;
	int supervisor_id;
	boolean bonus;
	String department;
	int insurance;
	String hiredate;
	String phone;

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
	
	public void setSupervisorID(int x) {
		this.supervisor_id = x;
	}
	
	public int getSupervisorID() {
		return this.supervisor_id;
	}
	
	public boolean getBonus() {
		return this.bonus;
	}
	
	public void setBonus(boolean b) {
		this.bonus = b;
	}
	
	public String getDepartment() {
		return this.department;
	}
	
	public void setDepartment(String s) {
		this.department = s;
	}
	
	public int getInsurance() {
		return this.insurance;
	}
	
	public void setInsurance(int x) {
		this.insurance = x;
		
		if (x == 1)
			this.salary -= 2000;
		if (x == 2)
			this.salary -= 1500;
		if (x == 3)
			this.salary -= 1000;
		if (x == 4)
			this.salary -= 500;
	}
	
	public String getHireDate() {
		return this.getHireDate();
	}
	
	public void setHireDate(String s) {
		this.hiredate = s;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void setPhone(String s) {
		this.phone = s;
	}
	
	
	public void getEmployee(int id) {
		try {
			ReadEmployee emp = new ReadEmployee();
			
			for (int i = 0; i < emp.arr.length; i++)
				if (Integer.parseInt(emp.arr[i][0]) == id) {
					for (int j = 0; j < emp.arr[0].length; j++) {
						if (j == 0)
							this.setFirstName(emp.arr[i][j]);
						if (j == 1)	
							this.setLastName(emp.arr[i][j]);
						if (j == 2)
							this.setAge(Byte.parseByte(emp.arr[i][j]));
						if (j == 3)
							this.setTitle(emp.arr[i][j]);
						if (j == 4)
							this.setSalary(Double.parseDouble(emp.arr[i][j]));
						if (j == 5)
							this.setStatus(emp.arr[i][j]);
						if (j == 6) 
							this.setSupervisorID(Integer.parseInt(emp.arr[i][j]));
						if (j == 7)
							if (emp.arr[i][j] == "1")
								this.setSalary(this.salary + 1000);
						if (j == 8)
							this.setDepartment(emp.arr[i][j]);
						if (j == 9) 
							this.setInsurance(Integer.parseInt(emp.arr[i][j]));
						if (j == 10)
							this.setHireDate(emp.arr[i][j]);
						if (j == 11)
							this.setPhone(emp.arr[i][j]);
					}	
				}					
		} 
		catch (IOException e) {
		}
		
		

	}
	
	public void printEmployee() throws ParseException {
		System.out.println("Name: " + this.firstName + " " + this.lastName);
		System.out.println("Status: " + this.status);
		System.out.println("Age: " + this.age);
		System.out.println("Title: " + this.title);
		System.out.println("Salary: " + this.salary);
		System.out.println("Employee ID: " + this.employeeID + "\n");
		System.out.println("Supervisor ID: " + this.supervisor_id);
		System.out.println("Bonus: " + this.bonus);
		System.out.println("Department: " + this.department);
		
		if (this.insurance == 0)
			System.out.println("None");
		else
			System.out.println("Option # " + this.insurance);
	
		String oldFormat = "yyyy-MM-dd";
		String newFormat = "MM/dd/yyyy";
		String newDate;

		SimpleDateFormat sdf = new SimpleDateFormat(oldFormat);
		
		Date d = sdf.parse(this.hiredate);
		
		sdf.applyPattern(newFormat);
		newDate = sdf.format(d);
		
		System.out.println(newDate);
		
		char[] temp = this.phone.toCharArray();
		String date = "(";
		
		for (int i = 0; i < temp.length; i++) {
			date += temp[i];
			
			if (i == 3)
				date += ")";
			
			if (i == 7)
				date += "-";
		}
			
		System.out.println("Hire date: " + date);
	}
	
}

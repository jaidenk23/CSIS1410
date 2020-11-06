import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadEmployee {

	static String fileName = "C:\\Users\\Jaiden\\Desktop\\Semester 2\\CS1410\\EmployeeData.txt";
	public String[][] arr = new String[20][20];
	
	public ReadEmployee() throws IOException {
		File dataFile = new File(fileName);
		BufferedReader br = new BufferedReader(new FileReader(dataFile));
		
		for (int i = 0; i < arr.length && br.ready(); i++)
			arr[i] = br.readLine().split(",");

		br.close();
	}

}

package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * @author Jaiden Kazemini
 * CSIS1410
 * December 13th, 2020
 * 
 * The below class is the controller for
 * everything in the tip calculator application. 
 * It has separate methods for the checkboxes and submit button. 
 * 
 * Below the class name are each value
 * from the GUI. 
 */
public class SampleController {
	/*
	 * For every variable below,
	 * I used refactoring to change
	 * their names to make it 
	 * easier to understand what belongs
	 * where. 
	 *
	 */
	@FXML
	private AnchorPane Background;

	@FXML
	private Text Title;

	@FXML
	private Text AmountPaid;

	@FXML
	private TextField AmountPaidTextField;

	@FXML
	private Text TenPercent;

	@FXML
	private Text FifteenPercent;

	@FXML
	private Text TwentyPercent;

	@FXML
	private CheckBox CheckBox10;

	@FXML
	private CheckBox CheckBox15;

	@FXML
	private CheckBox CheckBox20;

	@FXML
	private Text CustomPercentage;

	@FXML
	private TextField CustomPercentageTextField;

	@FXML
	private Button SubmitButton;

	@FXML
	private Text CustomPercentagePercentSymbol;

	@FXML
	private ImageView CoinJarImage;

	@FXML
	private TextField TotalTextField;

	@FXML
	private Text Total;
	
	@FXML
	private boolean tenPercent;
	
	@FXML
	private boolean fifteenPercent;
	
	@FXML
	private boolean twentyPercent;
	
	/**
	 * The below method calls each checkbox variable
	 * and uses the isSelected boolean in order to know
	 * that a checkbox is clicked. 
	 */
	@FXML
	private void checkBoxClicked() {
		tenPercent = CheckBox10.isSelected();
		fifteenPercent = CheckBox15.isSelected();
		twentyPercent = CheckBox20.isSelected();
	}
	
	/**
	 * The below method is used for knowing that the submit button is clicked. 
	 * 
	 * @throws IOException
	 */
	@FXML
	public void submitButtonPressed() throws IOException {	
		CsvUtil util = new CsvUtil();
		
		/*
		 *  The below "if statement" is used to 
		 *  throw an error if a value is not entered
		 *  and the submit button is pressed. 
		 */
		if (AmountPaidTextField.getText().isEmpty())
			throw new IllegalArgumentException("Enter a value.");
		/*
		 * If there is a value entered and the submit button is pressed, the
		 * code below will calculate the percentage. 
		 */
		double amount = Double.parseDouble(AmountPaidTextField.getText());
		
		util.writeCSV(amount, "amount");
		
		double tipPercentage;
		/*
		 * The statements below show which
		 * percentage will be used based
		 * on the checkboxes/custom percentage
		 * text field. 
		 */
		if (tenPercent)
			tipPercentage = 10;

		
		else if (fifteenPercent)
			tipPercentage = 15;

		
		else if (twentyPercent)
			tipPercentage = 20;

		
		else if (!CustomPercentageTextField.getText().isEmpty())
			tipPercentage = Double.parseDouble(CustomPercentageTextField.getText());
		
		else
			tipPercentage = util.readCSV();

		
		double tip = amount * (tipPercentage / 100);
		double total = amount + tip;
		
		util.writeCSV(total, "total");
		
		/*
		 * The below string limits the decimal amount
		 * to two decimals maximum. 
		 */
		String totalString = String.format("%.2f", total);

		TotalTextField.setText(totalString);
	}
	
	/**
	 * The class below is used for reading/writing 
	 * to a csv file with a method for each. 
	 */
	public class CsvUtil {

		String finalProject = "C:\\Users\\Jaiden\\Desktop\\Semester 2\\CS1410\\FinalProject.csv";
		File dataFile;
		BufferedReader csvReader;
		FileWriter csvWriter;
		
		/**
		 * The method below uses the above values
		 * to create an object for each one. 
		 * @throws IOException
		 */
		public CsvUtil() throws IOException {
			dataFile = new File(finalProject);
			csvReader = new BufferedReader(new FileReader(dataFile));
			csvWriter = new FileWriter(dataFile, true);
		}
		
		/**
		 * The method below reads values from a 
		 * csv file if a value is entered and no tip
		 * percentage is utilized. 
		 * @throws IOException
		 */
		public double readCSV() throws IOException {
			return csvReader.read();
		}
		
		/**
		 * The method below writes values to a csv
		 * file from the GUI amount input. 
		 * 
		 * @param amount
		 * @param type
		 * @throws IOException
		 */
		public void writeCSV(double amount, String type) throws IOException {
			csvWriter = new FileWriter(dataFile, true);
			
			if (type == "amount")
				csvWriter.write(amount + ",");
			else 
				csvWriter.write(amount + "\n");

			csvWriter.close();
		}
	}
}

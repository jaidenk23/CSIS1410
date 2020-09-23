
/**
 * This program reads a data file containing
 * gamer scores, then produces a report from
 * that data.
 * 
 * @author Jaiden Kazemini
 * @version 1.0
 */
package jaiden_kazemini_GamesReport;

import java.io.File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class jaiden_kazemini_GamesReport {

	public static void main(String[] args) throws IOException {
		/**
		 * 
		 * The code below calls each separate method in order to produce the report, add
		 * a new gamer, and produce an updated report.
		 */
		String fileName = "C:\\Users\\Jaiden\\Desktop\\Semester 2\\GameScores.txt";
		myReport(fileName);
		addGamer(fileName, "Jimmy", "180,160,170,200,200,153,184,192,158,167");
		myReport(fileName);
	}

	private static void myReport(String fileName) throws IOException {
		File dataFile = new File(fileName);
		BufferedReader br = new BufferedReader(new FileReader(dataFile));
		String highestName = "";
		String line = "";
		int recordCount = 0;
		int largest = 0;

		if (dataFile.exists())

			System.out.print(
					"-----------------------------------------------------------------------------------------------\r\n");
		System.out.println("Games Report");
		System.out.print(
				"-----------------------------------------------------------------------------------------------\r\n");
		System.out.print("Gamer	1	2	3	4	5	6	7	8	9	10	Total\r\n");
		System.out.print(
				"-----------------------------------------------------------------------------------------------\r\n");

		while ((line = br.readLine()) != null) {
			recordCount++;
			String[] gamer = line.split(",");
			String[] gamerTotal = new String[gamer.length + 1];
			int sum = 0;

			for (int i = 1; i < gamer.length; i++) {
				sum = sum + Integer.parseInt(gamer[i]);
			}

			for (int i = 0; i < gamer.length; i++)
				gamerTotal[i] = gamer[i];

			gamerTotal[gamerTotal.length - 1] = Integer.toString(sum);

			
			for (int i = 0; i < gamerTotal.length; i++) {
				System.out.print(gamerTotal[i] + "\t");
				if (i > 10 && i % 11 == 0)
					System.out.println();

				if (i % 12 != 0 && Integer.parseInt(gamerTotal[i]) > largest) {
					largest = Integer.parseInt(gamerTotal[i]);

					highestName = gamerTotal[0];
				}
			}
		}

		System.out.print(
				"-----------------------------------------------------------------------------------------------\r\n");
		System.out.print("# of Gamers: " + recordCount + "\n");
		System.out.print("Top Gamer: " + highestName + "\n");
		System.out.print(
				"-----------------------------------------------------------------------------------------------\r\n");

		br.close();
		dataFile = null;
	}

	private static void addGamer(String fileName, String fname, String scores) throws IOException {

		FileWriter writer = new FileWriter(fileName, true);
		writer.write(fname + "," + scores + "\r\n");
		System.out.println("Gamer " + fname + " record added.");
		writer.close();
	}

}

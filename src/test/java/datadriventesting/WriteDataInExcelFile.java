package datadriventesting;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import java.util.Scanner;

public class WriteDataInExcelFile {
	
	/*
	 * 1. Create a file using OutPutStream 
	 * 2. Create Workbook using XSSFWorkbook
	 * 3. Create sheet using createSheet() in XSSFWorkbook
	 * 4. 
	 */

	FileOutputStream outputFile;
	XSSFWorkbook testWorkbook;
	XSSFSheet testSheet;
	Scanner scan;

	
	void createFile(String filePath) throws FileNotFoundException {
		// Create file  
		outputFile = new FileOutputStream(filePath);
				
		// Create workbook 
		testWorkbook = new XSSFWorkbook();
				
		// Create sheet
		testSheet = testWorkbook.createSheet();
	}
	

	
	void writeDataToFile() throws IOException, FileNotFoundException {
		
		// Get cell input from a user to store in a cell 
		String cell;

		scan = new Scanner(System.in);
		for(int i=0;i<3;i++) {
			// Write rows
			XSSFRow row = testSheet.createRow(i);
			
			for(int j=0;j<3;j++) {
				// Write cells on each row
				cell = scan.nextLine();
				row.createCell(j).setCellValue(cell);
			}
			System.out.println("One row added");
		}
		
		
		// First create row
		/*
		r1.createCell(0).setCellValue("Employee ID");
		r1.createCell(1).setCellValue("Employee Name");
		r1.createCell(2).setCellValue("Employee Salary");

		XSSFRow r2 = testSheet.createRow(1);
		r2.createCell(0).setCellValue("EMP100");
		r2.createCell(1).setCellValue("XYZ");
		r2.createCell(2).setCellValue("1000000");
		
		XSSFRow r3 = testSheet.createRow(2);
		r3.createCell(0).setCellValue("EMP101");
		r3.createCell(1).setCellValue("XZY");
		r3.createCell(2).setCellValue("1300000");
		*/
		// Once done with adding rows, add the file to workbook
		testWorkbook.write(outputFile);
		testWorkbook.close();
		outputFile.close();
		
		System.out.println("XCEL file created successfully...!!!");
	}
	
	public static void main(String[] args) throws IOException, FileNotFoundException  {
		// TODO Auto-generated method stub
		WriteDataInExcelFile writeXcelFile = new WriteDataInExcelFile();
		
		// Call to createFile(arg) function
		writeXcelFile.createFile(System.getProperty("user.dir")+"//data//TestData.xlsx");
		
		// Call to writeDataToFile();
		writeXcelFile.writeDataToFile();
		//System.out.print();
	}

}

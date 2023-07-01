package datadriventesting;


import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromXcel {
	
	/*
	 * Use FileInputStream class to read the files(Package : java.io)
	 * XSSFWorkbook => For dealing with Workbook
	 * XSSSheet => Deal with Sheets in workbook
	 * XSSFRow => Deal with rows in sheets
	 * XSSFCell => Deal with cells in the sheets
	 */
	
	void readFiles() throws IOException {
		// Read xcel file using 'FileInputStream' class
		FileInputStream readXcel = new FileInputStream(System.getProperty("user.dir")+"//data//TestDataHungamaTV.xlsx");
		
		// Read workbook
		XSSFWorkbook workbook = new XSSFWorkbook(readXcel);
		
		// Read sheet
		XSSFSheet  sheet = workbook.getSheet("Test Data");
		
		// Read columns and rows by getting cells
		int rows = sheet.getLastRowNum();  // Will return total rows
		int columns = sheet.getRow(1).getLastCellNum();		// Get total columns
		
		for(int i = 0;i<=rows;i++) {
			// Outer loop - iterate through the rows
			XSSFRow current_row = sheet.getRow(i); 	//Get current row in the sheet
			
			for(int j=0;j<columns;j++) {
				// Inner loop - Iterate through the each single cell present on the row
				XSSFCell current_cell = current_row.getCell(j);
				//String cell_value = current_row.getCell(j).toString();
				String current_value = current_cell.toString();
				System.out.print(current_value+ "\t|\t");
			}
			
			// Move pointer to next row to print next row
			System.out.println();
		}
		workbook.close();
		readXcel.close();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ReadDataFromXcel xcel = new ReadDataFromXcel();
		xcel.readFiles();
	}

}

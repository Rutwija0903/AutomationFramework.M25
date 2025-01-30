package swagLabs.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic methods related to excel file
 * @author Rutwija Haripurkar
 */

public class ExcelFileUtility {
	/**
	 * This method will read data from excel file by taking sheetName, rowNum, CellNum from caller
	 * and return the value to caller
	 * @param sheetName, rowNum, cellNum
	 * @return 
	 * @throws Throwable
	 */
	public String readDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String Value = cell.getStringCellValue();
		return Value;
			
	}

}

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.ResourceBundle;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelReader {

	public static Object[][] readExcel() throws IOException{
		ResourceBundle rb = ResourceBundle.getBundle("config");
		final int NO_OF_ROWS = Integer.parseInt(rb.getString("rows")); //read no of rows from property file
		final int NO_OF_COLS = Integer.parseInt(rb.getString("cols")); // read no of cols from property file
		Object array[][] = new Object[NO_OF_ROWS][NO_OF_COLS]; // create 2-d array it stores the data coming from excel
		
		String path = rb.getString("excelpath");
		boolean isFirstRowPass = false;
		File file = new File(path);  // Get the File Path
		if(!file.exists()){
			System.out.println("File Not exist can't read the file...");
			return null;
		}
		FileInputStream fs  = new FileInputStream(file); // Open a file to read
		//XSSFWorkbook  -2013 - 2017 (xlsx)
		//HSSFWorkbook 2003-2007 (xls)
		HSSFWorkbook workBook = new HSSFWorkbook(fs);  // open a workbook
		HSSFSheet sheet = workBook.getSheetAt(0); // open a worksheet
		Iterator<Row> rows = sheet.rowIterator();  // get rows from the worksheet
		int rowIndex = 0;  // set the rowIndex as 0 
		while(rows.hasNext()){  // traverse a row one by one
			int colIndex = 0; // set the column index as 0
			Row currentRow = rows.next(); // give current row and move to next row
			if(!isFirstRowPass){ // Code for by passing the headers of excel
				isFirstRowPass = true;
				continue;
			}
			Iterator<Cell> cells = currentRow.cellIterator();  // get cells from the current row
			while(cells.hasNext()){ // traverse a cell one by one
				Cell currentCell = cells.next();  // get the current cell
				if(currentCell.getCellType()==Cell.CELL_TYPE_STRING){  // check the cell of string type
					System.out.print(currentCell.getStringCellValue()+" ");  // get the string type cell and print it
					array[rowIndex][colIndex] = currentCell.getStringCellValue(); // store each column data in 2-d array
				}
				colIndex++;  // increase the column index of 2-d array
			} // Cell Loop end
			rowIndex++; // increase the row index of 2-d array
			System.out.println();  // print in a new line
		}
		workBook.close();  // close the workbook
		fs.close();  // and close the open file
		return array;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		readExcel();

	}

}

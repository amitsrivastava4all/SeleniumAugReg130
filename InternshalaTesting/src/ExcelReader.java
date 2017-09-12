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

	public static void readExcel() throws IOException{
		ResourceBundle rb = ResourceBundle.getBundle("config");
		String path = rb.getString("excelpath");
		File file = new File(path);  // Get the File Path
		if(!file.exists()){
			System.out.println("File Not exist can't read the file...");
			return ;
		}
		FileInputStream fs  = new FileInputStream(file); // Open a file to read
		//XSSFWorkbook  -2013 - 2017 (xlsx)
		//HSSFWorkbook 2003-2007 (xls)
		HSSFWorkbook workBook = new HSSFWorkbook(fs);  // open a workbook
		HSSFSheet sheet = workBook.getSheetAt(0); // open a worksheet
		Iterator<Row> rows = sheet.rowIterator();  // get rows from the worksheet
		while(rows.hasNext()){  // traverse a row one by one
			Row currentRow = rows.next(); // give current row and move to next row
			Iterator<Cell> cells = currentRow.cellIterator();  // get cells from the current row
			while(cells.hasNext()){ // traverse a cell one by one
				Cell currentCell = cells.next();  // get the current cell
				if(currentCell.getCellType()==Cell.CELL_TYPE_STRING){  // check the cell of string type
					System.out.print(currentCell.getStringCellValue()+" ");  // get the string type cell and print it
				}
			} // Cell Loop end
			System.out.println();  // print in a new line
		}
		workBook.close();  // close the workbook
		fs.close();  // and close the open file
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		readExcel();

	}

}

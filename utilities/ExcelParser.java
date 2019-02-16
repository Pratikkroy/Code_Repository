package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

/*import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelParser {

	public void excelWrite()
	{
		
	}
	
	public void excelRead() 
	{
		try
		{
			String path="/usr/lib/jvm/java-8-oracle/external files/Employee.xlsx";
			
			FileInputStream file=new FileInputStream(new File(path));
			XSSFWorkbook workbook=new XSSFWorkbook(file);
			XSSFSheet sheet=workbook.getSheetAt(0);
			
			Iterator<Row> rowIterator=sheet.iterator();
			Iterator<Cell> cellIterator;
			
			Row row;
			Cell cell;
			
			rowIterator.next();
			while(rowIterator.hasNext())
			{
				row=rowIterator.next();
				cellIterator=row.iterator();
				
				while(cellIterator.hasNext())
				{
					cell=cellIterator.next();
					
					if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
						System.out.println("Emp ID :: "+(int)cell.getNumericCellValue());
					else if(cell.getCellType()==Cell.CELL_TYPE_STRING)
						System.out.println("Name :: "+cell.getStringCellValue());
					
				}
				System.out.println();
			}
			
			logger.info("Excel file has been read");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	final static Logger logger=LogManager.getLogger(ExcelParser.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		logger.info("Logging is configured");
		new ExcelParser().excelRead();
	}

}*/

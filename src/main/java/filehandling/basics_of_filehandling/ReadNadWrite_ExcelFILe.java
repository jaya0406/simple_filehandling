package filehandling.basics_of_filehandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadNadWrite_ExcelFILe {
	//NOTE: To handle excel files use these dependencies
	
	/*<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi</artifactId>
    <version>5.2.5</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml</artifactId>
    <version>5.2.5</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml-schemas -->
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml-schemas</artifactId>
    <version>4.1.2</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.apache.poi/poi-scratchpad -->
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-scratchpad</artifactId>
    <version>5.2.5</version>
</dependency>*/
	
	String createNewFilePath=System.getProperty("user.dir") +"\\NewDir\\sample.xlsx";
	
	public void createexcelfile() throws IOException
	{
		File f = new File(createNewFilePath);
		FileOutputStream fos = new FileOutputStream(f);
		XSSFWorkbook wbk = new XSSFWorkbook();//creates empty workbook...
		
	}
	
	public void toWriteexcel() throws IOException
	{
		String setvalue= "Software Testing";
		File f = new File(createNewFilePath);
		FileOutputStream fos = new FileOutputStream(f);
		XSSFWorkbook wbk = new XSSFWorkbook();
		Sheet sheet =  wbk.createSheet("Write");//creating sheet
		
		//creates cell
		Row row = sheet.createRow(0);
		Cell cell1= row.createCell(0);
		//writing value in 0th row 0th column...
		cell1.setCellValue(setvalue);
		
		wbk.write(fos);
		wbk.close();
	
		System.out.println("Done...");
	}
	
	public void readexcelfile() throws IOException 
	{
		File f = new File(createNewFilePath);
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wbk = new XSSFWorkbook(fis);
		
		//getting sheet from wbk...
		
		Sheet sheet1 = wbk.getSheet("Write");
		Row row1= sheet1.getRow(0);
		Cell getcell= row1.getCell(0);
		
		String cellvalue = getcell.getStringCellValue();
		System.out.println(cellvalue);
	}

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		ReadNadWrite_ExcelFILe rwxl= new ReadNadWrite_ExcelFILe();
		rwxl.createexcelfile();
		rwxl.toWriteexcel();
		rwxl.readexcelfile();
	}

}

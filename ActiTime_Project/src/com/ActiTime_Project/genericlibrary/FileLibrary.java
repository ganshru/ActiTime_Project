package com.ActiTime_Project.genericlibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This is a generic class which contains non static method to read data from property file and excel file.
 * @author super
 *
 */

public class FileLibrary {
	
	/**
	 * This method is used to non static method which is used to read data from property file.
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String readdatafromproperty(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./Testdata/commondata.property");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	
	/**
	 * This method is used to non static method which is used to read data from excel sheet.
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String readdatafromexcelfile(String sheetname, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./Testdata/Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}

}

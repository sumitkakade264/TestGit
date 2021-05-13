package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public String path = null;
	public File src = null;
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row1 = null;
	private XSSFRow row2 = null;
	private XSSFCell cell1;
	private XSSFCell cell2;
	public Map<String, String> data;

	public ExcelUtils(String path, String sheetName) {
		try {
			this.path = path;
			src = new File(this.path);
			fis = new FileInputStream(src);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Map<String, String> getMap(String iteration) {
		data = new HashMap<String, String>();
		int rowNum = 1;
		row1 = sheet.getRow(0);
		int lastCellCount = row1.getLastCellNum();
		boolean rowFound = false;
		while (!rowFound) {
			row2 = sheet.getRow(rowNum);
			System.out.println(row1 == null);// Check
			cell1 = row2.getCell(1);
			System.out.println(String.valueOf(cell1));
			if (String.valueOf(cell1).equals(iteration)) {
				rowFound = true;
				for (int i = 0; i < lastCellCount; i++) {
					data.put(String.valueOf(row1.getCell(i)), String.valueOf(row2.getCell(i)));
				}
			} else
				rowNum++;
		}
		return data;
	}
}

package interveiw.coding.java.xl;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NewXl {
	
	public static void writeExcel() {

		// Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();

		// Create a blank sheet
		XSSFSheet sheet = workbook.createSheet("Smarttech");

		// This data needs to be written (Object[])
		Map<String, Object[]> data = new TreeMap<String, Object[]>();
		data.put("1", new Object[] { "ID", "FIRSTNAME", "LASTNAME" });
		data.put("2", new Object[] { 101, "Ansar", "Mehmood" });
		data.put("3", new Object[] { 102, "Badrul", "Rahman" });
		data.put("4", new Object[] { 103, "Imam", "Mahdi" });
		data.put("5", new Object[] { 104, "Korshed", "Alam" });

		Set<String> keyset = data.keySet();
		int rownum = 0;
		for (String Key : keyset) {
		Row row = sheet.createRow(rownum++);
		Object[] objarr = data.get(Key);

		int cellnum = 0;
		for (Object obj : objarr) {
		Cell cell = row.createCell(cellnum++);
		if (obj instanceof String)
		cell.setCellValue((String) obj);

		else if (obj instanceof Integer)
		cell.setCellValue((Integer) obj);

		}
		}
		try {
		FileOutputStream out = new FileOutputStream(new File ("Student123.xlsx"));
		workbook.write(out);
		out.close();
		System.out.println("Student123.xlsx written successfully on disk");
		}
		catch (Exception e) {
		e.getMessage();
		}
		}
public static void main(String[] args) {
	writeExcel();
}
}

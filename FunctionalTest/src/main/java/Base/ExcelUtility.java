package Base;

import java.io.FileInputStream;
import java.io.IOException;
/*import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook*/

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;;

public class ExcelUtility {

	public static String[][] getvalues(String datafile,String Sheet_name,String testname) throws IOException{
			FileInputStream ExcelFile = new FileInputStream(datafile);
			Workbook Workbook = new XSSFWorkbook(ExcelFile);
			Sheet ExcelWSheet = Workbook.getSheet(Sheet_name);
			String [][] datatable=null;
			int total_rows= ExcelWSheet.getLastRowNum()+1;
			int total_columns= ExcelWSheet.getRow(0).getLastCellNum();
			datatable= new String[2][total_columns];
			//System.out.println(Row row= (XSSFRow) ExcelWSheet.getRow(0));
			for (int i=0;i<total_columns;i++)
			{
				Row row= ExcelWSheet.getRow(0);
				Cell cell=row.getCell(i);
				datatable[0][i]=cell.getStringCellValue().trim();
				//datatable[0][i]=ExcelWSheet.getRow(0).getCell(i).getStringCellValue().trim();
				System.out.println(datatable[0][i]);
			}
			for(int i=0;i<total_rows;i++)
			{
				Row row=ExcelWSheet.getRow(i);
				Cell cell=row.getCell(0);
				if(cell.getStringCellValue().equals(testname))
				{
					for(int j=0;j<total_columns;j++)
					{
						cell=row.getCell(j);
						if(cell==null)
						{
							datatable[1][j]=null;
						}
						else
						{
							if(cell.getCellType() == Cell.CELL_TYPE_STRING)
							{
								datatable[1][j]=cell.getStringCellValue();
							}
						}
					}break;
				}

			}
			return datatable;
	}


}

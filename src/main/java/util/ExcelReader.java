package util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {
    File file;
    FileInputStream fis;
    private XSSFWorkbook workbook = null;


    Sheet sheet;
    Cell cell;


    public ExcelReader(String path)  {
        file=new File(path);
        try {
            fis=new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            workbook= new XSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public int getRowCount(String sheetname)
    {
         sheet=workbook.getSheet(sheetname);
        return sheet.getLastRowNum()+1;
    }
    public int getColumnCount(String sheetName)
    {
        sheet=workbook.getSheet(sheetName);
        return sheet.getRow(0).getLastCellNum();
    }


    public String readCell(String sheetName,int rowN,int col)
    {
        sheet=workbook.getSheet(sheetName);
        cell=sheet.getRow(rowN).getCell(col);
        return cell.toString();

    }

    }


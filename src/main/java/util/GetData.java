package util;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class GetData  {
    public static ExcelReader excl;


    @DataProvider(name = "dataHudl")
    public Object[][] readData(Method m) {

        String testCaseName = m.getName();
        System.out.println("Test case name is" + testCaseName);
//        int i = 0;
//        for (i = 0; i < excl.getRowCount(ApiSetUP.sheetName)-1; i++) {
//            String cellData = excl.readCell(sheetName, i, 0);
//
//            System.out.println("the data is "+cellData);
//
//            if (testCaseName.equals(cellData))
//                break;
//        }

//        int dataRowCnt = i + 2;
//        int rowHeader = i + 1;
//        while (!(excl.readCell(sheetName, dataRowCnt+rowCount, 0).equals("endOfTestData"))) {
//
//           rowCount++;
//        }
//        System.out.println("number of rows for " + testCaseName + " is " + rowCount);
//
//        while (!excl.readCell(sheetName, rowHeader, colCount).equals(" ")) {
//            System.out.println("colums are "+excl.readCell(sheetName, rowHeader, colCount));
//            colCount++;
//        }
        int rowCount=excl.getRowCount("Sheet1");
        Object[][]hudlData =new Object[rowCount-1][4];

//    for(int row=dataRowCnt;row<dataRowCnt+rowCount;row++)
//    {
//        Hashtable<String,String> table=new Hashtable<>();
//        for (int col=0;col<colCount;col++)
//        {
//          String cells=  excl.readCell(sheetName,row,col);
//          table.put(excl.readCell(sheetName,rowHeader,col),cells);
//        }
//        apiData[j][0]=table;
//        j++;
//    }
        try{
        for(int i=1;i<rowCount;i++)
        {
            for(int j=0;j<excl.getColumnCount("Sheet1");j++)
            {
//                String dta=excl.readCell("sheet1",i,j);
                hudlData[i-1][j]=excl.readCell("Sheet1",i,j);
            }


        }}
        catch (Exception e)
        {
            e.printStackTrace();
        }
return hudlData;
    }
}



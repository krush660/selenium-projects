package pack1.mavan_gsit;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
//calculate an factroial for 4 to 10  using data driven framework
public class class3 {
	
    public static void main(String[] args) {
        String excelFilePath = "C:\\Users\\Krushnal\\OneDrive\\ドキュメント\\OneDrive\\Documents\\desktop\\ab.xls";
        try {
            FileInputStream f = new FileInputStream(new File(excelFilePath));
            Workbook w = Workbook.getWorkbook(f);
            Sheet sheet = w.getSheet("Sheet3");

            for (int i = 0; i <= 6; i++) {
                Cell cell = sheet.getCell(0, i);
                if (cell.getType() == CellType.NUMBER) {
                    int number = Integer.parseInt(cell.getContents());
                    long factorial = factorial(number);
                    System.out.println("Factorial of " + number + " is " + factorial);
                }
            }

            w.close();
            f.close();
        } catch (IOException | BiffException e) {
            e.printStackTrace();
        }
    }

    public static long factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}

package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ReusableMethods {
    public String findLocationOfElementInSpecificTableCell(int row, int data){

        String xpath = "//table/tbody/tr[" + row + "]/td[" + data + "]";
        return xpath;

    }

    public String findLocationOfElementInSpecificTableCell(int table, int row, int data){

        String xpath = "//table[" + table + "]/tbody/tr[" + row + "]/td[" + data + "]";
        return xpath;

    }
    public WebElement findWebelementOfTableCell(int table, int row, int data){

        String xpathS = "//table[" + table + "]/tbody/tr[" + row + "]/td[" + data + "]";
        WebElement tableCell = Driver.getDriver().findElement(By.xpath(xpathS));
        return tableCell;
    }


}

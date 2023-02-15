package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.TableTestPage;
import utilities.Driver;
import utilities.TestBase;

import java.util.List;

public class WebTablesTest extends TestBase {
    TableTestPage tableTestPage = new TableTestPage();

    @Test
    public void tableTest() {

        Driver.getDriver().get("https://the-internet.herokuapp.com/tables");
        String tableTitle = tableTestPage.table.getText();
        System.out.println("tableTitle = " + tableTitle);

        System.out.println("=======================================================================");

        String tableFirstRowSecondData = tableTestPage.tr.getText();
        System.out.println("tableFirstRowSecondData = " + tableFirstRowSecondData);

        List<WebElement> satir3 = Driver.getDriver().findElements(By.xpath("//table//tbody//tr"));

        for (WebElement satir : satir3) {
            System.out.println(satir.getText());
        }

        System.out.println("=======================================================================");
    }
}

package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.TablePagesHomework5;
import utilities.TestBase;

public class TableTestHW5 extends TestBase {
    TablePagesHomework5 tablepage = new TablePagesHomework5();
    //    Soru 1:
//    Kullanıcı https://the-internet.herokuapp.com/tables sayfasına gider
//    Kullanıcı Tablonun 4’üncü satır 5’üncü sütundaki verinin doğruluğunu kontrol
//    eder.
//            ExpectedValue = http://www.timconway.com

    @Test
    public void test1() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/tables");
        String tr = tablepage.tr1x4x5.getText();
        String expectedValue = ("http://www.timconway.com");
        System.out.println("+++++++++++++");
        System.out.println(tr);
        Assert.assertEquals(expectedValue, tr);

    }

    //    Soru 2:
//    Kullanıcı https://demo.guru99.com/test/web-table-element.php sayfasına gider
//    Birinci tablonun tüm başlıklarının ikinci tablonun tüm başlıkları ile aynı olduğunu
//doğrular.
//        (Doğrulamayı manuel olarak tek tek değil toplu veya döngüsel bir doğrulama
//    şeklinde yapınız.)

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println(tablepage.table1.getText());
        System.out.println("======================");
        System.out.println(tablepage.table2.getText());
        System.out.println("*******");
        System.out.println(tablepage.tableList1.size());
        System.out.println("!!!!!");
        for (WebElement web : tablepage.tableList1) {
            System.out.println(web.getText());
        }
        System.out.println("!!!!!");

        for (int i = 0; i < tablepage.tableList1.size(); i++) {
            Assert.assertEquals(tablepage.tableList1.get(i).getText(), tablepage.tableList2.get(i).getText());
        }
    }

    //    Soru 3:
//    Kullanıcı https://demo.guru99.com/test/web-table-element.php Sayfasına gider
//    Kullanıcı 2’inci tabloda 3’üncü satır 4’üncü veriyi XPATH ile locate eder. Değerin
//    doğruluğunu kontrol eder.
//            ExpectedValue = $100.00
    @Test
    public void test3() {
        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println(tablepage.tr2x3x4x.getText());
        String expectedValue = "$100.00";
        Assert.assertEquals(expectedValue, tablepage.tr2x3x4x.getText());
    }
}

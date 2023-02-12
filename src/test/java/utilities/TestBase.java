package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
   protected Actions actions= new Actions(Driver.getDriver());

   //sadece kullanım kolaylığı olsun diye driver isimli bir referans oluşturdum.
   protected WebDriver driver= Driver.getDriver();
    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("projectUrl"));
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void tearDown() {

        Driver.closeDriver();
    }
}

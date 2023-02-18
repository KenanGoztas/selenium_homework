package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase extends ReusableMethods{
    //sadece kullanım kolaylığı olsun diye driver isimli bir referans oluşturdum.
    protected WebDriver driver= Driver.getDriver();
   protected Actions actions= new Actions(Driver.getDriver());
   protected ReusableMethods reusableMethods= new ReusableMethods();
    protected WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    protected AllPages allPages= new AllPages();



    @BeforeMethod
    public void setUp() {
        //sabit bir link olduğunda burayı kullanacağız
        //Driver.getDriver().get(ConfigReader.getProperty("projectUrl"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void tearDown() {

        //Driver.closeDriver();
    }
}

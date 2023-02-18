package tests;

import com.microsoft.schemas.vml.STStrokeArrowType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class WaitTest extends TestBase {
    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement remoteButton = driver.findElement(By.xpath("//button[text()='Remove']"));
        remoteButton.click();

        // WebElement addButton = driver.findElement(By.xpath("//button[text()='Add']"));
        // addButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add']"))).click();
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add']")));





    }
}

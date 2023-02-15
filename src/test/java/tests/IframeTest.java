package tests;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class IframeTest extends TestBase {

    @Test
    public void iFrameTest() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame("mce_0_ifr");
        WebElement textDoc= driver.findElement(By.id("tinymce"));
        textDoc.clear();
        textDoc.sendKeys("merhaba");

        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();



    }
}

package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

public class Alert extends TestBase {
   @Test
    public void alertAccept() throws InterruptedException {
       Driver.getDriver().get("http://the-internet.herokuapp.com/javascript_alerts");
       Driver.wait(4);
       WebElement alertButton1= Driver.getDriver().findElement(By.cssSelector("button[onclick='jsAlert()']"));
       alertButton1.click();
       String alertText= Driver.getDriver().switchTo().alert().getText().trim();
       String expectedAlertText= "I am a JS Alert";
       Driver.wait(4);
       Driver.getDriver().switchTo().alert().accept();
       Assert.assertEquals(alertText, expectedAlertText);

   }
    @Test
    public void alertAcceptAndDismiss() throws InterruptedException {
        Driver.getDriver().get("http://the-internet.herokuapp.com/javascript_alerts");
        Driver.wait(4);
        WebElement alertButton2= Driver.getDriver().findElement(By.xpath("//button[@onclick='jsAlert()']"));
        alertButton2.click();

        Driver.wait(4);
        Driver.getDriver().switchTo().alert().accept();
        Driver.wait(4);
        alertButton2.click();
        Driver.getDriver().switchTo().alert().dismiss();
    }
    public void sendMessageToAlert() throws InterruptedException {
        Driver.getDriver().get("http://the-internet.herokuapp.com/javascript_alerts");
        Driver.wait(4);
        WebElement alertButton2 = Driver.getDriver().findElement(By.xpath("//button[@onclick='jsPromt()']"));
        alertButton2.click();
        Driver.getDriver().switchTo().alert().sendKeys("Hello");
        WebElement message = Driver.getDriver().findElement(By.xpath("//div[@id='resul']"));
        String messageText = message.getText().trim();
        Assert.assertTrue(messageText.contains("Hello"));
    }





}

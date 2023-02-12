package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

public class Action extends TestBase {
    @Ignore
    @Test
    public void rightClickTest() throws InterruptedException {
        WebElement element = Driver.getDriver().findElement(By.id("hot-spot"));
        Driver.wait(3);
        actions.contextClick(element).perform();
        Driver.getDriver().switchTo().alert().accept();
    }

    @Test
    public void leftClickTest() throws InterruptedException {
        Driver.getDriver().get("https://www.ebay.de");
        WebElement searchBox = Driver.getDriver().findElement(By.id("gh-ac"));
        actions.keyDown(searchBox, Keys.SHIFT).
                sendKeys("iphone x").
                keyUp(searchBox, Keys.SHIFT).
                perform();
        Driver.wait(3);
    }
    @Test
    public void scrollUpDownTest() throws InterruptedException {
        Driver.getDriver().get("http://ebay.de");
        Driver.wait(4);
        WebElement searchBox2 = Driver.getDriver().findElement(By.id("gh-ac"));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Driver.wait(3);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Driver.wait(3);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Driver.wait(3);
        actions.sendKeys(Keys.ARROW_UP).perform();
        Driver.wait(3);
        actions.sendKeys(Keys.HOME).perform();
        Driver.wait(3);
        actions.sendKeys(Keys.DOWN).perform();
        Driver.wait(3);
        actions.sendKeys(Keys.UP).perform();
        Driver.wait(3);
        actions.sendKeys(Keys.END).perform();
    }
    @Test
    public void doubleClick() throws InterruptedException {
        Driver.getDriver().get("http://ebay.de");
        Driver.wait(4);
        WebElement searchBox2 = Driver.getDriver().findElement(By.id("gh-ac"));
        searchBox2.sendKeys("iphone x");
        Driver.wait(3);
        actions.doubleClick(searchBox2).perform();
        Driver.wait(3);
        actions.contextClick(searchBox2).perform();
        String s = searchBox2.getText();
        System.out.println(s);
    }
    @Test
    public void hover() throws InterruptedException {
        Driver.getDriver().get("http://amazon.de");
        Driver.wait(4);
        WebElement moveToElement = Driver.getDriver().findElement(By.id("nav-link-accountList-nav-line-1"));

    }
    @Test
    public void howerover() throws InterruptedException {

        Driver.getDriver().get("https://www.amazon.com/");

        Driver.wait(2);
        WebElement accountMenu = Driver.getDriver().findElement(By.id("nav-link-accountList-nav-line-1"));
        actions.moveToElement(accountMenu).perform();
        Driver.wait(2);
        WebElement accountLink = Driver.getDriver().findElement(By.xpath("(//span[contains(text(),'Account')])[2]"));
        accountLink.click();
        Driver.wait(2);

        WebElement accountHeading = Driver.getDriver().findElement(By.tagName("h1"));
        String actualAccountHeadingText = accountHeading.getText();
        String expectedAccountHeading = "Your Account";
        Driver.wait(2);
        Assert.assertEquals(actualAccountHeadingText, expectedAccountHeading);

    }


}

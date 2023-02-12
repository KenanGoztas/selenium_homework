package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SeleniumHomework4 extends TestBase {
    @Test
    public void amazonToEbay() throws InterruptedException {
        //superclassta Driver.getDriver() methotunun dönderdiği nesneyi..
        // ..ismi kısa olsun diye yeni bir WebDriver referansına atadım.

        driver.get("https://www.amazon.de/");
        WebElement cookies = driver.findElement(By.xpath("(//span[@class='a-button a-button-primary'])[1]"));
        cookies.click();

        Driver.wait(4);
        WebElement accountMenu = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        //moveto element hoover seçiyor galiba, açık bırakıyor..
        actions.moveToElement(accountMenu).perform();
        Driver.wait(4);
        WebElement geschenkeFinden = driver.findElement(By.linkText("Geschenke finden"));
        geschenkeFinden.click();
        Driver.wait(4);
        WebElement geschenke = driver.findElement(By.xpath("//*[@id=\"reactApp\"]/div/div/div[2]/h2"));
        String geschenkeText = geschenke.getText();
        System.out.println(geschenkeText);
        Driver.wait(4);

        //yeni sekme açıldı
        ((JavascriptExecutor) driver).executeScript("window.open('https://www.ebay.com', '_blank');");
        Driver.wait(4);

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //yeni sekmeye gidildi
        driver.switchTo().window(tabs.get(1));
        //diğer yöntem..
//        Set<String> s= driver.getWindowHandles();
//        Driver.getDriver().switchTo().window(s.toArray()[1].toString());

        //cookies kapatıldı
        WebElement cookies2 = driver.findElement(By.xpath("//*[@id=\"gdpr-banner-decline\"]"));
        cookies2.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        Driver.wait(2);

        WebElement search = driver.findElement(By.xpath("//input[@role='combobox']"));
        search.sendKeys(geschenkeText + Keys.ENTER);

        WebElement price = driver.findElement(By.xpath("//span[text()='$2.12']"));
        String priceText = price.getText();
        String expectedPrice = "$2.12";
        Assert.assertEquals(priceText, expectedPrice);


//
//        WebElement accountHeading = Driver.getDriver().findElement(By.tagName("h1"));
//        String actualAccountHeadingText = accountHeading.getText();
//        String expectedAccountHeading = "Your Account";
//        Driver.wait(4);
//        Assert.assertEquals(actualAccountHeadingText, expectedAccountHeading);

    }

    @Ignore
    @Test
    public void ebayTest() throws InterruptedException {
        Driver.getDriver().get("https://www.ebay.com/");
        WebElement cookies2 = Driver.getDriver().findElement(By.xpath("//*[@id=\"gdpr-banner-decline\"]"));
        cookies2.click();
        Driver.wait(4);

        WebElement search = Driver.getDriver().findElement(By.xpath("//input[@role='combobox']"));
        search.sendKeys("geschenkeText" + Keys.ENTER);

    }
}

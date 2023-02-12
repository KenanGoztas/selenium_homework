package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class SeleniumHomework2 {
    WebDriver driver = Driver.getDriver();
    Actions actions = new Actions(driver);
    //Faker faker = new Faker();
    String emailS= (new Faker()).internet().emailAddress();
    String passwordS = (new Faker()).internet().password();

//    https://courses.ultimateqa.com/
//    internet sayfasına gidininiz.
//    sign in => create a new account
//1 AssertFalse ile negatif testcase yazımı (checkbox üzerinden)
//1 AssertTrue veya Equal ile pozitif test yazımı.
//1 Tane login test case oluşturulması.
//    Ayrıca bu testlerden negatif testcase'in basamaklarını yani steplerini manuel olarak da yazın lütfen.
//    İlgili testcase in içine yorum satırı olarak en üste ekleyin.
//    Testcaseleri yeni TestNG Framework üzerinde yazınız.

    @BeforeClass
    public void SetUp() {

        driver.get("https://courses.ultimateqa.com/");

        //timeunit nedir bilmiyorum, tabnine teklif etti??
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
    }

    @AfterClass
    public void TearDown() {

        driver.quit();
    }

    @Test
    public void testCase1()  {
        //steps
        //1 sign in'e tıklayın
        //2 checkboxun tıklanmamış olduğunu doğrulayın
        //3 checkboxa tıklayın
        //4 checkboxun tıklanmış olduğunu doğrulayın
        WebElement sign_in = driver.findElement(By.linkText("Sign In"));
        sign_in.click();

        WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        Assert.assertFalse(checkBox.isSelected()); //validation
        checkBox.click();
        Assert.assertTrue(checkBox.isSelected()); //validation
    }

    @Test(dependsOnMethods = "testCase1")
    public void falseLogin() {
       // steps
        // 1 yanlış mailinizi girin
        //2 yanlış şifrenizi girin
        //3 buttona tıklayın
        //4 "Invalid email or password." yazısını görün

        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("kenan123@gmail.com");
        actions.sendKeys(Keys.TAB + "1234").perform();
        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        //click ile submit arasındaki fark nedir??
        button.click();


        WebElement error = driver.findElement(By.xpath("//li[@class='form-error__list-item']"));
        String errorText = error.getText();
        String expectedText = "Invalid email or password.";
        Assert.assertEquals(errorText, expectedText);
    }
    @Test(dependsOnMethods = "falseLogin")
    public void newAccount() {
        //ekranı büyütmezsem yeni hesap açma buttonu çalışmıyor. daha önce büyütütm ama yine küçüldü
        driver.manage().window().fullscreen();
        WebElement createNewAccount = driver.findElement(By.partialLinkText("Create a new account"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        createNewAccount.click();

        WebElement firstName = driver.findElement(By.xpath("//input[@id='user[first_name]']"));
        firstName.sendKeys("Kenan");
        WebElement lastName = driver.findElement(By.xpath("//input[@id='user[last_name]']"));
        lastName.sendKeys("User");


        WebElement email = driver.findElement(By.xpath("//input[@id='user[email]']"));
        email.sendKeys(emailS);
        WebElement password = driver.findElement(By.xpath("//input[@id='user[password]']"));
        password.sendKeys(passwordS);

        WebElement terms = driver.findElement(By.xpath("//input[@id='user[terms]']"));
        terms.click();
        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
        submit.click();

        WebElement loginValidation= driver.findElement(By.className("dropdown__toggle-button"));
        System.out.println(loginValidation.getText());
        Assert.assertEquals(loginValidation.getText(),"Kenan U");
        WebElement logout1= driver.findElement(By.xpath("/html/body/header/div[2]/div/nav/ul/li[2]/button/i"));
        logout1.click();
        WebElement logout2= driver.findElement(By.partialLinkText("Sign Out"));
        logout2.click();
    }
    @Test(dependsOnMethods = "newAccount")
    public void login() {
        WebElement sign_in = driver.findElement(By.linkText("Sign In"));
        sign_in.click();
        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys(emailS);
        actions.sendKeys(Keys.TAB + passwordS).perform();
        WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
        //click ile submit arasındaki fark nedir??
        button.click();
        WebElement loginValidation= driver.findElement(By.className("dropdown__toggle-button"));
        System.out.println(loginValidation.getText());
        Assert.assertEquals(loginValidation.getText(),"Kenan U");

    }

}

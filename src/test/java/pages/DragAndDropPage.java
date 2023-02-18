package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static utilities.Driver.driver;

public class DragAndDropPage {
    public DragAndDropPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Tümünü Kabul Et']")
    public WebElement cookies;

    @FindBy(xpath = "//span[text()='Accept All']")
    public WebElement acceptAllCookiesButton;

    @FindBy(xpath = "(//li[@id='fourth'])[1]")
    public WebElement sourceValue5000plus1;
    @FindBy(xpath = "(//li[@id='fourth'])[2]")
    public WebElement sourceValue5000plus2;

    @FindBy(id="credit2")
    public WebElement bank;
    @FindBy(id="credit1")
    public WebElement sales;

    @FindBy(xpath = "(//li[@class='placeholder'])[1]")
    public WebElement targetInDepitAccount;

    @FindBy(xpath = "(//li[@class='placeholder'])[2]")
    public WebElement targetInDepitAmount;

    @FindBy(xpath = "(//li[@class='placeholder'])[3]")
    public WebElement targetInCreditAccount;

    @FindBy(xpath = "(//li[@class='placeholder'])[4]")
    public WebElement targetInCreditAmount;



    @FindBy (id = "t7")
    public WebElement savedValueInTableDebitSide;
    @FindBy (id = "t8")
    public WebElement savedValueInTableCreditSide;

    @FindBy(linkText = "Perfect!")
    public WebElement perfect;


}



package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utilities.Driver.driver;

public class DownLoadPage {
    public DownLoadPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(linkText = "renamedFile.png")
    public WebElement downLoadButton;
    @FindBy (xpath = "//a[text()='pexels-photo-323705.jpeg']")
    public WebElement downloadButton;


}

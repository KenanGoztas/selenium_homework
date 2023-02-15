package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.impl.HdrDocumentImpl;

import static utilities.Driver.driver;

public class UploadPage {
    public UploadPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "upload")
    public WebElement upload;

}

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TableTestPage {
    public TableTestPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//table")
    public WebElement table;

    @FindBy (xpath = "//table//tbody//tr//td[2]")
    public WebElement tr;

}

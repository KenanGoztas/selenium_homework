package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static utilities.Driver.driver;

public class TablePagesHomework5 {
    public TablePagesHomework5() {
        PageFactory.initElements(driver, this);
    }
    @FindBy (xpath = "//table//tbody//tr[4]//td[5]")
    public WebElement tr1x4x5;
    @FindBy (xpath = "//table[2]//tbody//tr[3]//td[4]")
    public WebElement tr2x3x4x;

    @FindBy (xpath = "//table/thead/tr")
    public WebElement table1;
    @FindBy(xpath = "//table[2]/thead/tr")
    public WebElement table2;



    @FindBy (xpath = "//table[1]/thead/tr/th")
    public List<WebElement> tableList1;

    @FindBy (xpath = "//table[2]/thead/tr/th")
    public List<WebElement> tableList2;
}

package tests;

import org.testng.annotations.Test;
import pages.DownLoadPage;
import utilities.TestBase;

public class DownLoadTest extends TestBase {
    DownLoadPage downLoadPage= new DownLoadPage();
    @Test
    public void testDownLoad(){
        driver.get("https://the-internet.herokuapp.com/download");
        downLoadPage.downLoadButton.click();
    }


}

package tests;

import org.testng.annotations.Test;
import pages.UploadPage;
import pages.UploadPage;
import utilities.TestBase;

public class UploadTest extends TestBase {
    UploadPage uploadPage= new UploadPage();
    @Test
    public void uploadTest() throws Exception {
        driver.get("https://the-internet.herokuapp.com/upload");
        uploadPage.upload.click();

    }
}

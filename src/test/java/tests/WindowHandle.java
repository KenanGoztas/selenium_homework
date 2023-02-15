package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowHandle extends TestBase {
    @Test
    public void testWindowHandle() throws InterruptedException {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open('https://www.google.com', '_blank');");
        Driver.wait(4);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open('https://www.amazon.com', '_blank');");
        Driver.wait(4);
        Set<String> handles = Driver.getDriver().getWindowHandles();
        Driver.getDriver().switchTo().window(handles.toArray()[1].toString());
        Driver.wait(4);

        List<String> handlesList = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(handlesList.get(1));
        for (String ha : handlesList) {
            System.out.println(ha);
        }

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("http://google.com");
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("http://google.com");

        // Opens a new tab and switches to new tab
        driver.switchTo().newWindow(WindowType.TAB);
        // Opens a new window and switches to new window
        driver.switchTo().newWindow(WindowType.WINDOW);
        //Switch back to the old tab or window
        driver.switchTo().window(driver.getWindowHandle());







    }

}

package tests;

import io.cucumber.java.eo.Do;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DragAndDropPage;
import utilities.Driver;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class DragAndDropTest extends TestBase {
    DragAndDropPage dragDrop = new DragAndDropPage();

    //    Soru 1:
//    Kullanıcı https://demo.guru99.com/test/drag_drop.html  sayfasına gider
//    Kullanıcı BANK objesini Debit Side Sol Account kutusuna taşıyarak yerleştirir.
//    Kullanıcı SALES objesini Credit Side Sol Account kutusuna taşıyarak
//    yerleştirir.
//            Kullanıcı 5000 objesini Debit Side Sağ Account kutusuna taşıyarak
//    yerleştirir.
//            Kullanıcı 5000 objesini Credit Side Sağ Account kutusuna taşıyarak
//    yerleştirir.
//    Aşağıda çıkan Ek Tablo içerisinden 5000 objeleri SoftAssert ile Valide
//    edilir.
//    Doğru yerleştirme sonucu tablo altında ortaya çıkan Perfect yazısı Hard
//    Assert ile teyit edilir.
//    Soru 2:
//    https://the-internet.herokuapp.com/tables  sayfasına gidiniz
//            1.Tablonun 4 üncü sütunudaki tüm değerleri bir listeye alınız. (Başına $ işareti
//    olmadan double değer  olarak.)
//    Değerler içinden 50.00’den fazla olanları ayrı bir listeye ekleyiniz.

    @Test
    public void testDragAndDrop() throws Exception {
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        //driver.manage().deleteAllCookies();
        driver.switchTo().frame("gdpr-consent-notice");
        dragDrop.cookies.click();
        driver.manage().window().fullscreen();
        Driver.wait(3);

        actions.dragAndDrop(allPages.dragAndDropPage.bank,
                        allPages.dragAndDropPage.targetInDepitAccount).
                dragAndDrop(allPages.dragAndDropPage.sourceValue5000plus1,
                        allPages.dragAndDropPage.targetInDepitAmount).
                dragAndDrop(allPages.dragAndDropPage.sales,
                        allPages.dragAndDropPage.targetInCreditAccount).
                dragAndDrop(allPages.dragAndDropPage.sourceValue5000plus2,
                        allPages.dragAndDropPage.targetInCreditAmount).build().perform();
        Driver.wait(3);
//
//
//
//        //actions.clickAndHold(dragDrop).moveToElement(element).build().perform();
//
        SoftAssert softAssert = new SoftAssert();
        String expectedValue1 = "5000";
        String actualValue1 = allPages.dragAndDropPage.savedValueInTableDebitSide.getText();
        softAssert.assertEquals(actualValue1, expectedValue1);
        String expectedValue2 = "5000";
        String actualValue2 = allPages.dragAndDropPage.savedValueInTableCreditSide.getText();
        softAssert.assertEquals(actualValue2, expectedValue2);
        String expectedValue3 = "Perfect!";
        Assert.assertEquals(allPages.dragAndDropPage.perfect.getText(), expectedValue3);

    }


    @Test//(dependsOnMethods = "testDragAndDrop")
    public void testOdev6() {
        driver.get("https://the-internet.herokuapp.com/tables");
        //yeni bir metod yazdım, metod ile doğrudan elementleri çağırıyorum..
        //emin olmak için yazdırdım.
        System.out.println(reusableMethods.findWebelementOfTableCell(1, 1, 4).getText());
        System.out.println(reusableMethods.findWebelementOfTableCell(1, 2, 4).getText());
        System.out.println(reusableMethods.findWebelementOfTableCell(1, 3, 4).getText());
        System.out.println(reusableMethods.findWebelementOfTableCell(1, 4, 4).getText());

        //Weblelementteki texti aldım ve başındaki dolar işaresini silip Stringe atadım.
        String row1 = reusableMethods.findWebelementOfTableCell(1, 1, 4).getText().replace("$", "");
        String row2 = reusableMethods.findWebelementOfTableCell(1, 2, 4).getText().replace("$", "");
        String row3 = reusableMethods.findWebelementOfTableCell(1, 3, 4).getText().replace("$", "");
        String row4 = reusableMethods.findWebelementOfTableCell(1, 4, 4).getText().replace("$", "");

        //Stringleri double'a çevirdim.
        double drow1 = Double.parseDouble(row1);
        double drow2 = Double.parseDouble(row2);
        double drow3 = Double.parseDouble(row3);
        double drow4 = Double.parseDouble(row4);

        //double sayıları listeye ekledim
        List<Double> duesDolars = new ArrayList<>();
        duesDolars.add(drow1);
        duesDolars.add(drow2);
        duesDolars.add(drow3);
        duesDolars.add(drow4);

        //listenin içindeki 50'den büyük sayıları ayrı bir listeye ekledim
        List<Double> duesDolars2 = new ArrayList<>();
        for (Double d : duesDolars) {
            if (d > 50)
                duesDolars2.add(d);
        }

        double expected=100.0;
        //foreach döngüsü ile istenen sayıyı bulup kontrol ettim..
        //burada if yapmadan doğrudan assert nasıl yapılablir????
        for (Double d : duesDolars2) {
            System.out.println("d = " +d);
            if (d == 100.0)
                Assert.assertEquals(d, expected);
        }

    }
}

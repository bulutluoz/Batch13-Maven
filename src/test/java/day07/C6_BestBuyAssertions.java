package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C6_BestBuyAssertions {

    /*
    1) Bir class oluşturun: BestBuyAssertions
    2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
		○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
		○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
		○ logoTest => BestBuy logosunun görüntülendigini test edin
		○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
     */
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){
        driver.get("https://www.bestbuy.com/");
        //  Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin

        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);

        // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin

        String unexpectedWord="Rest";
        String actualTitle=driver.getTitle();


        //    actualTitle.contains(unexpectedWord) ====> bu kelime title'da olmadigi icin false dener

        System.out.println(driver.getTitle());
        Assert.assertFalse(actualTitle.contains(unexpectedWord));

        //  title'nin Best kelimesi icerdigini test edin

        String istenenKelime= "Best";
        Assert.assertTrue(actualTitle.contains(istenenKelime));
        System.out.println("test sonuna kadar calisti");

        // Assert failed oldugunda Kodun calismasini durdurur

        // ○ logoTest => BestBuy logosunun görüntülendigini test edin

        WebElement logo=driver.findElement(By.xpath("(// img[@class='logo'])[1]"));

        Assert.assertTrue(logo.isDisplayed());

        //FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        //WebElement fransizcaLinki=driver.findElement(By.xpath("// button[@lang='fr']"));
        WebElement fransizcaLinki=driver.findElement(By.cssSelector("button[lang='fr']"));
        Assert.assertTrue(fransizcaLinki.isDisplayed());

    }



}

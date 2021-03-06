package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C2_BeforeAfterAnnotations {

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println("setup calisti");
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
        System.out.println("teardown calisti");
    }

    @Test
    public void test01()  {
        driver.get("https://techproeducation.com");
        System.out.println("1.metot calisti");
    }

    @Test
    public void test02()  {
        driver.get("https://www.amazon.com");
        System.out.println("2.metot calisti");
    }

    @Test
    public void test03()  {
        driver.get("https://www.facebook.com");
        System.out.println("3.metot calisti");
    }



}

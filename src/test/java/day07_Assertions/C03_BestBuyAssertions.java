package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BestBuyAssertions {

    WebDriver driver;

    @Before
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01(){
    //1)  Bir class oluşturun: BestBuy Assertions
    //2)    //https://www.bestbuy.com/ A dresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
      driver.get("https://www.bestbuy.com/");
    //Sayfa URL’inin https://www.bestbuy.com/ com/‘a esit oldugunu test edin
      String actUrl=driver.getCurrentUrl();
      String expUrl="https://www.bestbuy.com/";
      Assert.assertEquals(expUrl,actUrl);
    //titleTest => Sayfa başlığının “ Rest” içer me diğini(contains) test edin
      String actTitle=driver.getTitle();
      String istenmeyenKlm="Rest";
      Assert.assertFalse(actTitle.equals(istenmeyenKlm));
    //logoTest => BestBuy logosunun görüntülen digini test edin
      WebElement logo=driver.findElement(By.xpath("//img[@alt='Best Buy Logo']"));
      Assert.assertTrue(logo.isDisplayed());
    //Francais LinkTest => Fransizca Linkin görüntüle n diğini test edin
      WebElement frn=driver.findElement(By.xpath("//button[@lang='fr']"));
      Assert.assertTrue(frn.isDisplayed());
    }





    @After
    public void teardown(){
    driver.close();
    }



}

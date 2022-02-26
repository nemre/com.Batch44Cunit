package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BestBuyAyriTestler {

    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    //2)//https://www.bestbuy.com/ A dresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
        driver.get("https://www.bestbuy.com/");

    }

    @Test
    public void UrlTest(){
        //Sayfa URL’inin https://www.bestbuy.com/ com/‘a esit oldugunu test edin
        String actUrl=driver.getCurrentUrl();
        String expUrl="https://www.bestbuy.com/";
        Assert.assertEquals(expUrl,actUrl);
    }

    @Test
    public void TitleTest(){
        //titleTest => Sayfa başlığının “ Rest” içer me diğini(contains) test edin
        String actTitle=driver.getTitle();
        String istenmeyenKlm="Rest";
        Assert.assertFalse(actTitle.equals(istenmeyenKlm));

    }

    @Test
    public void LogoTest(){
        //logoTest => BestBuy logosunun görüntülen digini test edin
        WebElement logo=driver.findElement(By.xpath("//img[@alt='Best Buy Logo']"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void FrancaisTest(){
        //Francais LinkTest => Fransizca Linkin görüntüle n diğini test edin
        WebElement frn=driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue(frn.isDisplayed());
    }







    @AfterClass
    public static void teardown(){
        //driver.close();
    }

}

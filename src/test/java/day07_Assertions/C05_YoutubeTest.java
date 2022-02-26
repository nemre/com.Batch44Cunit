package day07_Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_YoutubeTest {
    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    //    ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
    //    ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //     ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //    ○ wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin
    //Collapse
        static WebDriver driver;

        @BeforeClass
        public static void setup(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            driver.get("https://www.youtube.com");
        }

        @Test
        public void TitleTest(){
         //○ titleTest=> Sayfa başlığının “YouTube” oldugunu test edin
        String actlTitle=driver.getTitle();
        String exptTitle="YouTube";
        Assert.assertEquals(exptTitle,actlTitle);
        }
        @Test
        public void imageTest(){
        //○ imageTest=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
            WebElement logo=driver.findElement(By.xpath("(//yt-icon[@class='style-scope ytd-logo'])[1]"));
            Assert.assertTrue(logo.isDisplayed());
        }
        @Test
        public void SearchBoxTest(){
        //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
            WebElement aramakutusu=driver.findElement(By.xpath("(//div[@class='ytd-searchbox-spt '])[3]"));
            Assert.assertTrue(aramakutusu.isEnabled());
        }
        @Test
        public void wrongTitleTest() throws InterruptedException {
        // ○ wrongTitleTest=> Sayfa basliginin “youtube” olmadigini dogrulayin
        //Collapse
            String actlTitle=driver.getTitle();
            String notTitle="YouTube";
        Assert.assertNotEquals(notTitle,actlTitle);
        Thread.sleep(3000);
        }


        @AfterClass
        public static void teardown(){
           driver.close();
        }




}

package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_TekSayfadaFarkliTestler {

    static WebDriver driver;
    static WebElement aramakutusu;
   static WebElement sonucyazsiElementi;

   @Test
    public void test1(){
        //amazonda nutelle ara. sonuc yazısının nutella içerdiğini test et.
    aramakutusu.sendKeys("nutella"+ Keys.ENTER);
       sonucyazsiElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
    String actualNutella=sonucyazsiElementi.getText();
    String arananKelime="nutella";
    if (actualNutella.contains(arananKelime)){
        System.out.println("1. test pass");
    }else{
        System.out.println("1. test failed");
    }

    }

    @Test
    public void test2(){
        //amazonda java ara. sonuc yazısının java içerdiğini test et.
        aramakutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramakutusu.clear();
        aramakutusu.sendKeys("java"+ Keys.ENTER);
        sonucyazsiElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualNutella=sonucyazsiElementi.getText();
        String arananKelime="java";
        if (actualNutella.contains(arananKelime)){
            System.out.println("2. test pass");
        }else{
            System.out.println("2. test failed");
        }

    }

   @Test
   public void test3(){
       //amazonda ali ara. sonuc yazısının ali içerdiğini test et.
       aramakutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
       aramakutusu.clear();
       aramakutusu.sendKeys("ali"+ Keys.ENTER);
       sonucyazsiElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
       String actualNutella=sonucyazsiElementi.getText();
       String arananKelime="ali";
       if (actualNutella.contains(arananKelime)){
           System.out.println("3. test pass");
       }else{
           System.out.println("3. test failed");
       }

    }



    @BeforeClass
    public static void ayarlar(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
        aramakutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

   }
    @AfterClass
    public static void ortaligiToparla(){

    }

}

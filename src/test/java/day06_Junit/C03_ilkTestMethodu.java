package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ilkTestMethodu {

    WebDriver driver;

    @Test
    public void test01(){
        //amazona git baslığı test et
        driver.get("https://www.amazon.com");
        String actualTitle=driver.getTitle();
        String arananTitle="amazon";
        if (actualTitle.contains(arananTitle)){
            System.out.println("1. test pass");
        }else{
            System.out.println("1. test failed");
        }
    }


    @Test
    public void test02(){
        //google basligi test et
        driver.get("https://www.google.com");
        String actualTitle=driver.getTitle();
        String arananTitle="google";
        if (actualTitle.contains(arananTitle)){
            System.out.println("2. test pass");
        }else{
            System.out.println("2. test failed");
        }

    }

    @Before
    public void ayarlar(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void ortaligiToparla(){

    }

}

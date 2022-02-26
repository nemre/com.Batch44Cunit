package day06_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        //2. Username kutusuna “standard_user” yazdirin
        WebElement username=driver.findElement(By.xpath("//input[@class='input_error form_input']"));
        username.sendKeys("standard_user");
        //3. Password kutusuna “secret_sauce” yazdirin
        //4. Login tusuna basin
        WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce" + Keys.ENTER);

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkurun=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        String ilkurunismi=ilkurun.getText();
        ilkurun.click();
        //6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']")).click();
        //7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement sepetdurumElementi=driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        String setepdurum=sepetdurumElementi.getText();
        if (setepdurum.contains(ilkurunismi)){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }
        //9. Sayfayi kapatin
        driver.close();
    }
}

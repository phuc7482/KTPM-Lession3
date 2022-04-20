package base;

import net.bytebuddy.dynamic.DynamicType;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTests {
    public WebDriver driver;
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[contains(text(), 'Start')]")).click();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);


        System.out.println(driver.findElement(By.id("finish")).getText());
        driver.quit();
//        System.out.println(driver.getTitle());

    }

    public static void main(String[] args){
        BaseTests test = new BaseTests();
        test.setUp();
    }
}

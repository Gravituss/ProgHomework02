package ua.kiev.prog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;


public class App
{

    public static void main( String[] args )
    {
        System.setProperty("webdriver.gecko.driver", "C:\\pr\\gecko\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("http://google.com");
        WebElement searchField = driver.findElement(By.id("lst-ib"));

        searchField.sendKeys("iPhone 7");
        searchField.submit();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement rozetkaLink = driver.findElement(By.xpath("//*[contains(@href,'rozetka.com.ua')]"));
        rozetkaLink.click();

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.urlContains("rozetka.com.ua"));

        Assert.assertTrue(driver.getCurrentUrl().contains("rozetka.com.ua"));

    }
}

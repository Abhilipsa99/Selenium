import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Assignment2 {
    public static void main (String[] args ) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice");
        driver.findElement(By.name("name")).sendKeys("Rahul");
//      driver.findElement(By.cssSelector("input.form-control.ng-dirty.ng-valid.ng-touched")).sendKeys("contact@rahulshettyacademy.com");
        driver.findElement(By.name("email")).sendKeys("contact@rahulshettyacademy.com");
        driver.findElement(By.cssSelector("input#exampleInputPassword1")).sendKeys("rahul@98279");
        driver.findElement(By.xpath("//input[@id='exampleCheck1']")).click();
        WebElement genderSelection = driver.findElement(By.id("exampleFormControlSelect1"));
        Select gender = new Select(genderSelection);
        gender.selectByVisibleText("Male");
        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.name("bday")).sendKeys("08/02/2000");
        driver.findElement(By.cssSelector(".btn.btn-success")).click();
        System.out.println(driver.findElement(By.cssSelector("div[class*='alert-success']")).getText());
        driver.close();

    }
}

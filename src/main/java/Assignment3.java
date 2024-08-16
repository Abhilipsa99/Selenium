import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Assignment3 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.cssSelector("input#username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("learning");
        WebElement dropDown = driver.findElement(By.cssSelector("select.form-control"));
        Select selectOption = new Select(dropDown);
        selectOption.selectByVisibleText("Consultant");
        driver.findElement(By.cssSelector("input#terms")).click();
        driver.findElement(By.xpath("//*[@id='login-form']/div[4]/div/label[2]/span[2]")).click();
        WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(3));
        w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='okayBtn']")));
        driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
        driver.findElement(By.id("signInBtn")).click();
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(3));
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-card-list[@class='row']")));
        List<WebElement> productList = driver.findElements(By.xpath("//button[@class='btn btn-info']"));
        for(int i=0; i<productList.size(); i++){
            productList.get(i).click();
        }
        driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
    }
}

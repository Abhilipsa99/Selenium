import com.sun.jdi.request.ThreadDeathRequest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Assignment8 {
    public static void main (String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("autocomplete")).sendKeys("uni");
        Thread.sleep(3000);
        Actions a = new Actions(driver);
        a.keyDown(Keys.DOWN);
        a.keyDown(Keys.DOWN);
        a.keyDown(Keys.DOWN);
        a.keyDown(Keys.DOWN);
        a.keyDown(Keys.DOWN);
        a.keyDown(Keys.DOWN);
    }
}

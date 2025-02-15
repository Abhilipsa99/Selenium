import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {

    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        Actions a = new Actions(driver);
        WebElement move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));

        //Move to specific element
        a.moveToElement(move).contextClick().build().perform(); //build --> means ready to execute, and perform means it will execute

        a.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
    }
}

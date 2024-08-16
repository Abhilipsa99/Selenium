import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Nested Frames")).click();
        int numOfFrames = driver.findElements(By.tagName("frame")).size();
        driver.switchTo().frame(0);
        int numOfFramesInsideFrame = driver.findElements(By.tagName("frame")).size();
        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.cssSelector("div#content")).getText());
    }
}

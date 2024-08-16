import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWait<W extends SearchContext> {

    public FluentWait(W driver) {
    }

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("[id='start'] button")).click();

//        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//                .withTimeout(Duration.ofSeconds(30L))
//                .pollingEvery(Duration.ofSeconds(3L))
//                .ignoring(NoSuchElementException.class);
//        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
//            @Override
//            public WebElement apply(WebDriver webDriver) {
//                if (driver.findElement(By.cssSelector("[id = 'Finish'] h4")).isDisplayed()) {
//                    return driver.findElement(By.cssSelector("[id = 'Finish'] h4"));
//                } else {
//                    return null;
//                }     }
//        });
//        System.out.println(driver.findElement(By.cssSelector("[id = 'Finish'] h4")).getText());
    }
}

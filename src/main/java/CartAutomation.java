import jdk.jfr.Timespan;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CartAutomation {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //it will wait for maximum 5 secs before failing
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com//seleniumPractise/");
        Thread.sleep(1000);
        String[] productNameRequired = {"Cucumber", "Tomato", "Carrot", "Mushroom", "Potato"};
        addItems(driver, productNameRequired);
        driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.className("promocode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//button[@class='promoBtn']")).click();

        //Explicit wait
        //WebDriverWait --> Continously checks or monitors the dom
        //Fluent wait --> it checks the dom at regular intervals of time (polling is given)

        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());


        //Implicit wait targets globally but explicit wait can be applied to specific elements
        //Thread.sleep --> used to halt execution for specific period of time (not a part of webdriver instead part of java)
        //if Thread.sleep is 3 sec then execution is halt for whole 3 secs
        //cons of implicit wait --> it hides oerformance issues
    }

    public static void addItems(WebDriver driver, String[] productNameRequired){
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        int j = 0;
        for (int i = 0; i < products.size(); i++) {
            String productName = products.get(i).getText();
            String[] actualProductText = productName.split("-");
            String formattedProductText = actualProductText[0].trim();
            List veggies = Arrays.asList(productNameRequired);
            if (veggies.contains(formattedProductText)) {
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if(j== productNameRequired.length){
                    break;
                }
            }

        }
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class calendar {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("https://www.path2usa.com/travel-companions");
        //August 23
        driver.findElement(By.id("form-field-travel_comp_date"));
        List<WebElement> dates = driver.findElements(By.className("day"));
        int count = driver.findElements(By.className("day")).size();
        for(int i=0; i<count; i++){
            String text = driver.findElements(By.className("day")).get(i).getText();
            if(text.equalsIgnoreCase("28")){
                driver.findElements(By.className("day")).get(i).click();
                break;
            }
        }
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Assignment7 {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        int numOfRows = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr")).size();
        System.out.println("Number of Rows : "+numOfRows);
        int numOfColumns = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr[1]/th")).size();
        System.out.println("Number of Columns : "+numOfColumns);

        List<WebElement> secondRowContent = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr[3]/td"));
        for(int i=0; i<secondRowContent.size(); i++){
            System.out.println(secondRowContent.get(i).getText());
        }
    }
}

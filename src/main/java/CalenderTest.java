import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class CalenderTest {
    public static void main(String[] args){
        String monthNumber = "6";
        String date = "15";
        String year = "2027";
        String[] expectedList = {monthNumber,date,year};

        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
        List<WebElement> months = driver.findElements(By.cssSelector(".react-calendar__year-view__months__month"));
        int monthSize = months.size();
        for(int i=0; i<monthSize; i++){
            if(i==Integer.parseInt(monthNumber)-1){
                months.get(i).click();
                break;
            }
        }
        driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();

        List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
        for(int j=0; j< actualList.size(); j++){
            System.out.println(actualList.get(j).getAttribute("value"));
            Assert.assertEquals(actualList.get(j).getAttribute("value"),expectedList[j]);
        }
    }
}

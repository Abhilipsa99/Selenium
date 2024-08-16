import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class WebTableWithoutUsingStream {
    public static void main(String[] args){
        String str = "Potato";
        //System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com//seleniumPractise/#/offers");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//tr/th[1]")).click();
        List<WebElement> elementList;
        boolean found = false;
        do{
            elementList = driver.findElements(By.xpath("//tr/td[1]"));
            for(int i=0; i<elementList.size(); i++){
                if(elementList.get(i).getText().equalsIgnoreCase(str)){
                    found = true;
                    Assert.assertTrue(found);
                    System.out.println(elementList.get(i).findElement(By.xpath("following-sibling::td[1]")).getText());
                }
            }
            if(!found){
                driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
            }
        }while(!found);

    }
}

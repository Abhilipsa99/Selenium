import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Scanner;

public class Assignment6 {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement checkBoxExample = driver.findElement(By.xpath("//div[@class='block large-row-spacer']/div[4]"));
        int options = checkBoxExample.findElements(By.tagName("label")).size();
        System.out.println(options);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the option to be selected ");
        int option = sc.nextInt();
        String optionText = "";
        for(int i=0; i<options; i++){
            if(i==option){
                WebElement optionValue = checkBoxExample.findElements(By.tagName("label")).get(i);
                optionValue.findElement(By.tagName("input")).click();
                optionText = optionValue.getText();
            }
        }
        System.out.println(optionText);
        WebElement staticDropDown = driver.findElement(By.id("dropdown-class-example"));
        Select dropdown = new Select(staticDropDown);
        dropdown.selectByVisibleText(optionText);
        driver.findElement(By.cssSelector("input#name")).sendKeys(optionText);
        driver.findElement(By.cssSelector("input#alertbtn")).click();
        String alertText = driver.switchTo().alert().getText();
        if(alertText.contains(optionText)){
            Assert.assertTrue(true);
        }
    }

}

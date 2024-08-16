import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.dom.model.ShapeOutsideInfo;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;

public class Locators {

    public static void main(String [] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //globally applicable for each and every step
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("abhilipsa");
        driver.findElement(By.name("inputPassword")).sendKeys("abhilipsa@864");
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/form/button")).click();

        /* CSS SELECTOR --> tagName.className , if id is known then CSS Selector is tagName#id
        *  Generic syntax - tagName[attribute = 'value'] */

        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

        driver.findElement(By.linkText("Forgot your password?")).click();

        // X-PATH generic syntax --> //TagName[@attribute='value']

        Thread.sleep(1000);   // Waiting for objects to show on page
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john421mail@gmail.com");
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
        driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("9678544388");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        String passwordText = driver.findElement(By.cssSelector("form p")).getText();
        System.out.println(passwordText);

        String [] passwordArr = passwordText.split("'");
        System.out.println(Arrays.toString(passwordArr));
        String password = passwordArr[1].split("'")[0];

        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();

        String name = "Abhilipsa";
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
        driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");

        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Log Out']")).click();
        //driver.close();
    }

}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumIntro {

    public static void main(String [] args) throws InterruptedException {

        //invoking Browser
        //WebDriver --> Interface (Group of related methods with empty bodies i.e Abstract methods)
        // Classes implements the methods present in interface

       // ChromeDriver driver = new ChromeDriver(); //ChromeDriver contains methods which is used to automate in chrome browser
                                                    // with this we can access webDriver + chromeDriver (internal) methods
        System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        //driver.wait(300);
        driver.close();

        //Locators tells where HTML Components are located
    }
}

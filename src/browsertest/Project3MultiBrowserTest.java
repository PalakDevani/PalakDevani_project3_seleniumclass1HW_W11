package browsertest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Project3MultiBrowserTest {
    static String browser = "chrome";
    static String baseUrl = "http://the-internet.herokuapp.com/login";
    static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("chrome")) // to avoid upper or lowercase sensitivity "equalsIgnoreCase"
        {
            System.setProperty("webdriver.chrome.drivers", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();

        }
        driver.get(baseUrl); // launch baseUrl

        String title = driver.getTitle(); //3. print the title of the page in console
        System.out.println("Page title: " + title);
        System.out.println("Current URL: " + driver.getCurrentUrl()); //4. print the Current URl
        System.out.println("Page source: " + driver.getPageSource()); //5. print the page source

        // enter the email to email field element
        WebElement emailField = driver.findElement(By.id("username"));
        emailField.sendKeys(("tomsmith"));

        // enter the password to password field element
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("SuperSecretPassword!");


        driver.quit(); // close the browser

    }
}
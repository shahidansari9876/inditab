package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    
    public WebDriver driver;

    //launch browser and navigate to the website before each test
    @BeforeMethod
    public void launch() {

         // Create ChromeOptions instance
        ChromeOptions options = new ChromeOptions();

        // Add headless mode argument
        options.addArguments("--headless");

        // Optional: add other arguments to make it work smoother
        options.addArguments("--disable-gpu"); // For Windows systems
        options.addArguments("--window-size=1920,1080"); //for full screen
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        // driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }

    //close browser after each test
    @AfterMethod
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}

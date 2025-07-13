package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class searchResult {
    private WebDriver driver;
    
     public searchResult(WebDriver driver) {
        this.driver = driver;
    }
   
    private By ProductPage= By.xpath("//a[contains(text(),' Products')]");
    private By searchBox = By.id("search_product");
    private By searchButton = By.id("submit_search");
    private By totalProduct= By.xpath("//img[@alt=\"ecommerce website products\"]/following-sibling::p");




    public void searchProduct(String productName) {
        driver.findElement(ProductPage).click();
        driver.findElement(searchBox).sendKeys(productName);
        driver.findElement(searchButton).click();
        
        //list of products fetch
        List<WebElement> searchedPrducts = driver.findElements(totalProduct);
       
        // Verify each product's name contains "t-shirt"
       for (WebElement product : searchedPrducts) {
           String productNames = product.getText();
           System.out.println("Product found: " + productNames);

           Assert.assertTrue(productNames.toLowerCase().contains("shirt"), 
               "Product name does not match expected: " + productName);
       }

    }
}



package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class CartPage {
    private WebDriver driver;

     public CartPage(WebDriver driver) {
        this.driver = driver;
    }


    By firstProductAddToCart = By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]");
    By viewCartBtn = By.xpath("//u[contains(text(),'View Cart')]");

    By productName = By.xpath("//td[@class='cart_description']/h4/a");
    By productPrice = By.xpath("//td[@class='cart_price']/p");

    public void addFirstProductToCart() {
        new Actions(driver).moveToElement(driver.findElement(firstProductAddToCart)).perform();
        // Click on the first product's "Add to Cart" button
        driver.findElement(firstProductAddToCart).click();
        System.out.println("First product added to cart successfully.");
    }

    public void clickViewCart() {
        driver.findElement(viewCartBtn).click();
    }

    //CART PAGE ITEM VALIDATION
    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public String getProductPrice() {
        return driver.findElement(productPrice).getText();
    }
    
}

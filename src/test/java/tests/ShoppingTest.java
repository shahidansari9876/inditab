package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.searchResult;

public class ShoppingTest extends BaseTest {

    @Test
    public void searchAndAddProductToCart() throws InterruptedException {
        // Create page object
        searchResult searchPage = new searchResult(driver);
        CartPage cartPage = new CartPage(driver);

        String productToSearch = "tshirt";

        // Step 1: Search for product
        searchPage.searchProduct(productToSearch);

        // Optional: Add wait if necessary for results to load (not best practice, replace with explicit waits)
        Thread.sleep(2000);

        // Step 2: Add first product to cart
        cartPage.addFirstProductToCart();

        Thread.sleep(2000); // wait for modal to appear (replace with explicit wait in real tests)

        // Step 3: Click on View Cart
        cartPage.clickViewCart();

        Thread.sleep(2000); // wait for cart page to load

        // Step 4: Verify product name and price
        String actualProductName = cartPage.getProductName();
        String actualProductPrice = cartPage.getProductPrice();

        // Print product details
        System.out.println("Product Name: " + actualProductName);
        System.out.println("Product Price: " + actualProductPrice);

        //actual and expected values as per product result in to cart
        Assert.assertTrue(actualProductName.toLowerCase().contains("tshirt"), "Product name validation failed!");
        Assert.assertNotNull(actualProductPrice, "Product price should not be null");
    }
}

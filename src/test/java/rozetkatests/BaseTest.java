package rozetkatests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import rozetkapages.CartPopup;
import rozetkapages.HomePage;
import rozetkapages.ProductGroupPage;
import rozetkapages.ProductPage;
import utils.DriverManager;

public abstract class BaseTest {
    @BeforeMethod
    public void setUp() {
        DriverManager.setDriver();
        DriverManager.getURL();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.closeBrowser();
    }

    public HomePage getHomePage() {
        return new HomePage(DriverManager.getDriver());
    }

    public ProductPage getProductPage() {
        return new ProductPage(DriverManager.getDriver());
    }

    public CartPopup getCartPopup() {
        return new CartPopup(DriverManager.getDriver());
    }

    public ProductGroupPage getProductGroupPage() {
        return new ProductGroupPage(DriverManager.getDriver());
    }
}
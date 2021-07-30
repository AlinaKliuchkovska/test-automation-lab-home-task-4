package rozetkapages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class CartPopup extends BasePage {
    public CartPopup(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='cart-receipt__sum-price']")
    private WebElement totalSum;

    @FindBy(xpath = "//*[text() = ' Корзина ']")
    private WebElement cartPopup;

    @FindBy(css = ".cart-list__item")
    private List<WebElement> itemsInCartList;

    public int getNumberOfItemsInCart() {
        waitForVisibilityOfElement(cartPopup);
        waitForVisibilityOfElement(itemsInCartList.get(0));
        return itemsInCartList.size();
    }

    public int getTotalSum() {
        return Integer.parseInt(totalSum.getText().replace(" ₴", ""));
    }
}
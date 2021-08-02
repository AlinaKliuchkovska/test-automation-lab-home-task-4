package rozetkapages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.Keys.ENTER;


public class ProductGroupPage extends BasePage {
    public ProductGroupPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//select[contains(@class, 'ng-star-inserted')]")
    private WebElement sortingTypeSelect;

    @FindBy(xpath = "//input[@id='Готов к отправке']/ancestor::li")
    private WebElement readyToShipCheckbox;

    @FindBy(xpath = "//button[@class='button button_type_link sidebar-alphabet__toggle']//preceding::input[@class='sidebar-search__input ng-untouched ng-pristine ng-valid']")
    private WebElement brandSearchInput;

    @FindBy(css = ".goods-tile__heading")
    private WebElement firstProduct;

    public ProductGroupPage enterBrandToBrandSearchInput(String brandName) {
        waitForVisibilityOfElement(brandSearchInput);
        brandSearchInput.sendKeys(brandName, ENTER);
        return this;
    }

    public ProductGroupPage setSortingType(String sortingType) {
        waitForElementToBeClickable(sortingTypeSelect);
        Select sortingTypeDropdown = new Select(sortingTypeSelect);
        sortingTypeDropdown.selectByVisibleText(sortingType);
        return this;
    }

    public ProductGroupPage clickOnFirstProduct() {
        waitForElementToBeClickable(firstProduct);
        firstProduct.click();
        return this;
    }

    public ProductGroupPage checkReadyToShipCheckbox() {
        try {
            waitForElementToBeClickable(readyToShipCheckbox);
            readyToShipCheckbox.click();
        } catch (TimeoutException e) {
            System.out.println("Ready to ship checkbox is not enabled");
        }
        return this;
    }

    public ProductGroupPage checkBrandCheckbox(String brandName){
        waitForElementToBeClickable(driver.findElement(By.xpath(String.format("//input[@id='%s']//parent::a", brandName))));
        driver.findElement(By.xpath(String.format("//input[@id='%s']//parent::a", brandName))).click();
        return this;
    }
}
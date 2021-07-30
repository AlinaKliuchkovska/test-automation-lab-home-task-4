package rozetkapages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.Keys.ENTER;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "search")
    private WebElement searchInput;

    public void enterKeyWordToSearchInput(String keyWord) {
        waitForVisibilityOfElement(searchInput);
        searchInput.sendKeys(keyWord, ENTER);
    }
}
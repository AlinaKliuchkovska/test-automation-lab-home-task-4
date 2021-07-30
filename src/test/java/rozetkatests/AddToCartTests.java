package rozetkatests;

import model.RozetkaFilter;
import model.RozetkaFilters;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.XMLToObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddToCartTests extends BaseTest {
    private static final int EXPECTED_NUMBER_OF_ITEMS_IN_CART = 1;
    private static final int MAX_SUM = 500000;

    @DataProvider(name = "filter", parallel = true)
    public Object[][] filter() {
        RozetkaFilters rozetkaFilters = XMLToObject.readXMLToObject();
        RozetkaFilter[][] rozetkaFilterArray = new RozetkaFilter[rozetkaFilters.getRozetkaFilters().size()][1];
        for (int i = 0; i < rozetkaFilters.getRozetkaFilters().size(); i++) {
            rozetkaFilterArray[i][0] = rozetkaFilters.getRozetkaFilters().get(i);
        }
        return rozetkaFilterArray;
    }

    @Test(dataProvider = "filter", threadPoolSize = 3)
    public void checkThatAddingToCartWorksCorrect(RozetkaFilter rozetkaFilter) throws InterruptedException {
        getHomePage().enterKeyWordToSearchInput(rozetkaFilter.getGroup());
        getProductGroupPage().enterBrandToBrandSearchInput(rozetkaFilter.getBrandName())
                .checkBrandCheckbox(rozetkaFilter.getBrandName()).checkReadyToShipCheckbox()
                .setSortingType(rozetkaFilter.getSortingType()).clickOnFirstProduct();
        getProductPage().clickOnAddToCartButton();

        assertEquals(EXPECTED_NUMBER_OF_ITEMS_IN_CART, getCartPopup().getNumberOfItemsInCart());
        assertTrue(getCartPopup().getTotalSum() < MAX_SUM);
    }
}
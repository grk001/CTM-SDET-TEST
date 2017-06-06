package regression.comparethemarket.test.yoursupplier;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import regression.comparethemarket.page.yoursupplier.YourSupplierPage;
import regression.comparethemarket.test.BaseTest;

import static org.junit.Assert.*;


public class YourSupplierTest extends BaseTest {

    public YourSupplierPage yourSupplier;

    @Override
    public void setupPage(WebDriver driver) {
        this.yourSupplier = new YourSupplierPage(driver);
    }

    @Override
    public void tearDownPage() {

    }

    private void clickPostCodeButtonAndPerformAssertions() {
        yourSupplier.clickPostCodeButton();
        yourSupplier.waitForPostcodeValidationMessageToBeDisplayed();
        assertEquals("Your postcode has not been " +
                        "recognised, please check you have entered it correctly " +
                        "and if you still need help call the switching support team on 0800 093 6831",
                yourSupplier.getValidationMessageTextForPostcodeTextField());
        assertFalse(yourSupplier.isNextButtonClickable());
    }

    /**
     * This test will check whether a validation message
     * if an invalid postcode is entered
     */

    @Test
    public void enterInValidPostcodeAndCheckValidationMessage(){
        yourSupplier.clickPostcodeTextField();
        yourSupplier.enterPostcode("123");
        clickPostCodeButtonAndPerformAssertions();
    }

    /**
     *  This test will check whether a validation message
     * if an partial postcode is entered
     */

    @Test
    public void enterPartialPostcodeAndCheckValidationMessage(){
        yourSupplier.clickPostcodeTextField();
        yourSupplier.enterPostcode("PE2");
        clickPostCodeButtonAndPerformAssertions();
    }

    /**
     *  This test will check a valid postcode
     */

    @Test
    public void enterAValidPostCodeAndVerifyChangePasswordLinkIsDisplayed(){
        yourSupplier.clickPostcodeTextField();
        yourSupplier.enterPostcode("PE2 6YS");
        yourSupplier.clickPostCodeButton();
        yourSupplier.waitForChangePostCodeLinkToBeDisplayed();
        assertTrue(yourSupplier.isChangePostCodeLinkIsDisplayed());
        assertTrue(yourSupplier.isNextButtonClickable());
        assertEquals(yourSupplier.getExpectedYourSupplierPageHeading(),yourSupplier.getYourSupplierPageHeadingText());
        assertEquals(yourSupplier.getExpectedPageTitle(),yourSupplier.getPageTitle());
    }
}

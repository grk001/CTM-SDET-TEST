package regression.comparethemarket.test.yourdetails;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import regression.comparethemarket.page.yourdetails.YourDetailsPage;
import regression.comparethemarket.page.yourenergy.YourEnergyPage;
import regression.comparethemarket.page.yoursupplier.YourSupplierPage;
import regression.comparethemarket.test.BaseTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class YourDetailsTest extends BaseTest{

    public YourSupplierPage yourSupplier;
    public YourEnergyPage yourEnergy;
    public YourDetailsPage yourDetails;

    @Override
    public void setupPage(WebDriver driver){
        this.yourSupplier = new YourSupplierPage(driver);
        this.yourEnergy = new YourEnergyPage(driver);
        this.yourDetails = new YourDetailsPage(driver);
    }

    @Override
    public void tearDownPage() {
    }

    /**
     * Test to perform whether details page exists
     */

    @Test
    public void checkDetailsPageExists() throws InterruptedException{
        yourSupplier.navigateFromYourSupplierToYourEnergy();
        yourEnergy.navigateFromYourEnergyToYourDetails();
        assertTrue(yourDetails.isEmailAddressFieldDisplayed());

    }

    /**
     * if an invalid email address is enter, checks whether
     * a validation is displayed
     */

    @Test
    public void enterInvalidEmailResultsToAValidationMessage(){
        yourSupplier.navigateFromYourSupplierToYourEnergy();
        yourEnergy.navigateFromYourEnergyToYourDetails();
        yourDetails.clickEmailAddressTextField();
        yourDetails.enterEmailAddress("123");
        yourDetails.clickTermsAndConditions();
        assertEquals("Your email doesn’t appear to be valid. please check you have entered it correctly.",
                yourDetails.getValidationMessageText());
    }
}

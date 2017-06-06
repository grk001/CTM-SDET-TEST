package regression.comparethemarket.test.yourenergy;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import regression.comparethemarket.page.yourenergy.YourEnergyPage;
import regression.comparethemarket.page.yoursupplier.YourSupplierPage;
import regression.comparethemarket.test.BaseTest;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;

public class YourEnergyTest extends BaseTest {

    public YourSupplierPage yourSupplier;
    public YourEnergyPage yourEnergy;

    @Override
    public void setupPage(WebDriver driver) {
        this.yourSupplier = new YourSupplierPage(driver);
        this.yourEnergy = new YourEnergyPage(driver);
    }

    @Override
    public void tearDownPage() {
    }

    /**
     * This test will check whether the page exist and enter a valid data in
     * required fields
     */

    @Test
    public void enterAValidKwhValueInElectricityUsage() throws InterruptedException {
        yourSupplier.navigateFromYourSupplierToYourEnergy();
        yourEnergy.clickElectricityUsageTextBox();
        yourEnergy.enterElectricityUsage("123");
        assertEquals(yourEnergy.getExpectedYourEnergyPageHeading(),
                yourEnergy.getYourEnergyPageHeadingText());
        assertFalse(yourEnergy.isValidationMessageDisplayed());
    }
}

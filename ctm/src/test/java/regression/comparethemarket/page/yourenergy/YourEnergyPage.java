package regression.comparethemarket.page.yourenergy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YourEnergyPage {

    private static final String PAGE_HEADING = "Your Energy";

    private final WebDriver driver;

    public YourEnergyPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Used in Assertion to test the Expected page heading
     */

    public String getExpectedYourEnergyPageHeading() {
        return PAGE_HEADING;
    }

    /**
     *  Electricity Usage
     */

    public WebElement getElectricityUsageFieldElements(){
      return  driver.findElement(By.id("electricity-usage"));
    }

    public void clickElectricityUsageTextBox(){
        getElectricityUsageFieldElements().click();
    }

    public void enterElectricityUsage(String usage){
        getElectricityUsageFieldElements().sendKeys(usage);
    }

    public WebElement getKwhRadioButtonInElectricityUsageFieldElements(){
        return driver.findElement(By.cssSelector("div>div > div.radio-ticks > label.checked"));
    }

    public void selectKwhRadioButton(){
        getKwhRadioButtonInElectricityUsageFieldElements().click();
    }

    /**
     *  Electricity Spend
     */

    public WebElement getElectricitySpendFieldElements(){
        return driver.findElement(By.id("electricity-spend"));
    }

    public void clickElectricitySpend(){
        getElectricitySpendFieldElements().click();
    }

    public void enterElectricitySpend(String spend){
        getElectricitySpendFieldElements().sendKeys(spend);
    }


    public WebElement getPoundRadioButtonInElectricityUsageFieldElements(){
        return driver.findElement(By.cssSelector("#electricity-usage-question > div > div > div.radio-ticks" +
                " > label.checked > span"));
    }

    public void selectPoundRadioButton(){
        getPoundRadioButtonInElectricityUsageFieldElements().click();
    }

    /**
     * Click Next Button
     */

    public WebElement getEnergyNextButtonFieldElements() {
        return driver.findElement(By.id("goto-your-energy"));
    }

    public void clickGasAndEnergyNextButton(){
        getEnergyNextButtonFieldElements().click();
    }

    /**
     * Navigate from Your Energy to Your Details
     */

    public void navigateFromYourEnergyToYourDetails(){
        clickElectricityUsageTextBox();
        enterElectricityUsage("123");
        clickGasAndEnergyNextButton();
        clickGasUsageTextField();
        enterValueGasUsagetextfield("123");
        clickGasAndEnergyNextButton();
        waitForTraiffSelectionQuestionInYourDetailsPageToBeDisplayed();
    }

    public WebElement waitForTraiffSelectionQuestionInYourDetailsPageToBeDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, 50);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated
                        (By.id("tariff-selection-question")));
        return element;
    }

    /**
     *  Gas Usage
     */

    public WebElement getGasUsageFindElements(){
        return driver.findElement(By.id("gas-usage"));
    }

    public void clickGasUsageTextField(){
        getGasUsageFindElements().click();
    }

    public void enterValueGasUsagetextfield(String gasusage) {
        getGasUsageFindElements().sendKeys(gasusage);
    }

    /**
     * Validation error messsage on Your Energy Page
     */
    public WebElement getValidationMessageFieldElements(){
        return driver.findElement(By.id("get-started-view-status"));
    }

    public boolean isValidationMessageDisplayed(){

        return   getValidationMessageFieldElements().isDisplayed();
    }

    /**
     * Get Page heading
     */

    public WebElement getPageHeadingFieldElements(){
        return driver.findElement(By.cssSelector("main > h2"));
    }

    public String getYourEnergyPageHeadingText(){
        return   getPageHeadingFieldElements().getText();
    }

}

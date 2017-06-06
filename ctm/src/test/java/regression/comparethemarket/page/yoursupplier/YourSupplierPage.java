package regression.comparethemarket.page.yoursupplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YourSupplierPage  {

    private static final String PAGE_TITLE = "Energy - Compare Gas and Electricity Suppliers | Compare The Market";
    private static final String PAGE_HEADING = "Your Supplier";

    private final WebDriver driver;

    public YourSupplierPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getExpectedPageTitle() {
        return PAGE_TITLE;
    }

    public String getExpectedYourSupplierPageHeading() {
        return PAGE_HEADING;
    }

    public String getYourSupplierPageHeadingText(){
        return   getPageHeadingFieldElements().getText();
    }

    public String getPageTitle(){
        return   driver.getTitle();
    }

    /**
     * Navigate From Your Supplier and wait for Your Energy page to be displayed
     */
    public void navigateFromYourSupplierToYourEnergy() {
        clickPostcodeTextField();
        enterPostcode("PE2 6YS");
        clickPostCodeButton();
        waitForChangePostCodeLinkToBeDisplayed();
        clickSupplierNextButton();
        waitForCurrentElectricityUsageToBeDisplayed();
    }

    public WebElement waitForCurrentElectricityUsageToBeDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, 50);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated
                        (By.id("electricity-usage")));
        return element;
    }

    /**
     * Select ,click and enter Postcode in Text Field
     */

    public WebElement getPostcodeTextFieldElement(){
    return driver.findElement(By.id("your-postcode"));
    }

    public void clickPostcodeTextField(){
        getPostcodeTextFieldElement().click();
    }

    public void enterPostcode(String postcode){
        getPostcodeTextFieldElement().sendKeys(postcode);
    }

    /**
     * click postcode button in Your Supplier and wait for the Change Postcode link to be displayed
     */

    public WebElement getPostcodeButtonFieldElement(){
        return driver.findElement(By.id("find-postcode"));
    }

    public void clickPostCodeButton(){
        getPostcodeButtonFieldElement().click();
    }

    public WebElement getChangePostCodeLinkFieldElement(){
     return driver.findElement(By.id("change-postcode"));
    }

    public boolean isChangePostCodeLinkIsDisplayed(){
      return   getChangePostCodeLinkFieldElement().isDisplayed();
    }

    public WebElement waitForChangePostCodeLinkToBeDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated
                        (By.id("change-postcode")));
        return element;
    }

    /**
     * Validation Message is displayed once an Invalid postcode is entered
     */

    public WebElement getValidationMessageFieldElementForPostcode(){
        return driver.findElement(By.cssSelector("#postcode-question > div > div > div:nth-child(1) > div"));
    }

    public String getValidationMessageTextForPostcodeTextField(){
       return getValidationMessageFieldElementForPostcode().getText();
    }

    public boolean waitForPostcodeValidationMessageToBeDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, 50);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated
                        (By.cssSelector("#postcode-question > div > div > div:nth-child(1) > div")));
      return   element.isDisplayed();
    }

    /**
     *  click Next Button in Your Supplier once a valid data is provided
     */

    public boolean isNextButtonClickable(){
        return getSupplierNextButtonFieldElements().isEnabled();
    }

    public void clickSupplierNextButton(){
        getSupplierNextButtonFieldElements().click();
        waitForPageHeadingToBeDisplayed();
    }

    public WebElement getSupplierNextButtonFieldElements() {
        return driver.findElement(By.id("goto-your-supplier-details"));
    }

    /**
     * Get Page Heading
     */

    public WebElement getPageHeadingFieldElements(){
        return driver.findElement(By.cssSelector("main > h2"));
    }

    public WebElement waitForPageHeadingToBeDisplayed(){
        WebDriverWait wait = (new WebDriverWait(driver, 30));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("main > h2")));
        return element;
    }

}

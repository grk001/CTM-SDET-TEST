package regression.comparethemarket.page.yourdetails;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YourDetailsPage {

    private final WebDriver driver;

    public YourDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Get Page heading
     */
    public WebElement getPageHeadingFieldElements(){
        return driver.findElement(By.cssSelector("main > h2"));
    }

    public String getYourDetailsPageHeadingText(){
        waitForPageHeadingToBeDisplayed();
        return   getPageHeadingFieldElements().getText();
    }

    public WebElement waitForPageHeadingToBeDisplayed(){
        WebDriverWait wait = (new WebDriverWait(driver, 30));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("main > h2")));
        return element;
    }

    /**
     * Email Address
     */

    public WebElement getEmailAddressFieldElements(){
      return   driver.findElement(By.id("Email"));
    }

    public boolean isEmailAddressFieldDisplayed(){
        return getEmailAddressFieldElements().isDisplayed();
    }

    public void clickEmailAddressTextField(){
        getEmailAddressFieldElements().click();
    }

    public void enterEmailAddress(String enterEMailAddress){
        getEmailAddressFieldElements().sendKeys(enterEMailAddress);
    }

    /**
     * Validation Message
     */

    public WebElement getEmailAddressValidationMessageFieldElements(){
        return driver.findElement(By.cssSelector("#email > div > div.answer.full-width > div"));
    }

    public String getValidationMessageText(){
      return getEmailAddressValidationMessageFieldElements().getText();
    }

    public WebElement waitForEmailValidationMessageInYourDetailsPageToBeDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, 50);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated
                        (By.cssSelector("#email > div > div.answer.full-width > div")));
        return element;
    }

    /**
     * click Go to price button
     */

    public WebElement getGoToPriceButtonFieldElements(){
        return  driver.findElement(By.id("email-submit-dub"));
    }

    public void clickGoToPriceButton(){
        waitForGoToPriceButtonToBeVisible();
       getGoToPriceButtonFieldElements().click();
    }

    public WebElement waitForGoToPriceButtonToBeVisible(){

        WebDriverWait wait = new WebDriverWait(driver, 50);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated
                        (By.id("email-submit-dub")));
        return element;
    }

    /**
     * Select terms and Conditions
     */
    public WebElement getTermsAndConditionsFieldElements(){
        return driver.findElement(By.cssSelector("#terms-label > span:nth-child(3)"));
    }

    public void clickTermsAndConditions(){
        getTermsAndConditionsFieldElements().click();
    }
}

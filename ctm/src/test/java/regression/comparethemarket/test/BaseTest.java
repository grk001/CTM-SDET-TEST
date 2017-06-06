package regression.comparethemarket.test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    private WebDriver driver;

    @Before
    public final void setUp() {
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        this.driver.get("https://energy.comparethemarket.com/energy/v2/?AFFCLIE=TSTT");
        setupPage(driver);
    }

    @After
    public final void tearDown() {
        tearDownPage();
        driver.quit();
    }

    public abstract void setupPage(WebDriver driver);

    public abstract void tearDownPage();

    public WebDriver getDriver() {
        return driver;
    }
}

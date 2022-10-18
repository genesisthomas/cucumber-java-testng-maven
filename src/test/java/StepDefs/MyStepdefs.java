package StepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MyStepdefs {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @When("Open Google on your browser")
    public void hitGoogleOnYourBrowser() {
        driver.get("https://www.google.com");
    }

    @Then("Enter {string} in the search text box.")
    public void enterInTheSearchTextBox(String arg0) {
        By input = By.name("q");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(input));
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File("headless_screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.findElement(input).click();
        driver.findElement(input).sendKeys(arg0);
        driver.findElement(input).sendKeys(Keys.ENTER);
    }

    @And("Verify {string} in the first result.")
    public void selectTheFirstResult(String arg0) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h3[contains(.,'" + arg0 + "')]")));
    }

    @Then("fail")
    public void fail() {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.name("q2")).click();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

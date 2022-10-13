package StepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MyStepdefs {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
    }

    @When("Open Google on your browser")
    public void hitGoogleOnYourBrowser() {
        driver.get("https://www.google.com");
    }

    @Then("Enter {string} in the search text box.")
    public void enterInTheSearchTextBox(String arg0) {
        driver.findElement(By.name("q")).click();
        driver.findElement(By.name("q")).sendKeys(arg0);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
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

package Steps;

import com.revature.Runner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NavSteps {
    WebDriver driver = Runner.driver;

    @Given("The Manager is logged in as a manager")
    public void theManagerIsLoggedInAsAManager() {
        driver.navigate().to("file:///C:/Users/Nicholas%20Chu/Desktop/training-repos/P0/P1/src/main/resources/public/home.html");
        driver.findElement(By.id("username")).sendKeys("TDL906");
        driver.findElement(By.id("password")).sendKeys("Super5man906");
        driver.findElement(By.id("loginButton")).click();

    }

    @Given("The Manager is on the home page")
    public void theManagerIsOnTheHomePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("currentRe")));


    }

    @When("The Manager clicks on edit on one of the current requests")
    public void theManagerClicksOnEditOnOneOfTheCurrentRequests() {
        driver.findElement(By.id("logOut")).click();
        driver.findElement(By.id("username")).sendKeys("TDL906");
        driver.findElement(By.id("password")).sendKeys("Super5man906");
        driver.findElement(By.id("loginButton")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/h2/div/table/tbody/tr[1]/td[12]/button")));
        driver.findElement(By.id("editB")).click();
    }

    @Then("The title of the page should be Active Requests")
    public void theTitleOfThePageShouldBeActiveRequests() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("calculateRe")));
        assertEquals("Active Requests",driver.findElement(By.id("activeSub")).getText());
    }

}

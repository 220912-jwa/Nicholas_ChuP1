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
import org.openqa.selenium.support.ui.Select;


import java.time.Duration;

public class CreateReSteps {
    WebDriver driver = Runner.driver;
    @When("The employee clicks on New Reimbursement")
    public void theEmployeeClicksOnNewReimbursement() {
        driver.findElement(By.id("createRe")).click();
    }

    @When("The employee fills out the reimbursement form")
    public void theEmployeeFillsOutTheReimbursementForm() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("submitRE")));
        Select se = new Select(driver.findElement(By.id("events")));
        driver.findElement(By.id("date")).sendKeys("12222023");
        driver.findElement(By.id("time")).sendKeys("0900A");
        driver.findElement(By.id("location")).sendKeys("VA");
        driver.findElement(By.id("description")).sendKeys("Business Class");
        driver.findElement(By.id("cost")).sendKeys("300");
        driver.findElement(By.id("justification")).sendKeys("Expand knowledge on more business practices");
        se.selectByVisibleText("University Course");
    }

    @When("the employee clicks on Submit")
    public void theEmployeeClicksOnSubmit() {
        driver.findElement(By.id("submitRE")).click();
    }

    @Then("The employee is back on the Main Menu")
    public void theEmployeeIsBackOnTheMainMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("currentRe")));

    }

    @And("see their current request")
    public void seeTheirCurrentRequest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/h2/div/table/tbody/tr[1]/td[1]")));
    }

    @Given("The employee logs in")
    public void theEmployeeLogsIn() {
        driver.navigate().to("file:///C:/Users/Nicholas%20Chu/Desktop/training-repos/P0/P1/src/main/resources/public/home.html");
        driver.findElement(By.id("username")).sendKeys("lyndon9");
        driver.findElement(By.id("password")).sendKeys("pass123");
        driver.findElement(By.id("loginButton")).click();
    }
}

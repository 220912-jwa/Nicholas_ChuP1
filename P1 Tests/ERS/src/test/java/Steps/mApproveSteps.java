package Steps;

import com.revature.Runner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class mApproveSteps {
    WebDriver driver = Runner.driver;
    @Given("The Manager logs in")
    public void theManagerLogsIn() {
        driver.findElement(By.id("username")).sendKeys("TDL906");
        driver.findElement(By.id("password")).sendKeys("Super5man906");
        driver.findElement(By.id("loginButton")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/h2/div/table/tbody/tr[1]/td[12]/button")));

    }

    @When("The Manager clicks on Calculate")
    public void theManagerClicksOnCalculate() {
        driver.findElement(By.id("calculateRe")).click();
    }

    @And("sees the refund amount")
    public void seesTheRefundAmount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("total")));
    }

    @When("The Manager clicks on Approve")
    public void theManagerClicksOnApprove() {
        driver.findElement(By.id("approve")).click();
    }
}

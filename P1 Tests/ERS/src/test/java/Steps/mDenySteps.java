package Steps;

import com.revature.Runner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class mDenySteps {

    WebDriver driver = Runner.driver;
    @When("The Manager clicks Deny")
    public void theManagerClicksDeny() {
        driver.findElement(By.id("deny")).click();
    }

    @And("an alert pops up")
    public void anAlertPopsUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
}

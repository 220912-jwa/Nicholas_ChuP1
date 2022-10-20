package Steps;

import com.revature.Runner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSteps {
    WebDriver driver = Runner.driver;
    @Given("The employee is on the login page")
    public void the_employee_is_on_the_login_page() {
        driver.navigate().to("file:///C:/Users/Nicholas%20Chu/Desktop/training-repos/P0/P1/src/main/resources/public/home.html");

    }
    @When("The employee types {string} into username input")
    public void the_employee_types_into_username_input(String string) {
        driver.findElement(By.id("username")).sendKeys(string);
    }
    @When("The employee types {string} into password input")
    public void the_employee_types_into_password_input(String string) {
        driver.findElement(By.id("password")).sendKeys(string);
    }
    @When("The employee clicks on the login button")
    public void the_employee_clicks_on_the_login_button() {
        driver.findElement(By.id("loginButton")).click();
    }
    @Then("The employee should be on Main Menu page")
    public void the_employee_should_be_on_main_menu_page() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("welcome")));

    }
    @Then("The employee should see their {string} on the home page")
    public void the_employee_should_see_their_on_the_home_page(String string) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("welcome")));
        assertEquals("Welcome back, " + string + ".", driver.findElement(By.id("welcome")).getText());
    }

    @When("The employee types in lyndon9 into the username input")
    public void the_employee_types_in_lyndon9_into_the_username_input() {
        driver.findElement(By.id("username")).sendKeys("lyndon9");
    }
    @When("The employee types in passpass into the password input")
    public void the_employee_types_in_passpass_into_the_password_input() {
        driver.findElement(By.id("password")).sendKeys("passpass");
    }
    @Then("The employee should see an alert saying they have the wrong password")
    public void the_employee_should_see_an_alert_saying_they_have_the_wrong_password() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }


    @Given("The Manager is on the login page")
    public void theManagerIsOnTheLoginPage() {
        driver.navigate().to("file:///C:/Users/Nicholas%20Chu/Desktop/training-repos/P0/P1/src/main/resources/public/home.html");
    }


    @Then("The Manager should be on the Home page and see edit buttons")
    public void theManagerShouldBeOnTheHomePageAndSeeEditButtons() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/h2/div/table/tbody/tr[1]/td[12]/button")));
    }
}

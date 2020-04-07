package Com.fb.steps;

import com.fb.config.SeleniumDriver;
import com.fb.proj.config.AppConfig;
import com.fb.proj.pages.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.cucumber.java.en.Then;

public class AppStepDef extends Pages {
    public AppStepDef(SeleniumDriver driver){
        super(driver);
    }

    @Given("^googlemail page is up and running$")
    public void googlemailPageIsUpAndRunning() throws InterruptedException {
        NavigateTo(AppConfig.getPropertyValueFromPropertyFile("APP_URL"));
        homePage.waitUntilHomePageResultsContainerIsLoaded();
        Thread.sleep(3000);
    }
    @When("^the user enter email \"([^\"]*)\" and navigate to next page$")
    public void theUserEnterEmailAndNavigateToNextPage(String emailUserName) throws InterruptedException {
        homePage.EnterEmail(emailUserName);
        homePage.ClickNext();
        Thread.sleep(5000);
    }

    @When("^user run accessibility scan to check if there is any issues$")
    public void userRunAccessibilityScanToCheckIfThereIsAnyIssues() throws Throwable {
        accessibility.testAccessibility();
    }

    @Given("^yahoomail page is up and running$")
    public void yahoomailPageIsUpAndRunning() throws Throwable {
        NavigateTo("https://login.yahoo.com/");
        homePage.waitUntilHomePageResultsContainerIsLoaded();
        Thread.sleep(3000);
    }

    @Given("Template Home page is up and running")
    public void templateHomePageIsUpAndRunning() throws InterruptedException {
        NavigateTo(AppConfig.getPropertyValueFromPropertyFile("Template_URL"));
        Thread.sleep(3000);
    }

    @When("user click on sign in to Account")
    public void userClickOnSignInToAccount() {
        template.ClickSignIn();
    }

    @Then("user should be able to see sign in page")
    public void userShouldBeAbleToSeeSignInPage() {
        template.waitUntilHomePageResultsContainerIsLoaded();
    }
}

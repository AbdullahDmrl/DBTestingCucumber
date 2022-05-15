package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Pages.Parent;
import Utilities.BaseDriver;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class _0LoginSteps {

    DialogContent dc=new DialogContent();
    LeftNav ln=new LeftNav();


    @Given("^Navigate to basqar$")
    public void navigate_to_basqar() {

        WebDriver driver= BaseDriver.getDriver();
        driver.get("https://demo.mersys.io/");
        driver.manage().window().maximize();

    }

    @When("^Enter username and password and click login button$")
    public void enter_username_and_password_and_click_login_button()  {

        dc.findAndSend("username", "richfield.edu");
        dc.findAndSend("password", "Richfield2020!");
        dc.findAndClick("acceptCookies");
        dc.findAndClick("loginButton");
    }

    @Then("^User should login successfully$")
    public void user_should_login_successfully()  {

        Parent.waitUntilVisible(dc.dashboard);

        Assert.assertEquals(dc.dashboard.getText(), "Dashboard");
    }


}

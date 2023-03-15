package com.zerobank.stepDefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_stepDefs {

    LoginPage loginPage = new LoginPage();

    @Given("The user go to ZeroBank login page")
    public void the_user_go_to_zero_bank_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }



    @When("The user should input credentials userName: {string} and password {string}")
    public void theUserShouldInputCredentialsUserNameAndPassword(String username, String password) {
        loginPage.loginZeroBank_mtd(username, password);
    }

    @Then("The user verify that {string}")
    public void the_user_verify_that(String expectedWrongMessage) {

        String actualWrongMessage = loginPage.wrongMessage.getText();

        Assert.assertEquals(expectedWrongMessage,actualWrongMessage);

    }
}

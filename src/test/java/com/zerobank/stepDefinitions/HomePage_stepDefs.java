package com.zerobank.stepDefinitions;

import com.google.common.collect.Maps;
import com.zerobank.pages.HomePage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class HomePage_stepDefs {

    HomePage homePage = new HomePage();

    @When("The user click to {string} tab")
    public void the_user_click_to_tab(String tabName) {
        homePage.getTab(tabName);

    }

    @Then("The user should see subtitles")
    public void the_user_should_see_subtitles(List<String> expectedList) {


        List<String> actualList = homePage.titlesOfAccountSummary_mtd();

        Assert.assertEquals(expectedList, actualList);

    }

    @Then("The user should see titles of Credit Accounts")
    public void the_user_should_see_titles_of_credit_accounts(List<String> expectedList) {

        List<String> actualList = homePage.titlesOfCreditAccountTable_mtd();

        Assert.assertEquals(expectedList, actualList);

    }

    @Then("The user should see type of account select menu")
    public void the_user_should_see_type_of_account_select_menu(List<String> expectedOfSelectMenu) {


        List<String> actualSelectMenu = homePage.getSelectMenu();
        Assert.assertEquals(expectedOfSelectMenu, actualSelectMenu);
    }

    @When("The user select payee by text {string} and account by index {string}")
    public void the_user_select_payee_by_text_and_account_by_index(String visibleText, String index) {

        homePage.selectPayeeMenu_mtd(visibleText);
        homePage.setSelectAccountMenu_mtd(Integer.parseInt(index));
    }

    @When("The user input amount {string}")
    public void the_user_input_amount(String amount) {

        if (amount.contains(".")) {
            double c = Double.parseDouble(amount);

            String s = String.valueOf(c);

            homePage.inputAmount.sendKeys(s);


        } else if (homePage.isNumeric(amount)) {

            homePage.inputAmount.sendKeys(amount);

        }


    }

    @When("The user input date {string}")
    public void theUserInputDate(String date) {

        if (homePage.isAlphabeticAndSpecialChar(date)) {
            homePage.inputDate.sendKeys(date);
            BrowserUtils.waitFor(2);
        }

    }


    @When("The user click pay button")
    public void the_user_click_pay_button() {

        homePage.payButton.click();
        BrowserUtils.waitFor(2);
    }


    @Then("The user should be able to see payment message: {string}")
    public void theUserShouldBeAbleToSeePaymentMessage(String expectedMessage) {


        if (expectedMessage.contains("successfull")) {

            System.out.println(homePage.paymentMessage_loc.getText());

            Assert.assertEquals(expectedMessage, homePage.paymentMessage_loc.getText());

        } else {

            if (homePage.inputAmount.getAttribute("value").isEmpty()) {

                Assert.assertEquals(expectedMessage, homePage.inputAmount.getAttribute("validationMessage"));

            } else {

                Assert.assertEquals(expectedMessage, homePage.inputDate.getAttribute("validationMessage"));
            }

        }


//        Assert.assertEquals(expectedMessage, homePage.inputAmount.getAttribute("validationMessage"));

/*
        String actualMessage=payBillsPage.messageText.getText();

        boolean match=false;
        if (actualMessage!=expectedMessage){
            match=true;
        }
        Assert.assertTrue(match);

 */
    }


    @When("User should navigate to Add New Payee")
    public void user_should_navigate_to_add_new_payee() {

        homePage.addNewPayee.click();

    }

    @When("User should create new payee using following information")
    public void user_should_create_new_payee_using_following_information(Map<String, String> informations) {

        //String pateeName, String payeeAdres, String account, String payeeDetails;
        homePage.addNewPayeeInfo(informations.get("Payee Name"), informations.get("Payee Address"), informations.get("Account"), informations.get("Payee details"));


    }

    @Then("{string} should see")
    public void shouldSee(String expected) {

        String actualText = homePage.getMessage.getText();

        Assert.assertEquals(expected, actualText);


    }
}

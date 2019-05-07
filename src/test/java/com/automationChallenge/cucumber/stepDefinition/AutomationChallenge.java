package com.automationChallenge.cucumber.stepDefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assume.assumeFalse;

import java.awt.Robot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.automationChallenge.cucumber.config.FrameworkConfig;
import com.automationChallenge.cucumber.pages.LoginPage;
import com.automationChallenge.cucumber.pages.OrderPage;
import com.automationChallenge.cucumber.pages.ViewOrderListPage;
import com.automationChallenge.cucumber.utility.WebDriverLibrary;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AutomationChallenge{
	private BaseSteps base;
	private WebDriver driver;
	private LoginPage loginPage;
	private OrderPage orderPage;
	private ViewOrderListPage viewOrderListPage;
	private WebDriverLibrary wdLibrary;
	private Robot robot;
	static final Logger logger = LogManager.getLogger(BaseSteps.class);
	
	public AutomationChallenge(BaseSteps base) throws Exception{
		this.base = base;
		this.driver = this.base.driver;
		this.loginPage = this.base.loginPage;
		this.orderPage = this.base.orderPage;
		this.viewOrderListPage = this.base.viewOrderListPage;
		this.wdLibrary = this.base.wdLibrary;
		this.robot = new Robot();
	}

	@Given("^I navigate to login page$")
	public void i_navigate_to_login_page() throws Throwable {
		try {
			logger.info(FrameworkConfig.automationChallengeURL);
			driver.get(FrameworkConfig.automationChallengeURL);
			logger.info("Get URL successful");
		} catch (Exception e) {
			logger.info(e.getMessage());
			Assert.fail(e.getMessage());
		}

	}

	@When("^I enter UserName Password and click submit$")
	public void i_enter_UserName_Password_and_click_submit() throws Throwable {
		try {
			loginPage.login();
			logger.info("Login successful");
		}catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Validate login is successful$")
	public void validate_login_is_successful() throws Throwable {
		try {
			assertEquals(driver.getTitle(), FrameworkConfig.title);
			logger.info(driver.getTitle()+" - Login validated successfully");
		}catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@When("^I click order$")
	public void i_click_order() throws Throwable {
		try {
			viewOrderListPage.clickOrder();
			logger.info("Order clicked successfully");
		}catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@When("^Enter order details$")
	public void enter_order_details() throws Throwable {
		try {
			orderPage.enterOrderDetails();
			logger.info("Order details entered successfully");
		}catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@When("^click view all orders$")
	public void click_process() throws Throwable {
		try {
			viewOrderListPage.clickViewAllOrders();
			logger.info("Clicked view page successfully");
		}catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Validate the new order in the list$")
	public void validate_the_new_order_in_the_list() throws Throwable {
		try {
			assertEquals(viewOrderListPage.getFullDetails(), FrameworkConfig.newOrderFullDetails);
			logger.info(viewOrderListPage.getFullDetails()+" - New order validated successfully");
		}catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@When("^I click the edit$")
	public void i_click_the_edit() throws Throwable {
		try {
			viewOrderListPage.clickEdit();
			logger.info("Clicked edit successfully");
		}catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@When("^Update the new card number and click update$")
	public void update_the_new_card_number() throws Throwable {
		try {
			orderPage.editOrderDetails();
			logger.info("Edited the details successfully");
		}catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Validate the update customer details in the list$")
	public void validate_the_update_customer_name_in_the_list() throws Throwable {
		try {
			assertEquals(viewOrderListPage.getFullDetails(), FrameworkConfig.editOrderFullDetails);
			logger.info(viewOrderListPage.getFullDetails()+" - Validated edited order successfully");
		}catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@When("^I select the order created$")
	public void i_select_the_order_created() throws Throwable {
		try {
			viewOrderListPage.clickCheckBox();
			logger.info("Checkbox selected successfully");
		}catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@When("^Click delete selected$")
	public void click_delete_selected() throws Throwable {
		try {
			viewOrderListPage.clickDeleteButton();
			logger.info("Deleted the order successfully");
		}catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Validated for the delected order$")
	public void validated_for_the_delected_order() throws Throwable {
		try {
			assertNotEquals(viewOrderListPage.getFullDetails(), FrameworkConfig.editOrderFullDetails);
			logger.info(viewOrderListPage.getFullDetails()+" Validated deleted order successfully");
		}catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@When("^I click logout$")
	public void i_click_logout() throws Throwable {
		try {
			viewOrderListPage.clickLogout();
			logger.info("Logged out successfully");
		}catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	@Then("^Validate page is logged out$")
	public void validate_page_is_logged_out() throws Throwable {
		try {
		assertEquals(driver.getTitle(), FrameworkConfig.loginTitle);
		logger.info(driver.getTitle()+" - Logout validated successfully");
		}catch(Exception e) {
			logger.info(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
}

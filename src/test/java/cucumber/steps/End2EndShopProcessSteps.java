package cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.steps.serenity.TricentisWebShopSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

public class End2EndShopProcessSteps {
	
	@Managed
	String userName = "wonasa5819@mail3tech.com"; // pre-defined user
	String passWord = "testpw"; // pre-defined password
	String gender = "female"; // only 2 options available here, but has been parameterized with if-clause
	
	@Steps
	TricentisWebShopSteps cucu_test;
	
	@Given("the user navigates to the registration page")
	public void user_navigates_to_Registration_page() {
		
		cucu_test.navigateToRegistrationPage();
		
	}
	
	@And("the user adds new user information")
	public void user_adds_new_user_information() {
		
		cucu_test.doRegister(userName, passWord, gender);
	}
	
	@When("^the user enters the valid account information$")
	public void the_user_enters_the_valid_account_information() {
	    cucu_test.navigateToDashboard();
	    cucu_test.navigateToLogin();
	    cucu_test.doLogin(userName, passWord);
	}


	@Then("^the user should be able to log in$")
	public void the_user_should_be_able_to_log_in() {
	    cucu_test.checkLoginSuccess(userName);
	    cucu_test.navigateToCart();
	    cucu_test.doValidationOfEmptyShoppingCart();
	    cucu_test.navigateToDashboard();
	}
	
	@Given("^the user navigates to product category$")
	public void the_user_navigates_to_product_category() {
		cucu_test.navigateToProductCategory();
		
	}


	@When("^the user should be able to pick a product and add the chosen product to cart$")
	public void the_user_should_be_able_to_add_the_chosen_product_to_cart() {
		cucu_test.selectProduct();
		
	}

	@Then("^the cart should show the chosen product$")
	public void the_cart_should_show_the_chosen_product() {
		cucu_test.navigateToCart();
	}

	
	@And("^user enters check-out credentials and should be able to check-out$")
	public void user_enters_check_out_credentials() throws InterruptedException {
		cucu_test.doBasicCheckout();
		cucu_test.fillExtendedCheckoutData();
		
	}

	@And("^user should see confirmation message$")
	public void user_should_see_confirmation_message() throws InterruptedException {
		cucu_test.doOrderConfirmation();
		cucu_test.navigateToDashboard();
		
	}

	@Then("^user should be able to log-off$")
	public void user_should_be_able_to_log_off() throws InterruptedException {
	    cucu_test.signOut();
	    Thread.sleep(3000);
	}

}

package cucumber.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.BasePage;
import pages.CheckoutPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ProductPage;
import pages.RegisterPage;
import pages.ShoppingCartPage;

public class TricentisWebShopSteps extends ScenarioSteps{
	
	BasePage base;
	RegisterPage register;
	LoginPage log;
	ShoppingCartPage cart;
	ProductPage prod;
	CheckoutPage checkout;
	
	/********************************************
	 * 
	 * BASE PAGE STEPS
	 * 
	 ********************************************/
	
	// these methods are ONLY wrappers on top of the initial methods
		
	@Step("Navigate to the Registration Page")
	public RegisterPage navigateToRegistrationPage () {
		
		return base.navigateToRegistrationPage();
	}
	
	@Step("Clicking on Logo & navigating to Main Page (aka. Dashboard)")
	public DashboardPage navigateToDashboard () {
		
		return base.navigateToDashboard();
	}
	
	@Step("Log out of the WebStore")
	public DashboardPage signOut() {
		
		return base.signOut();
	}
	
	@Step("Navigate to Shopping Cart")
	public ShoppingCartPage navigateToCart() {
		
		return base.navigateToCart();
	}
	
	@Step("Product category selection")
	public ProductPage navigateToProductCategory() {
		
		return base.navigateToProductCategory();
	}
	
	@Step("Navigate to Login Page")
	public LoginPage navigateToLogin() {
		
		return base.navigateToLogin();
	}
	
	/********************************************
	 * 
	 * REGISTER PAGE STEPS
	 * 
	 ********************************************/
	
	@Step ("Entering the info needed to register a new user")
	public DashboardPage doRegister(String userName, String passWord, String gender) {
		
		return register.doRegister(userName, passWord, gender);
	}
	
	/********************************************
	 * 
	 * LOGIN PAGE STEPS
	 * 
	 ********************************************/
	
	@Step ("Login as the new registered user")
	public DashboardPage doLogin(String userName, String passWord) {

		return log.doLogin(userName, passWord);
	}
	
	@Step ("Validate successful login")
	public DashboardPage checkLoginSuccess(String userName) {
		
		return log.checkLoginSuccess(userName);
	}
	
	/********************************************
	 * 
	 * SHOPPING CART PAGE STEPS
	 * 
	 ********************************************/
	
	@Step ("Validate that the shopping cart is empty")
	public ShoppingCartPage doValidationOfEmptyShoppingCart() {
		
		return cart.doValidationOfEmptyShoppingCart();
	}
	
	/********************************************
	 * 
	 * PRODUCT SELECTION PAGE STEPS
	 * 
	 ********************************************/
	
	@Step ("Select specific product and add it to cart")
	public ProductPage selectProduct() {
		
		return prod.selectProduct();
	}
	
	/********************************************
	 * 
	 * CHECKOUT PAGE STEPS
	 * 
	 ********************************************/
	
	@Step ("Fill in the basic checkout data")
	public CheckoutPage doBasicCheckout() {
		
		return checkout.doBasicCheckout();
	}
	
	@Step ("Fill in the full checkout data needed")
	public CheckoutPage fillExtendedCheckoutData() throws InterruptedException {
		
		return checkout.fillExtendedCheckoutData();
	}
	
	@Step ("Confirm order")
	public CheckoutPage doOrderConfirmation() throws InterruptedException{
		
		return checkout.doOrderConfirmation();
	}

}

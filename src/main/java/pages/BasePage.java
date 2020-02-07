package pages;

import net.serenitybdd.core.pages.PageObject;

public class BasePage extends PageObject {
			
	private static final String LOGO_LINK = "//img[@alt='Tricentis Demo Web Shop']";
	
	private static final String REGISTER_LINK = "//a[@class='ico-register']";
	
	private static final String SIGN_OUT_LINK = "//a[@class='ico-logout']";
	
	private static final String SHOPPING_CART_LINK = "//span[@class='cart-qty']";
	
	private static final String PRODUCT_CATEGORY_LINK = "/html/body/div[4]/div[1]/div[2]/ul[1]/li[4]/a";
	
	private static final String LOGIN_LINK = "//a[@class='ico-login']";
	
	/**
	 * Navigate to the Registration Page
	 * @return
	 */
	public RegisterPage navigateToRegistrationPage () {
		
		open();
		
		waitForTextToAppear("Welcome to our store");
		
		waitFor(REGISTER_LINK).$(REGISTER_LINK).click();
		
		return this.switchToPage(RegisterPage.class);
	}
	
	/**
	 * Navigate to Main Page
	 * @return
	 */
	public DashboardPage navigateToDashboard () {
					
		waitFor(LOGO_LINK).$(LOGO_LINK).click();
		
		return this.switchToPage(DashboardPage.class);
		
	}
	
	/**
	 * Log out of the store
	 * @return
	 */
	public DashboardPage signOut() {
		
		waitFor(SIGN_OUT_LINK).$(SIGN_OUT_LINK).click();
		
		return this.switchToPage(DashboardPage.class);
		
	}
	
	/**
	 * Navigate to Shopping Cart
	 * @return
	 */
	public ShoppingCartPage navigateToCart() {
		
		waitFor(SHOPPING_CART_LINK).$(SHOPPING_CART_LINK).click();
		
		return this.switchToPage(ShoppingCartPage.class);
	}
	
	/**
	 * Product category selection
	 * @return
	 */
	public ProductPage navigateToProductCategory() {
		
		waitFor(PRODUCT_CATEGORY_LINK).$(PRODUCT_CATEGORY_LINK).click();
		
		return this.switchToPage(ProductPage.class);
		
	}
	
	/**
	 * Navigation to Login page
	 * @return
	 */
	public LoginPage navigateToLogin() {
		
		waitFor(LOGIN_LINK).$(LOGIN_LINK).click();
		
		return this.switchToPage(LoginPage.class);
	}
}

package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import cucumber.steps.serenity.TricentisWebShopSteps;

@RunWith(SerenityRunner.class)
public class TricentisWebShopTest {

	@Managed 
	WebDriver driver;
	
	String userName = "wonasa5819@mail3tech.com"; // pre-defined user
	String passWord = "testpw"; // pre-defined password
	String gender = "female"; // only 2 options available here, but has been parameterized with if-clause
	
	@Steps
	TricentisWebShopSteps shop;
	
	@Test
	@Title("TricentisWebShop")
	public void endToEndShoppingExperience() throws InterruptedException {
		
		shop.navigateToRegistrationPage();
		shop.doRegister(userName, passWord, gender);
		shop.navigateToDashboard();
		shop.navigateToLogin();
		shop.doLogin(userName, passWord);
		shop.checkLoginSuccess(userName);
		shop.navigateToCart();
		shop.doValidationOfEmptyShoppingCart();
		shop.navigateToDashboard();
		shop.navigateToProductCategory();
		shop.selectProduct();
		shop.navigateToCart();
		shop.doBasicCheckout();
		shop.fillExtendedCheckoutData();
		shop.doOrderConfirmation();
		shop.navigateToDashboard();
		shop.signOut();
		Thread.sleep(1000);
	}
	
}

package step_implementation;

import org.junit.Assert;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;

public class UserLogsIn extends PageObject {


	public void userOnLoginPage() throws InterruptedException {

		$("a[href$='login'][class='ico-login']").click();
		Thread.sleep(1000);

	}
	
	public void userEntersValidCredentials(String userName, String passWord) throws InterruptedException {
		
		getDriver().findElement(By.id("Email")).sendKeys(userName);
		getDriver().findElement(By.name("Password")).sendKeys(passWord);
		$("input[class$='button-1 login-button'][value='Log in']").click(); // implicit click on log-in button
		
		Thread.sleep(1000);
	}
	
	public void userSeesAccountDetails (String userName) throws InterruptedException {
		String expected = userName;
		String actual = $("/html/body").getText();
		Assert.assertTrue(actual.contains(expected)); // assertion to verify that the login was successful

		// make sure the shopping cart is empty
		$("span[class$='cart-label']").click();

		Thread.sleep(1000);
		
		String emptyCart = "Your Shopping Cart is empty!";
		String actualCart = $("div[class$='order-summary-content']").getText();
		if (actualCart.contains(emptyCart)) {
			System.out.println("\n" + actualCart);
		}
		else {
			// do nothing, cart will be empty
		}

		$("img[alt$='Tricentis Demo Web Shop'][src='/Themes/DefaultClean/Content/images/logo.png']").click(); //return to main page
		Thread.sleep(1000);
	}
}

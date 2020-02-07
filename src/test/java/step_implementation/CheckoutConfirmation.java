package step_implementation;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import net.serenitybdd.core.pages.PageObject;

public class CheckoutConfirmation extends PageObject {
	
	public void confirmOrder () throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		js.executeScript("window.scrollTo(0, 0)");

		$("input[onclick$='ConfirmOrder.save()'][value='Confirm']").click();
		Thread.sleep(1000);
	}
	
	public void orderValidation () throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		js.executeScript("window.scrollTo(0, 0)");
		
		Thread.sleep(1000);

		String expectedConfirmation = "Your order has been successfully processed!";
		String actualConfirmation = $("div[class$='page-body checkout-data']").getText();
		System.out.println("\n" + actualConfirmation);
		Assert.assertTrue(actualConfirmation.contains(expectedConfirmation)); // assertion to verify that the login was successful
		
		Thread.sleep(1000);
	}
}

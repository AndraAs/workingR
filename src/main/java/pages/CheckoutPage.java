package pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import net.serenitybdd.core.annotations.findby.By;

public class CheckoutPage extends BasePage {

	public CheckoutPage doBasicCheckout() {

		waitFor(("button[type$='submit'][id='checkout'][name='checkout']"));
		getDriver().findElement(By.name("CountryId")).click();
		getDriver().findElement(By.name("CountryId")).sendKeys("c");
		getDriver().findElement(By.name("CountryId")).sendKeys(Keys.RETURN);
		getDriver().findElement(By.id("termsofservice")).click();
		$("button[type$='submit'][id='checkout'][name='checkout']").click();
		
		return this.switchToPage(CheckoutPage.class);
	}
	
	/**
	 * Method used to fill extended checkout data needed
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public CheckoutPage fillExtendedCheckoutData() throws InterruptedException {
		
		getDriver().findElement(By.id("billing-address-select")).click();
		getDriver().findElement(By.id("billing-address-select")).sendKeys("n");
		getDriver().findElement(By.id("billing-address-select")).sendKeys(Keys.RETURN);
		getDriver().findElement(By.id("BillingNewAddress_FirstName")).clear();
		getDriver().findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Vasile");
		getDriver().findElement(By.id("BillingNewAddress_LastName")).clear();
		getDriver().findElement(By.id("BillingNewAddress_LastName")).sendKeys("Vasilescu");
		getDriver().findElement(By.id("BillingNewAddress_CountryId")).click();
		getDriver().findElement(By.id("BillingNewAddress_CountryId")).sendKeys("c");
		getDriver().findElement(By.id("BillingNewAddress_CountryId")).sendKeys(Keys.RETURN);
		getDriver().findElement(By.id("BillingNewAddress_City")).clear();
		getDriver().findElement(By.id("BillingNewAddress_City")).sendKeys("Nowhere Town");
		getDriver().findElement(By.id("BillingNewAddress_Address1")).clear();
		getDriver().findElement(By.id("BillingNewAddress_Address1")).sendKeys("Somewhere Street");
		getDriver().findElement(By.id("BillingNewAddress_ZipPostalCode")).clear();
		getDriver().findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("123");
		getDriver().findElement(By.id("BillingNewAddress_PhoneNumber")).clear();
		getDriver().findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("456");
		$("input[type$='button'][title='Continue'][class='button-1 new-address-next-step-button']").click();
		Thread.sleep(1000);
		getDriver().findElement(By.id("shipping-address-select")).click();
		getDriver().findElement(By.id("shipping-address-select")).sendKeys("v");
		getDriver().findElement(By.id("shipping-address-select")).sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		$("input[title$='Continue'][onclick='Shipping.save()']").click();
		Thread.sleep(1000);
		getDriver().findElement(By.id("shippingoption_1")).click();
		$("input[onclick$='ShippingMethod.save()'][value='Continue']").click();
		Thread.sleep(1000);
		getDriver().findElement(By.id("paymentmethod_0")).click();
		$("input[onclick$='PaymentMethod.save()'][value='Continue']").click();
		Thread.sleep(1000);

		$("input[onclick$='PaymentInfo.save()'][value='Continue']").click();
		Thread.sleep(1000);
		
		return this.switchToPage(CheckoutPage.class);
	}
	
	/**
	 * Method used to confirm the order once all information has been filled out
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public CheckoutPage doOrderConfirmation() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		js.executeScript("window.scrollTo(0, 0)");

		waitFor("input[onclick$='ConfirmOrder.save()'][value='Confirm']").$("input[onclick$='ConfirmOrder.save()'][value='Confirm']").click();
		
		Thread.sleep(1000);
		
		waitFor("div[class$='page-body checkout-data']");
		String expectedConfirmation = "Your order has been successfully processed!";
		String actualConfirmation = $("div[class$='page-body checkout-data']").getText();
		System.out.println("\n" + actualConfirmation);
		// Assert.assertTrue(actualConfirmation.contains(expectedConfirmation)); // assertion to verify that the login was successful
		
		return this.switchToPage(CheckoutPage.class);
	}
	
}

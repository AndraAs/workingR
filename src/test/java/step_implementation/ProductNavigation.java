package step_implementation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;

public class ProductNavigation extends PageObject {
	
	public void navigateToProduct () throws InterruptedException {
		$("a[href$='/apparel-shoes']").click(); // can be parameterized if needed
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		js.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(1000);
	}
	
	public void chooseProduct () throws InterruptedException {
		$("a[href$='/blue-jeans']").click(); // can be parameterized if needed, requires use of arrays or hashmaps
		Thread.sleep(1000);
		$("input[type$='button'][class$='button-1 add-to-cart-button'][value$='Add to cart']").click();
		Thread.sleep(1000);
		$("span[class$='cart-label']").click(); // go to cart
		Thread.sleep(1000);
	}
	
	public void fillCheckoutData () throws InterruptedException {
		getDriver().findElement(By.name("CountryId")).click();
		getDriver().findElement(By.name("CountryId")).sendKeys("c");
		getDriver().findElement(By.name("CountryId")).sendKeys(Keys.RETURN);
		getDriver().findElement(By.id("termsofservice")).click();
		$("button[type$='submit'][id='checkout'][name='checkout']").click();
		Thread.sleep(1000);
	}
	
	public void fillExtendedCheckoutData () throws InterruptedException {
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
		Thread.sleep(2000);
		getDriver().findElement(By.id("shipping-address-select")).click();
		getDriver().findElement(By.id("shipping-address-select")).sendKeys("v");
		getDriver().findElement(By.id("shipping-address-select")).sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		$("input[title$='Continue'][onclick='Shipping.save()']").click();
		Thread.sleep(2000);
		getDriver().findElement(By.id("shippingoption_1")).click();
		$("input[onclick$='ShippingMethod.save()'][value='Continue']").click();
		Thread.sleep(1000);
		getDriver().findElement(By.id("paymentmethod_0")).click();
		$("input[onclick$='PaymentMethod.save()'][value='Continue']").click();
		Thread.sleep(1000);

		$("input[onclick$='PaymentInfo.save()'][value='Continue']").click();
		Thread.sleep(1000);
	}

}

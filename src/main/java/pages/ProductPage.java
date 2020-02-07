package pages;

import org.openqa.selenium.JavascriptExecutor;

public class ProductPage extends BasePage {

	/**
	 * Method for choosing desired product from selected product category
	 * 
	 * @return
	 */
	public ProductPage selectProduct() {

		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		js.executeScript("window.scrollTo(0, 0)");

		waitFor("a[href$='/blue-jeans']").$("a[href$='/blue-jeans']").click(); // can be parameterized if needed, requires use of arrays or hashmaps
		waitFor("input[type$='button'][class$='button-1 add-to-cart-button'][value$='Add to cart']").$("input[type$='button'][class$='button-1 add-to-cart-button'][value$='Add to cart']").click();

		return this.switchToPage(ProductPage.class);
	}
}
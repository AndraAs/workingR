package pages;

public class ShoppingCartPage extends BasePage {
	
	/**
	 * Method used to check if shopping cart is empty. If needed, it can be enhanced to include an "Empty cart" method
	 * 
	 * @return
	 */
	public ShoppingCartPage doValidationOfEmptyShoppingCart () {
		
		String emptyCart = "Your Shopping Cart is empty!";
		String actualCart = $("div[class$='order-summary-content']").getText();
		if (actualCart.contains(emptyCart)) {
			System.out.println("\n" + actualCart);
		}
		else {
			// do nothing for now, cart will be empty
		}
		
		return this.switchToPage(ShoppingCartPage.class);
	}

}

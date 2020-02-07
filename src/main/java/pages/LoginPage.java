package pages;

import org.junit.Assert;

public class LoginPage extends BasePage {
	
	private static final String ENTER_EMAIL_LINK = "//input[@id='Email'][@class='email']";

	private static final String ENTER_PASSWORD_LINK = "//input[@id='Password'][@class='password']";

	private static final String LOGIN_BUTTON = "//input[@class='button-1 login-button'][@type='submit']";
	
	/**
	 * Method used to enter the valid username+password and perform login
	 * 
	 * @param userName
	 * @param passWord
	 * @return
	 */
	public DashboardPage doLogin(String userName, String passWord) {
		
		waitFor(ENTER_EMAIL_LINK).$(ENTER_EMAIL_LINK).clear();
		$(ENTER_EMAIL_LINK).type(userName);
		
		$(ENTER_PASSWORD_LINK).clear();
		$(ENTER_PASSWORD_LINK).type(passWord);
		
		$(LOGIN_BUTTON).click();
		
		return this.switchToPage(DashboardPage.class);
		
	}
	
	/**
	 * Method used to check if login was successful
	 * 
	 * @param userName
	 * @return
	 */
	public DashboardPage checkLoginSuccess(String userName) {
		
		String expected = userName;
		String actual = $("/html/body").getText();
		Assert.assertTrue(actual.contains(expected)); // assertion to verify that the login was successful
		
		return this.switchToPage(DashboardPage.class);
	}


}

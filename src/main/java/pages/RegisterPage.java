package pages;

public class RegisterPage extends BasePage {

	private static final String GENDER_MALE_BUTTON = "//input[@id='gender-male'][@type='radio']";

	private static final String GENDER_FEMALE_BUTTON = "//input[@id='gender-female'][@type='radio']";

	private static final String FIRST_NAME_INPUT = "//input[@id='FirstName'][@type='text']";

	private static final String LAST_NAME_INPUT = "//input[@id='LastName'][@type='text']";

	private static final String EMAIL_INPUT = "//input[@id='Email'][@type='text']";

	private static final String PASSWORD_INPUT = "//input[@id='Password'][@type='password']";

	private static final String CONFIRM_PASSWORD_INPUT = "//input[@id='ConfirmPassword'][@type='password']";

	/**
	 * Method used to register a new user
	 * 
	 * @param userName
	 * @param passWord
	 * @param gender
	 * @return
	 * @throws InterruptedException
	 */
	public DashboardPage doRegister(String userName, String passWord, String gender)  {

		getDriver().manage().window().maximize();

		waitFor(FIRST_NAME_INPUT).$(FIRST_NAME_INPUT).clear();
		$(FIRST_NAME_INPUT).type("R");
		
		// fill-in all required data
		
		// choose gender based on preference
		if (gender.equalsIgnoreCase("Male")) {
			$(GENDER_MALE_BUTTON).click();
		}
		else if (gender.equalsIgnoreCase("Female")) {
			$(GENDER_FEMALE_BUTTON).click();
		}
		else {
			System.out.println("\n" + "Non binary gender detacted, does not compute, will terminate.");
			getDriver().quit();
		}
		
		$(LAST_NAME_INPUT).clear();
		$(LAST_NAME_INPUT).type("D");
		
		$(EMAIL_INPUT).clear();
		$(EMAIL_INPUT).type(userName);
		
		$(PASSWORD_INPUT).clear();
		$(PASSWORD_INPUT).type(passWord);
		
		$(CONFIRM_PASSWORD_INPUT).clear();
		$(CONFIRM_PASSWORD_INPUT).type(passWord);
		
		return this.switchToPage(DashboardPage.class);

	}
	
}
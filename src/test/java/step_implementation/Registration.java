package step_implementation;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;

public class Registration extends PageObject {

	public void userRegistration(String userName, String passWord, String gender) throws InterruptedException {

		open();
		
		Thread.sleep(1000);
		
		getDriver().manage().window().maximize(); // maximize the open window

		String pageText = $("/html/body").getText();

		// following if-clause verifies that there is no user logged on the website prior to the actual log-in
		if (pageText.contains("Log out")){
			$("a[href='/logout'][class='ico-logout']").click();
		}

		else  {
			System.out.println("\n" + "No user logged in, proceed to register account and/or login step.");
		}

		$("a[href$='register']").click(); // finds and clicks on Register link using shorthand cssSelector;
		Thread.sleep(1000);

		// fill-in all required data
		// choose gender based on preference
		if (gender.equalsIgnoreCase("Male")) {
			getDriver().findElement(By.id("gender-male")).click();
		}
		else if (gender.equalsIgnoreCase("Female")) {
			getDriver().findElement(By.id("gender-female")).click();
		}
		else {
			System.out.println("\n" + "Non binary gender detacted, does not compute, will terminate.");
			getDriver().quit();
			// return;
		}
		Thread.sleep(500);

		// enter other credentials
		getDriver().findElement(By.id("FirstName")).clear();
		getDriver().findElement(By.id("FirstName")).sendKeys("R");
		getDriver().findElement(By.id("LastName")).clear();
		getDriver().findElement(By.id("LastName")).sendKeys("D");
		getDriver().findElement(By.id("Email")).clear();
		getDriver().findElement(By.id("Email")).sendKeys(userName);
		getDriver().findElement(By.id("Password")).clear();
		getDriver().findElement(By.id("Password")).sendKeys(passWord);
		getDriver().findElement(By.id("ConfirmPassword")).clear();
		getDriver().findElement(By.id("ConfirmPassword")).sendKeys(passWord);

		Thread.sleep(1000);

		// reset the values by clicking on main page link
		getDriver().findElement(By.cssSelector("img[alt='Tricentis Demo Web Shop'][src='/Themes/DefaultClean/Content/images/logo.png']")).click();
		Thread.sleep(1000);
	}

	//	public void userOnLoginPage() throws InterruptedException {
	//		
	//		$("a[href$='login'][class='ico-login']").click();
	//		Thread.sleep(1000);
	//	}

}

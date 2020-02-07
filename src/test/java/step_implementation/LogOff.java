package step_implementation;

import net.serenitybdd.core.pages.PageObject;
import utilities.WaitForPageLoad;

public class LogOff extends PageObject {

	public void userLogsOff (String userName) {
		$("img[alt$='Tricentis Demo Web Shop'][src='/Themes/DefaultClean/Content/images/logo.png']").click(); //return to main page
		$("a[href$='/logout'][class='ico-logout']").click(); // clicks on log-out
		WaitForPageLoad.waitForLoad(getDriver());

		String pageText = $("/html/body").getText();

		// following if-clause verifies that the log-out was successful
		if (pageText.contains(userName)) {
			$("a[href$='/logout'][class='ico-logout']").click();
			System.out.println("Better make sure you are logged off!");
		}
		else {
			System.out.println("\n" + "Log out successful!");
		}
	}

}

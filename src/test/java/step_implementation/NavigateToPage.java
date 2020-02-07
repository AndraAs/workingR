package step_implementation;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import utilities.WaitForPageLoad;

public class NavigateToPage {

@Given ("open up browser and display web page")
public static void openBrowser(WebDriver driver) throws InterruptedException {
		
		driver.navigate().to("http://demowebshop.tricentis.com/"); // navigate to main page
				
		WaitForPageLoad.waitForLoad(driver); // method for page load wait
		driver.manage().window().maximize(); // maximize the open window
		
		Thread.sleep(1000);						
	}		
}

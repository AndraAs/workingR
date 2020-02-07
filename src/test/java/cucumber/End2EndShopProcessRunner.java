package cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
// @RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features/end-2-end-shop-process.feature")
//@CucumberOptions(features="src/test/resources/features", glue="cucumber.steps")
public class End2EndShopProcessRunner {

}
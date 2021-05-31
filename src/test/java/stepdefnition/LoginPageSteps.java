package stepdefnition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.pages.AccountPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;

public class LoginPageSteps {

	HomePage homePage = new HomePage(DriverFactory.getDriver());
	LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	AccountPage accountPage = new AccountPage(DriverFactory.getDriver());

	@Given("I am on home page")
	public void i_am_on_home_page() {
		DriverFactory.getDriver().get("http://automationpractice.com/index.php");
	}

	@Given("I loginas a user")
	public void i_loginas_a_user(DataTable dataTable) {
		homePage.ClickSigninButton();
		List<Map<String, String>> Logindetails = dataTable.asMaps();
		String Username = Logindetails.get(0).get("Username");
		String Password = Logindetails.get(0).get("Password");
		
		loginPage.EnterEmail(Username);
		loginPage.EnterPassword(Password);
		loginPage.ClickSigninButton();

	}

	@Then("I verify the page header name {string}")
	public void i_verify_the_page_header_name(String actualValue) {
	    Assert.assertEquals(accountPage.GetPageSource(), actualValue);
	}
	
	@Then("I verify the below Accountlinks are available")
	public void i_verify_the_below_accountlinks_are_available(DataTable dataTable) {
		List<String> linksDetail= dataTable.asList();
		Assert.assertTrue(accountPage.getAccountLinks().containsAll(linksDetail));
	}
}

package Hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.Utilities.ConfigReader;
import com.qa.factory.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
private DriverFactory driverFactory;
private WebDriver driver;
private ConfigReader configReader;
Properties prop;

@Before (order =0)
public void GetProperty() {
	configReader = new ConfigReader();
	prop = configReader.init_prop();
}

@Before (value = "@Regression", order =0)
public void LaunchBrowser() {
	String browserName = prop.getProperty("browser");
	driverFactory = new DriverFactory();
	driver = driverFactory.init_driver(browserName);
}



@After(order=1)
public void ScreenshotTeardown(Scenario scenario) {
	if (scenario.isFailed()) {
		String screenshotName = scenario.getName().replaceAll("", "_");
		byte[] srcpath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		
		scenario.attach(srcpath, "image/png", screenshotName);
		
	}
}
}

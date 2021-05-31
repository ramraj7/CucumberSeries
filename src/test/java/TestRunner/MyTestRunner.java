package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@Regression", features = {"src\\test\\resources\\AppFeatures"}, glue = {"stepdefnition", "Hooks"},
plugin = {"pretty", "html:report"})
public class MyTestRunner {

}

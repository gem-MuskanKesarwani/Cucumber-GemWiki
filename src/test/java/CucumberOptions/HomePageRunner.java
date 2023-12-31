package CucumberOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features/HomePage.feature",
        glue="StepDefinitions",
        plugin = {"com.gemini.generic.plugin.CucumberJewelPlugin"},
        // plugin = { "pretty","html:target/cucumber-reports"},
        monochrome = true
)
public class HomePageRunner{

}

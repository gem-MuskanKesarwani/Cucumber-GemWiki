package CucumberOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features/Login.feature",
        glue="StepDefinitions",
         plugin = { "com.gemini.generic.plugin.CucumberJewelPlugin"},
        monochrome = true
)
public class Runner1{

}

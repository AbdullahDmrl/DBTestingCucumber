package Runners;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;

@CucumberOptions(
        tags = {"@Regression"},
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},

        plugin = {
                "com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReports/RegressionTestResult.html"

        }
)
public class _1DatabaseRegressionTest extends AbstractTestNGCucumberTests {

       @AfterClass
       public static void afterClass() {
           Reporter.loadXMLConfig("src/test/java/XML_Files/ExtentReportSet.xml");

           Reporter.setSystemInfo("User Name", "A Demirel");
           Reporter.setSystemInfo("Application Name", "Basqar Database Test");
           Reporter.setSystemInfo("Operating System Info", System.getProperty("os.name").toString());
           Reporter.setSystemInfo("Department", "QAr");

           Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
       }
}

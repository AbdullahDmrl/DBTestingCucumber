package Runners;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;

@CucumberOptions(
        features = {"src/test/java/FeatureFiles/_03_StatesFunctionalityApachePOI.feature"},
        glue = {"StepDefinitions"},

        plugin = {
                "com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport/ExtentReportRegression.html"

        }
)
public class _08_TestRunnerExtentReportApache extends AbstractTestNGCucumberTests {

       @AfterClass
       public static void afterClass() {
           Reporter.loadXMLConfig("src/test/java/XML_Files/ExtentReportSet.xml");

           Reporter.setSystemInfo("User Name", "A Demirel");
           Reporter.setSystemInfo("Application Name", "Basqar");
           Reporter.setSystemInfo("Operating System Info", System.getProperty("os.name").toString());
           Reporter.setSystemInfo("Department", "QAr");
           Reporter.setSystemInfo("Ek Satır", "Acıklamasi");

           Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
       }
}

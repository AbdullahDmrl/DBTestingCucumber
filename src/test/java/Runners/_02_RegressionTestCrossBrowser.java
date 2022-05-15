package Runners;

import Utilities.BaseDriver;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

@CucumberOptions(
        tags = {"@Regression"},
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},

        plugin = {
                "com.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport/TestResultsCrossBrowser.html"

        }
)
public class _02_RegressionTestCrossBrowser extends AbstractTestNGCucumberTests {

    @BeforeClass
    @Parameters("browser")
    public void beforeClass(String browser)
    {
       BaseDriver.threadBrowserName.set(browser);

    }

       @AfterClass
       public static void afterClass() {
           Reporter.loadXMLConfig("src/test/java/XML_Files/ExtentReportSet.xml");

           Reporter.setSystemInfo("User Name", "A Demirel");
           Reporter.setSystemInfo("Application Name", "Basqar DB Test Cross Browser");
           Reporter.setSystemInfo("Operating System Info", System.getProperty("os.name").toString());
           Reporter.setSystemInfo("Department", "QAr");
           Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
       }
}

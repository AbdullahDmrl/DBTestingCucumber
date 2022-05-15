package StepDefinitions;

import Utilities.BaseDriver;
import Utilities.ExcelUtility;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {

    @Before
    public void before(Scenario scenario)
    {
        System.out.println("Scenario start");
        System.out.println("Scenario name="+scenario.getName());
        System.out.println("Scenario Id="+scenario.getId());



    }

    @After
    public void after(Scenario scenario)
    {
        System.out.println("Scenario completed");
        System.out.println("Scenario result= "+scenario.getStatus());
        System.out.println();

        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd.MM.yyyy");

        if (scenario.isFailed()){
            TakesScreenshot tss=(TakesScreenshot) BaseDriver.getDriver();
            File screenShots=tss.getScreenshotAs(OutputType.FILE);

           try {
               FileUtils.copyFile(screenShots,new File("target/FailedScreenShots/"+scenario.getId()+date.format(formatter)+".png"));

           } catch (IOException e) {
               e.printStackTrace();
           }
        }

        ExcelUtility.writeExcel("src/test/java/Excel/resources/ScenarioStatus.xlsx",
        scenario,BaseDriver.threadBrowserName.get(), date.format(formatter));
         BaseDriver.quitDriver();
    }

}

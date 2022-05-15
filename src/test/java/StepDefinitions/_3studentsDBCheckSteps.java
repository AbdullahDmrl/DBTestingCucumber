package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Utilities.DBUtilities;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class _3studentsDBCheckSteps {
    DialogContent dc = new DialogContent();
    LeftNav ln=new LeftNav();

    @And("^Navigate to students page$")
    public void navigateToStudentsPage() {
        ln.findAndClick("Student");
        ln.findAndClick("Students");

    }
    @When("^Create MySQL students table and insert values by jdbc$")
    public void createMySQLStudentsTableAndInsertValuesByJdbc() {
        List<String> tableName = DBUtilities.getNamesOfTables("show tables");

        if (!tableName.contains("StudentsData")) {
            DBUtilities.createTable("create table StudentsData(\n" +
                    " id int auto_increment primary key,\n" +
                    " FullName varchar(50) not null,\n" +
                    " Grade int not null,\n" +
                    " Status varchar(50) not null\n" + ");");

            DBUtilities.insertIntoTable("insert into StudentsData (FullName,Grade,Status) values ('Adam David Diaz','2','Active')");
            DBUtilities.insertIntoTable("insert into StudentsData (FullName,Grade,Status) values ('Allison Owens','2','Active')");
            DBUtilities.insertIntoTable("insert into StudentsData (FullName,Grade,Status) values ('Bailey Small','2','Active')");
            DBUtilities.insertIntoTable("insert into StudentsData (FullName,Grade,Status) values ('Brandon Murray','2','Active')");
            DBUtilities.insertIntoTable("insert into StudentsData (FullName,Grade,Status) values ('David Singh','2','Active')");
            DBUtilities.insertIntoTable("insert into StudentsData (FullName,Grade,Status) values ('David Matthew Hayden','2','Active')");
            DBUtilities.insertIntoTable("insert into StudentsData (FullName,Grade,Status) values ('Ehrenfried Sauberlich','2','Active')");
            DBUtilities.insertIntoTable("insert into StudentsData (FullName,Grade,Status) values ('Heather Mills','2','Active')");
            DBUtilities.insertIntoTable("insert into StudentsData (FullName,Grade,Status) values ('James Raymond Wilson','2','Active')");
            DBUtilities.insertIntoTable("insert into StudentsData (FullName,Grade,Status) values ('Jean Marty','2','Active')");

        }
    }

    @When("^Select \"([^\"]*)\" status and \"([^\"]*)\" grade level then search students$")
    public void selectStatusAndGradeLevelThenSearchStudents(String status, String grade) {
        dc.findAndClick("gradeLevel");
        dc.listWebelementsSelect("countryAllOptions",grade);
        dc.findAndClick("Status");
        dc.listWebelementsSelect("countryAllOptions",status);
        dc.findAndClick("searchDialog");

        }

    @Then("^Check database data match with UI results data$")
    public void checkStudentsDataMatchWithDatabaseAndUIResults() {
        List<List<String>> dbList= DBUtilities.getlistData("select * from StudentsData");
        List<List<String>> uiList=new ArrayList<>();
        List<WebElement> studentIDList=dc.listWebelements("studentIDList");
        List<WebElement> studentsFullnameList=dc.listWebelements("studentsFullnameList");
        List<WebElement> studentsgradeLevelList=dc.listWebelements("studentsgradeLevelList");
        List<WebElement> studentsstatusLevelList=dc.listWebelements("studentsstatusLevelList");

        for (int j = 0; j < studentIDList.size(); j++) {
            List<String> rowList=new ArrayList<>();
            rowList.add(studentIDList.get(j).getText());
            rowList.add(studentsFullnameList.get(j).getText());
            rowList.add(studentsgradeLevelList.get(j).getText());
            rowList.add(studentsstatusLevelList.get(j).getText());
            uiList.add(rowList);
        }
       // System.out.println("desiredList = " + uiList);  Check

         for (int i = 0; i < uiList.size(); i++) {
            for (int j = 0; j < uiList.get(i).size(); j++) {
                //  System.out.println(uiList.get(i).get(j)+" "+dbList.get(i).get(j)); // Check
                Assert.assertTrue(uiList.get(i).get(j).contains(dbList.get(i).get(j)));
            }
        }




    }
}



      
    


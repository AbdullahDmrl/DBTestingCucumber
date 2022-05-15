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

import java.util.List;

public class _1statesDBCheckSteps {
    DialogContent dc = new DialogContent();
    LeftNav ln=new LeftNav();


    @And("^Navigate to states page$")
    public void navigateToStatesAndEnterAndGetFirstTenStates()  {
        ln.findAndClick("setupOne");
        ln.findAndClick("parameters");
        ln.findAndClick("staTes");
    }

    @Then("^Create states table and insert values with jdbc$")
    public void createTableAndInsertValuesWithJdbc() {
        List<String> tableName = DBUtilities.getNamesOfTables("show tables");

        if (!tableName.contains("States")) {
            DBUtilities.createTable("create table States(\n" +
                    " id int primary key,\n" +
                    " Name varchar(50) not null,\n" +
                    " ShortName varchar(50) not null,\n" +
                    " Country varchar(50) not null\n" + ");");

            DBUtilities.insertIntoTable("insert into States (id,Name,ShortName,Country) values ('1','Alabama','AL','United States of America')");
            DBUtilities.insertIntoTable("insert into States (id, Name,ShortName,Country) values ('2', 'Alaska','AK','United States of America' )");
            DBUtilities.insertIntoTable("insert into States (id, Name,ShortName,Country) values ('3', 'Arizona','AZ','United States of America' )");
            DBUtilities.insertIntoTable("insert into States (id, Name,ShortName,Country) values ('4', 'Arkansas','AR','United States of America' )");
            DBUtilities.insertIntoTable("insert into States (id, Name,ShortName,Country) values ('5', 'California','CA','United States of America' )");
            DBUtilities.insertIntoTable("insert into States (id, Name,ShortName,Country) values ('6', 'Colorado','CO','United States of America' )");
            DBUtilities.insertIntoTable("insert into States (id, Name,ShortName,Country) values ('7', 'Connecticut','CT','United States of America' )");
            DBUtilities.insertIntoTable("insert into States (id, Name,ShortName,Country) values ('8', 'Delaware','DE','United States of America' )");
            DBUtilities.insertIntoTable("insert into States (id, Name,ShortName,Country) values ('9', 'Dictrict of Columbia','DC','United States of America' )");
            DBUtilities.insertIntoTable("insert into States (id, Name,ShortName,Country) values ('10', 'Florida','FL','United States of America' )");
        }
     }

    @And("^Select country \"([^\"]*)\" and show its states$")
    public void selectCountryAndGetFirstTenStates(String name)  {
        dc.findAndClick("statesCountry");
        dc.listWebelementsSelect("countryAllOptions",name);

    }



    @Then("^Check Database and UI results match$")
    public void checkDatabaseAndUIResultsMatch() {

        List<WebElement> uiList=dc.listWebelements("elementsList");
        List<List<String>> dbList= DBUtilities.getlistData("select * from States");

        for (int i = 0; i < uiList.size(); i++) {
            for (int j = 0; j < dbList.get(i).size(); j++) {
              //  System.out.println(uiList.get(i).getText()+" "+dbList.get(i).get(j)); // kontrol icin yazildi
                Assert.assertTrue(uiList.get(i).getText().contains(dbList.get(i).get(j)));
            }
        }


    }
}

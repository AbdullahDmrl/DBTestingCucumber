package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Pages.Parent;
import Utilities.DBUtilities;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class _2citiesDBCheckSteps {
    DialogContent dc = new DialogContent();
    LeftNav ln = new LeftNav();

    @And("^Navigate to cities page$")
    public void navigateToCitiesPage() {
        ln.findAndClick("setupOne");
        ln.findAndClick("parameters");
        ln.findAndClick("cities");
        Parent.delay(1);


    }

    @When("^Create MySQL cities table and insert values with jdbc$")
    public void createMySQLCitiesTableAndInsertValuesWithJdbc() {
        List<String> tableName = DBUtilities.getNamesOfTables("show tables");

        if (!tableName.contains("CitiesOfSweden")) {
            DBUtilities.createTable("create table CitiesOfSweden(\n" +
                    " id int auto_increment primary key,\n" +
                    " Name varchar(50) not null,\n" +
                    " Country varchar(50) not null\n" + ");");

            DBUtilities.insertIntoTable("insert into CitiesOfSweden (Name,Country) values ('Blekinge','Sweden')");
            DBUtilities.insertIntoTable("insert into CitiesOfSweden (Name,Country) values ('Dalarna','Sweden')");
            DBUtilities.insertIntoTable("insert into CitiesOfSweden (Name,Country) values ('Gotland','Sweden')");
            DBUtilities.insertIntoTable("insert into CitiesOfSweden (Name,Country) values ('Halland','Sweden')");
            DBUtilities.insertIntoTable("insert into CitiesOfSweden (Name,Country) values ('Kalmar','Sweden')");
            DBUtilities.insertIntoTable("insert into CitiesOfSweden (Name,Country) values ('Kronoberg','Sweden')");
            DBUtilities.insertIntoTable("insert into CitiesOfSweden (Name,Country) values ('Stockholm','Sweden')");
            DBUtilities.insertIntoTable("insert into CitiesOfSweden (Name,Country) values ('Uppsala','Sweden')");

        }
    }

    @When("^Select country \"([^\"]*)\"$")
    public void selectCountry(String name) {
        dc.findAndClick("statesCountry");
        dc.listWebelementsSelect("countryAllOptions",name);

    }

    @Then("^Send Query and check both database/UI results match$")
    public void sendQueryAndCheckBothDatabaseUIResultsMatch() {
        List<WebElement> uiList=dc.listWebelements("elementsList");
        List<List<String>> dbList= DBUtilities.getlistData("select * from CitiesOfSweden");

        for (int i = 0; i < uiList.size(); i++) {
            for (int j = 0; j < dbList.get(i).size(); j++) {
                //  System.out.println(uiList.get(i).getText()+" "+dbList.get(i).get(j)); // kontrol icin yazildi
                Assert.assertTrue(uiList.get(i).getText().contains(dbList.get(i).get(j)));
            }
        }


    }
}

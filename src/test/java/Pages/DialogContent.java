package Pages;

import Utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DialogContent extends Parent{

    public DialogContent() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(id="mat-input-0")
    private WebElement username;

    @FindBy(id="mat-input-1")
    private WebElement password;

    @FindBy(css="button[aria-label='LOGIN']")
    private WebElement loginButton;

    @FindBy(xpath = "(//span[contains(text(),'Dashboard')])[2]")
    public WebElement dashboard;

    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    private WebElement addButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
    private WebElement nameInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']//input")
    private WebElement codeInput;

    @FindBy(xpath = "//ms-text-field[contains(@formcontrolname,'IntegrationCode')]//input")
    private WebElement integrationCodeInput;

    @FindBy(xpath = "//ms-integer-field[@formcontrolname='priority']//input")
    private WebElement priorityInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']//input")
    private WebElement shortName;

    @FindBy(xpath = "//ms-save-button//button")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    public WebElement successMessage;

    @FindBy(xpath = "//div[contains(text(),'error')]")
    public WebElement errorMessage;

    @FindBy(xpath = "//div[contains(text(),'already exists')]")
    public WebElement alreadyExist;

    @FindBy(xpath = "//button[@aria-label='Close dialog']")
    private WebElement closeDialog;

    @FindBy(css = "ms-text-field[placeholder='GENERAL.FIELD.NAME']>input")
    private WebElement searchInput;

    @FindBy(css = "ms-search-button>div.control-full>button")
    private WebElement searchButton;

    @FindBy(xpath = "//ms-delete-button//button")
    private WebElement deleteButton;

    @FindBy(xpath = "//span[contains(text(),'Delete')]")
    private WebElement confirmDeleteBtn;


    @FindBy(xpath = "//mat-chip-list//input")
    private WebElement userInput;

    @FindBy(xpath = "//mat-option//span")
    private List<WebElement> userOptions;

    @FindBy(xpath = "(//button[@class='consent-give'])[1]")
    private WebElement acceptCookies;

    @FindBy(xpath = "//tbody//tr")    // direk görmek icin puplic yaptim
    public List<WebElement> nameListAll;

    @FindBy(xpath = "//tbody/tr/td[2]")
    public List<WebElement> nameList;

    @FindBy(xpath = "//mat-select[contains(@aria-labelledby,'mat-form-field')]")
    private WebElement countrySelect;

    @FindBy(css = "div>mat-option")
    private List<WebElement> countryAllOptions;

    @FindBy(xpath = "//mat-select[@role='combobox']/div")
    private WebElement statesCountry;

    @FindBy(xpath = "//table/tbody/tr")
    private List<WebElement> elementsList;

    @FindBy(xpath = "//div//span[text()='Status']")
    private WebElement Status;

    @FindBy(xpath = "//div//span[text()='Grade Level']")
    private WebElement gradeLevel;

    @FindBy(xpath = "//div/ms-search-button")
    private WebElement searchDialog;


   @FindBy(xpath = "//table/tbody/tr/td[1]")
    private List<WebElement> studentIDList;

    @FindBy(xpath = "//table/tbody/tr/td[3]")
    private List<WebElement> studentsFullnameList;
    @FindBy(xpath = "//table/tbody/tr/td[7]")
    private List<WebElement> studentsgradeLevelList;

    @FindBy(xpath = "//table/tbody/tr/td[9]")
    private List<WebElement> studentsstatusLevelList;

//div/ms-search-button

    WebElement myElement;
    List<WebElement> myelemnts;

    public void findAndSend(String elementName,String value)
    {
          switch (elementName) {
              case "username": myElement = username;  break;
              case "password": myElement = password; break;
              case "nameInput":myElement = nameInput; break;
              case "codeInput": myElement = codeInput; break;
              case "shortName": myElement = shortName; break;
              case "searchInput":myElement = searchInput; break;
              case "integrationCodeInput":myElement = integrationCodeInput; break;
              case "priorityInput":myElement = priorityInput; break;
          }

          sendKeysFunction(myElement, value);
    }

    public void findAndClick(String elementName)
    {
        switch (elementName) {
            case "loginButton": myElement = loginButton; break;
            case "addButton":myElement = addButton; break;
            case "saveButton": myElement = saveButton;break;
            case "closeDialog":myElement = closeDialog; break;
            case "searchButton":myElement = searchButton; break;
            case "deleteButton":myElement = deleteButton; break;
            case "confirmDeleteBtn":myElement = confirmDeleteBtn; break;
            case "userInput":myElement = userInput; break;
            case "acceptCookies":myElement = acceptCookies; break;
            case "countrySelect":myElement = countrySelect; break;
            case "statesCountry":myElement = statesCountry; break;
            case "Status":myElement = Status; break;
            case "gradeLevel":myElement = gradeLevel; break;
            case "searchDialog":myElement = searchDialog; break;
        }

        clickFunction(myElement);

        if (myElement==searchButton){

            waitnumberOfElementsToBeLessThan(By.xpath("//ms-delete-button//button"),5);
        }
    }

    public void findAndContainsText(String elementName, String msg)
    {
        switch (elementName) {
            case "successMessage": myElement = successMessage; break;
            case "errorMessage":myElement = errorMessage; break;
            case "alreadyExist":myElement = alreadyExist;break;
        }

        verifyContainsText(myElement, msg);
    }

    public void invisibilityOfElement(String elementName)
    {
        switch (elementName) {
            case "successMessage": myElement = successMessage; break;

        }
        waitUntilInvisibility(myElement);
    }

    public void findAndDelete(String name)
    {
        findAndSend("searchInput", name);
        findAndClick("searchButton");
        waitnumberOfElementsToBeLessThan(By.xpath("//ms-delete-button//button"),4);
        findAndClick("deleteButton");
        findAndClick("confirmDeleteBtn");

    }

    public List<WebElement> listWebelements(String listName)
    {
        switch (listName) {

            case "elementsList": myelemnts=elementsList; break;
            case "studentIDList": myelemnts=studentIDList; break;
            case "studentsFullnameList": myelemnts=studentsFullnameList; break;
            case "studentsgradeLevelList": myelemnts=studentsgradeLevelList; break;
            case "studentsstatusLevelList": myelemnts=studentsstatusLevelList; break;
        }

      return   waitVisibleListAllElementAndSend(myelemnts);

    }


    public void listWebelementsSelect(String listName, String option )
    {
        switch (listName) {

            case "userOptions": myelemnts=userOptions; break;
            case "countryAllOptions": myelemnts=countryAllOptions; break;


        }

        for(WebElement e: myelemnts)
        {
            if (e.getText().contains(option)) {
                e.click();
                break;
            }
        }

    }




}

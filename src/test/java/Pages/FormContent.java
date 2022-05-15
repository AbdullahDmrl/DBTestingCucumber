package Pages;

import Utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FormContent extends Parent {
    public FormContent() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(id = "mat-select-value-7")
    private WebElement academicPeriod;

    @FindBy(css = "span.mat-option-text")
    private WebElement academicOption;

    @FindBy(id = "mat-select-value-9")
    private WebElement gradeLevel;

    @FindBy(xpath = "(//span[@class='mat-option-text'])[2]")
    private WebElement graOption1;

    @FindBy(xpath = "(//span[@class='mat-option-text'])[3]")
    private WebElement graOption2;

    @FindBy(xpath = "(//span[@class='mat-option-text'])[4]")
    private WebElement graOption3;

    @FindBy(xpath = "(//span[@class='mat-option-text'])[5]")
    private WebElement graOption4;

    @FindBy(xpath = "//ms-save-button//button")
    private WebElement saveButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
    private WebElement nameInput;

    @FindBy(xpath = "//ms-delete-button//button")
    private List <WebElement> deleteBtns;

    @FindBy(css = "input[data-placeholder=Name]")
    private WebElement searchInput;

    @FindBy(xpath = "//ms-search-button//button")
    private WebElement searchBtn;

    @FindBy(xpath = "//ms-delete-button//button")
    private WebElement deleteBtn;

    @FindBy(css = "button[type=submit]")
    private WebElement confirmdeleteBtn;

    @FindBy(css = "ms-text-field[formcontrolname='firstName']>input")
    private WebElement empFirstName;
    @FindBy(css = "ms-text-field[formcontrolname='lastName']>input")
    private WebElement empLastName;

    @FindBy(xpath = "//mat-select[@formcontrolname='gender']")
    private WebElement gender;
    @FindBy(xpath = "(//mat-option//span)[1]")
    private WebElement otherGender;
    @FindBy(xpath = "(//mat-option//span)[2]")
    private WebElement male;
    @FindBy(xpath = "(//mat-option//span)[3]")
    private WebElement female;

    @FindBy(xpath = "(//span[text()='Employee Type'])[1]")
    private WebElement employeeType;
    @FindBy(xpath = "(//mat-option//mat-pseudo-checkbox)[1]")
    private WebElement teacher;
    @FindBy(xpath = "(//mat-option//mat-pseudo-checkbox)[2]")
    private WebElement supervisor;
    @FindBy(xpath = "(//mat-option//mat-pseudo-checkbox)[3]")
    private WebElement otherEmployee;

    @FindBy(css = "input[formcontrolname='employeeId']")
    private WebElement EmployeeId;

    @FindBy(xpath = "//mat-select[@formcontrolname='type']")
    private WebElement documentType;
    @FindBy(xpath = "(//mat-option//span)[1]")
    private WebElement personalId;
    @FindBy(xpath = "(//mat-option//span)[2]")
    private WebElement passport;
    @FindBy(xpath = "(//mat-option//span)[3]")
    private WebElement birthCertificate;

    @FindBy(xpath = "(//mat-form-field//input)[9]")
    private WebElement documentNum;
    @FindBy(css = "ms-text-field[placeholder='GENERAL.FIELD.FIRST_NAME']>input")
    private WebElement empsearchInput;



    WebElement myElement;
    List<WebElement> myelemnts;

    public void findAndSend(String elementName,String value)
    {
        switch (elementName) {
            case "searchInput":myElement = searchInput; break;
            case "empFirstName":myElement = empFirstName; break;
            case "empLastName":myElement = empLastName; break;
            case "EmployeeId":myElement = EmployeeId; break;
            case "documentNum":myElement = documentNum; break;
            case "empsearchInput":myElement = empsearchInput; break;

        }
        sendKeysFunction(myElement, value);
    }

    public void findAndClick(String elementName)
    {
        switch (elementName) {
            case "academicPeriod": myElement = academicPeriod; break;
            case "academicOption": myElement = academicOption; break;
            case "gradeLevel": myElement = gradeLevel; break;
            case "graOption1": myElement = graOption1; break;
            case "graOption2": myElement = graOption2; break;
            case "graOption3": myElement = graOption3; break;
            case "graOption4": myElement = graOption4; break;
            case "saveButton": myElement = saveButton; break;
            case "searchBtn": myElement = searchBtn; break;
            case "deleteBtn": myElement = deleteBtn; break;
            case "confirmdeleteBtn": myElement = confirmdeleteBtn; break;
            case "gender": myElement = gender; break;
            case "otherGender": myElement = otherGender; break;
            case "male": myElement = male; break;
            case "female": myElement = female; break;
            case "employeeType": myElement = employeeType; break;
            case "teacher": myElement = teacher; break;
            case "supervisor": myElement = supervisor; break;
            case "otherEmployee": myElement = otherEmployee; break;
            case "documentType": myElement = documentType; break;
            case "personalId": myElement = personalId; break;
            case "passport": myElement = passport; break;
            case "birthCertificate": myElement = birthCertificate; break;
        }

        clickFunction(myElement);
        if ( myElement == supervisor) {
           ESCClick();
        }

        if ( myElement == personalId) {
            ESCClick();
        }
    }

    public void findAndDelete(String name)
    {
        findAndSend("searchInput", name);
        findAndClick("searchBtn");
        waitnumberOfElementsToBeLessThan(By.xpath("//ms-delete-button//button"),8);
        findAndClick("deleteBtn");
        findAndClick("confirmdeleteBtn");
    }



}

package Pages;

import Utilities.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNav extends Parent{

    public LeftNav() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[text()='Setup'])[1]")
    private WebElement setupOne;

    @FindBy(xpath = "//span[text()='Parameters']")
    private WebElement parameters;

    @FindBy(xpath = "//span[text()='Countries']")
    private WebElement country;

    @FindBy(xpath = "//span[text()='Citizenships']")
    private WebElement citizenShip;

    @FindBy(xpath = "//span[text()='States']")
    private WebElement staTes;


    @FindBy(xpath = "(//span[text()='Inventory'])[1]")
    private WebElement inventoryBtn;

    @FindBy(xpath = "(//span[text()='Setup'])[4]")
    private WebElement setupBtn;

    @FindBy(xpath = "//span[text()='Item Categories']")
    private WebElement itemcategoryBtn;

    @FindBy(xpath = "//span[text()='Education']")
    private WebElement Education;
    @FindBy(xpath = "(//span[text()='Setup'])[5]")
    private WebElement EducationSetUp;
    @FindBy(xpath = "(//span[text()='Subject Categories'])[1]")
    private WebElement EducationSetUpCat;
    @FindBy(xpath = "//span[text()='Nationalities']")
    private WebElement nationalities;
    @FindBy(xpath = "//span[text()='Fees']")
    private WebElement fees;
    @FindBy(xpath = "//span[text()='Entrance Exams']")
    private WebElement entranceExam;

    @FindBy(xpath = "(//span[text()='Setup'])[2]")
    private WebElement examSetup;

    @FindBy(xpath = "(//span[text()='Entrance Exams'])[2]")
    private WebElement entranceExamInserted;


    @FindBy(xpath = "//span[text()='Human Resources']")
    private WebElement humanResource;

    @FindBy(xpath = "//span[text()='Employees']")
    private WebElement emploYee;

    @FindBy(xpath = "(//span[text()='Cities'])[1]")
    private WebElement cities ;

    @FindBy(xpath = "//span[text()='Student']")
    private WebElement Student;

    @FindBy(xpath = "//span[text()='Students']")
    private WebElement Students;



    WebElement myElement;
    public void findAndClick(String elementName)
    {
        switch (elementName) {
            case "setupOne":myElement = setupOne; break;
            case "parameters":myElement = parameters; break;
            case "Countries": myElement = country; break;
            case "citizenShip":myElement = citizenShip;break;
            case "inventoryBtn":myElement = inventoryBtn;break;
            case "setupBtn":myElement = setupBtn;break;
            case "itemcategoryBtn":myElement = itemcategoryBtn;break;
            case "Education":myElement = Education;break;
            case "EducationSetUp":myElement = EducationSetUp;break;
            case "EducationSetUpCat":myElement = EducationSetUpCat;break;
            case "nationalities":myElement = nationalities;break;
            case "fees":myElement = fees;break;
            case "entranceExam":myElement = entranceExam;break;
            case "examSetup":myElement = examSetup;break;
            case "entranceExamInserted":myElement = entranceExamInserted;break;
            case "humanResource":myElement = humanResource;break;
            case "emploYee":myElement = emploYee;break;
            case "cities":myElement = cities;break;
            case "staTes":myElement = staTes;break;
            case "Student":myElement = Student;break;
            case "Students":myElement = Students;break;
        }

        clickFunction(myElement);
    }
}

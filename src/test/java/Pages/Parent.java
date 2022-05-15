package Pages;

import Utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class Parent {

    public void sendKeysFunction(WebElement element, String value)
    {
        waitUntilVisible(element); // element gözükene kadar bekle
        scrollToElement(element); // element e kadar javascript ile kaydır
        element.clear();// elemntin için temizle
        element.sendKeys(value); // valueyi  gönder
    }

    public void clickFunction(WebElement element)
    {
        waitUntilClickable(element); // element clickable kadar bekle
        scrollToElement(element); // element e kadar javascript ile kaydır
        element.click(); // click yap
    }

    public static void waitUntilVisible(WebElement element){
        WebDriverWait wait=new WebDriverWait(BaseDriver.getDriver(),20);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public static void waitUntilInvisibility(WebElement element){
        WebDriverWait wait =new WebDriverWait(BaseDriver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }



    public void scrollToElement(WebElement element){
        JavascriptExecutor js= (JavascriptExecutor) BaseDriver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
    public void scrollToUpElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) BaseDriver.getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'top:0px')", element);
        js.executeScript("arguments[0].scrollIntoView();", element);

    }

    public static void scrollFunction()
    {
        JavascriptExecutor js= (JavascriptExecutor)BaseDriver.getDriver();
        // js.executeScript("window.scrollBy(0,1500)");
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public void waitUntilClickable(WebElement element){
        WebDriverWait wait=new WebDriverWait(BaseDriver.getDriver(),20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Kendisine gönderilen ElementList i gözükene kadar bekleyip,
    // bütün elementler gözüktüğünde geri gönderdi
    public List<WebElement> waitVisibleListAllElementAndSend(List<WebElement> elementList){
        WebDriverWait wait=new WebDriverWait(BaseDriver.getDriver(),10);
       // wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
        return elementList;
    }

    public static void delay(int second)
    {
        try {
            Thread.sleep(1000*second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void verifyContainsText(WebElement element, String msg)
    {
        waitUntilVisible(element);
        Assert.assertTrue(element.getText().toLowerCase().contains(msg.toLowerCase()));
    }

    public void selectFunction(WebElement element,String text)
    {
        Select select=new Select(element);
        select.selectByVisibleText(text);
        // select.selectByValue(text);
    }


    public void waitnumberOfElementsToBeLessThan(By selector, int number)
    {
        WebDriverWait wait=new WebDriverWait(BaseDriver.getDriver(),20);
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(selector,number));
    }

    public void waitprecenceOfElementsLocatedBy(By selector)
    {
        WebDriverWait wait=new WebDriverWait(BaseDriver.getDriver(),20);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(selector));
    }

    public void waitStalenessofElement(WebElement element)
    {
        WebDriverWait wait=new WebDriverWait(BaseDriver.getDriver(),20);
        wait.until(ExpectedConditions.stalenessOf(element));
    }


    public void ESCClick()
    {
        try {
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_ESCAPE);
            r.keyRelease(KeyEvent.VK_ESCAPE);
        } catch (AWTException e) {
            e.printStackTrace();
        }

//        Actions actions=new Actions(BaseDriver.getDriver());
//        Action action= actions.sendKeys(Keys.ESCAPE).build();
//        action.perform();
    }



}

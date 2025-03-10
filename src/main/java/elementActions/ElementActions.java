package elementActions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElementActions {

   private WebDriver driver;


    public ElementActions(WebDriver driver){
        this.driver=driver;
    }

    public ElementActions click(By eleLocator){
       // System.out.println("Click On:"+eleLocator.toString());
        driver.findElement(eleLocator).click();
        return this;
    }

    public ElementActions fillTextField(By eleLocator , String text){
        //System.out.println("Fill Field:" +eleLocator.toString() +"With:"+text);
        driver.findElement(eleLocator).sendKeys(text);
        return this;
    }

    public ElementActions clearTextField(By eleLocator){
        //System.out.println("Clear Field :"+eleLocator.toString());
        driver.findElement(eleLocator).clear();
        return this;
    }

    public String getTxtOf (By eleLocator){
       return driver.findElement(eleLocator).getText();

    }

    public Boolean isDisplayed(By eleLocator){
        return driver.findElement(eleLocator).isDisplayed();
    }
    public Boolean isSelected(By eleLocator){
        return driver.findElement(eleLocator).isSelected();
    }
    public Boolean isClickable(By eleLocator){
        return driver.findElement(eleLocator).isEnabled();
    }

    public ElementActions selectFromDropDownByVisibleText(By dropDownLocator , String optionName){
        WebElement DropDown = driver.findElement(dropDownLocator);
        new Select(DropDown).selectByVisibleText(optionName);
        return this;
    }

    public ElementActions selectFromDropDownByIndex(By dropDownLocator , int optionIndex){
        WebElement DropDown = driver.findElement(dropDownLocator);
        new Select(DropDown).selectByIndex(optionIndex);
        return this;
    }

    public ElementActions selectFromDropDownByValue(By dropDownLocator , String value){
        WebElement DropDown = driver.findElement(dropDownLocator);
        new Select(DropDown).selectByValue(value);
        return this;
    }


    public ElementActions scrollToElement(By eleLocator){
        new Actions(driver).scrollToElement(driver.findElement(eleLocator)).build().perform();
        return this;
    }

    public ElementActions scrollToElementUsingJs(By eleLocator){

        WebElement element = driver.findElement(eleLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        // btn.click();
        return this;
    }

    public ElementActions hoverOnItem(By eleLocator){
        new Actions(driver).moveToElement(driver.findElement(eleLocator)).click().build().perform();
        return this;
    }
}

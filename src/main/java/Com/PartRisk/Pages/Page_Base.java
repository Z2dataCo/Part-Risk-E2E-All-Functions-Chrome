package Com.PartRisk.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Page_Base {

    public JavascriptExecutor jse;
    public Select select;
    public Actions action;
    protected WebDriver driver;

    public Page_Base(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    protected static void Click_Button(WebElement button) {
        try { button.click(); }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
       { button.click(); }
    }
    protected static void Set_Text_Element_Text(WebElement textElement, String value) {
        textElement.sendKeys(value);
    }

    public void Scroll_To_Bottom() {
        jse.executeScript("scrollBy(0,2500)");
    }

    public void Scroll_To_Middle() {
        jse.executeScript("window.scrollBy(0,2000)");
    }

    public void Scroll_to_Element(WebElement element) throws InterruptedException {
        jse.executeScript("arguments[0].scrollIntoView(true);",element);
        Thread.sleep(500);
    }

    public void Clear_Text(WebElement element) {
        element.clear();
    }

    public void Action() {
    }
}
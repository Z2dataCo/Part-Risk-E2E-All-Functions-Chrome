package Com.PartRisk.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Scrub_Page extends Page_Base {
    public Scrub_Page(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"scrub_content\"]/div/table/tbody")
    public WebElement Table;
    @FindBy(xpath = "//*[@id=\"scrub_content\"]/div/div[1]/div[1]/div/div[2]")
    public WebElement Exact_Matches;
    @FindBy(xpath = "//*[@id=\"scrub_content\"]/div/div[2]/div[2]/app-z2pagination/span/span[2]")
    public WebElement FixedNumber;
    @FindBy(xpath = "//a[contains(text(),'Last')]")
    public WebElement Last;
    @FindBy(xpath = "//li[.='Next']/preceding-sibling::li[position()<2] ")
    public WebElement LastPage ;


    public void Z2D_Last_Pagination() {
        Click_Button(Last);
    }
    }


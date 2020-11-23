package Com.PartRisk.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class Mitigation_Page extends Page_Base {
    @FindBy(xpath = "//*[@id=\"RemainMainPage\"]/app-risk-manager/div[2]/div/div/div/div/label/div")
    public WebElement Switchers;
    @FindBy(xpath = "/tbody/tr[10]/td[4]/div[1]/a[1]")
    WebElement Drop_Crosses;
    @FindBy(xpath = "//*[@id=\"dropbg\"]/div/div/div[2]/table[2]/tbody/tr[2]/td[1]/button")
    WebElement Add_Crosses;
    // @FindBy(xpath = "//*[@id=\"RemainMainPage\"]/app-risk-manager/app-risk-mitigation/app-riskmitigationipn/div[1]/div[1]/div/div/div[1]")
    // WebElement Total_Filter;
    @FindBy(className = "nav-link active")
    public WebElement Mitigation_Tab;
    // @FindBy(xpath = "//div[@class='z2-scorecard scorecard-parts']/div[1]/div[2]/div[1]")
    // public WebElement Total_Parts;
    @FindBy(xpath = "//div[@class='z2-scorecard scorecard-parts']/div[2]/div[2]/div[1]")
    public WebElement Active_Parts;
    @FindBy(xpath = "//div[@class='z2-scorecard scorecard-parts']/div[3]/div[2]/div[1]")
    public WebElement NRND_Parts;
    @FindBy(xpath = "//div[@class='z2-scorecard scorecard-parts']/div[4]/div[2]/div[1]")
    public WebElement End_Of_Life_Parts;
    @FindBy(xpath = "//tbody//tr[10]/td[1]//a/span")
    public WebElement Selected_Part_Number;
    @FindBy(xpath = "//tbody//tr[10]/td[4]//div[1]/a")
    public WebElement View_Drop_Crosses_Button;
    @FindBy(xpath = "//tbody//tr[10]/td[4]//div[2]/a")
    public WebElement View_Replacement_Button;
    @FindBy(xpath = "//div[@id='dropbg']//table[2]/tbody/tr[1]/td[2]/div")
    public WebElement Suggested_Part_Label;
    @FindBy(xpath = "//*[@id]//tr[1]//button[contains(text(),'Add Part ')]")
    public WebElement Add_Part_Button;
    @FindBy(xpath = "//tbody//tr[10]/td[3]//ul/div[2]//a/span")
    public WebElement Added_Part_Label;
    @FindBy(xpath = "//tbody/tr[10]/td[3]//div[1]/div[1]/span[1]")
    public WebElement Card_Close_Button;
    @FindBy(xpath = "//table[@class='table table-bordered table-middle text-left bg-white tablehascards']//tbody")
    public WebElement Table_Body;
    @FindBy(xpath = "//tbody//tr[10]/td[3]//ul/div[2]//a/span")
    public List<WebElement> Added_Part_Label_List;


    public Mitigation_Page(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
    }

    public void Z2D_Select_Switcher() {
        Click_Button(Switchers);
    }

    public void Z2D_Open_Drop_INCrosses() throws InterruptedException {
        Scroll_To_Bottom();
        Thread.sleep(3000);
        Click_Button(Drop_Crosses);
    }

    public void Z2D_Add_Crosses() {
        Click_Button(Add_Crosses);
    }

    public void Z2D_Click_on_Mitigation_Tab() {
        Click_Button(Mitigation_Tab);
    }

    //  public void Z2D_Click_on_Total_Filter(){Click_Button(Total_Parts);}
    public void Z2D_Click_on_Active_Filter() {
        Click_Button(Active_Parts);
    }

    public void Z2D_Click_on_NRND_Filter() {
        Click_Button(NRND_Parts);
    }

    public void Z2D_Click_on_EndofLife_Filter() {
        Click_Button(End_Of_Life_Parts);
    }

    public void Z2D_Click_on_DropinCrosses() throws InterruptedException {
        boolean Intercepted = true;
        while (Intercepted) {
            try {
                Scroll_to_Element(View_Drop_Crosses_Button);
                Click_Button(View_Drop_Crosses_Button);
                Thread.sleep(200);
                Intercepted = false;
            } catch (ElementClickInterceptedException e) {
                Intercepted = true;
            }
        }
    }

    public void Z2D_Click_on_Add_Part_Button() throws InterruptedException {
        Thread.sleep(1000);
        Click_Button(Add_Part_Button);
    }

    public void Z2D_Click_on_Close_Button() throws InterruptedException {
        boolean Intercepted = true;
        while (Intercepted) {
            try {
                Click_Button(Card_Close_Button);
                Thread.sleep(200);
                Intercepted = false;
            } catch (ElementNotInteractableException e) {
                Intercepted = true;
            }
        }
    }

    public void Z2D_Click_on_View_Replacement_Button() {
        boolean Intercepted = true;
        while (Intercepted) {
            try {
                Click_Button(View_Replacement_Button);
                Thread.sleep(200);
                Intercepted = false;
            } catch (ElementClickInterceptedException | InterruptedException e) {
                Intercepted = true;
            }
        }

    }
}
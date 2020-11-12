package Com.PartRisk.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Mitigation_Page extends Page_Base {
    @FindBy(xpath = "//*[@id=\"RemainMainPage\"]/app-risk-manager/div[2]/div/div/div/div/label/div")
   public WebElement Switchers;
    @FindBy(xpath = "/tbody/tr[10]/td[4]/div[1]/a[1]")
    WebElement Drop_Crosses;
    @FindBy(xpath = "//*[@id=\"dropbg\"]/div/div/div[2]/table[2]/tbody/tr[2]/td[1]/button")
    WebElement Add_Crosses;
    @FindBy(xpath = "//*[@id=\"RemainMainPage\"]/app-risk-manager/app-risk-mitigation/app-riskmitigationipn/div[1]/div[1]/div/div/div[1]")
    WebElement Total_Filter;

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

    public void Z2D_Filter() {
        Click_Button(Total_Filter);
    }
}
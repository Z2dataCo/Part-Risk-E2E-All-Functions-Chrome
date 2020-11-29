package Com.PartRisk.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Reports_Page extends Page_Base {
    @FindBy(xpath = "//span[contains(text(),'Z2 Part Number')]")
    public WebElement Check_Box1;
    @FindBy(xpath = "//span[contains(text(),'Product Name')]")
    public WebElement Check_Box2;
    @FindBy(xpath = "//*[@id=\"z2-2cols-sub-2cols-left\"]/div/app-createreport/app-run-create-reports/div[1]/div[1]/div[2]/select")
    public WebElement DDL_Report;
    @FindBy(xpath = "//*[@id=\"z2-2cols-sub-2cols-left\"]/div/app-createreport/app-run-create-reports/div[1]/div[1]/div[2]/select/option[2]")
    public WebElement Index0;
    @FindBy(xpath = "//div[@id='dropbg']/div/div/div[1]/div[2]/i")
    public WebElement Close_Preview;
    @FindBy(xpath = "//*[@id=\"dropbg\"]/div/div/button")
    public WebElement Download_Btn;
    @FindBy(xpath = "//*[@id=\"z2-2cols-leftpanel\"]/ul/li[5]/a/div[2]")
    public WebElement Obsolescence;
    @FindBy(xpath = "//a[contains(text(),'High Lifecycle Risk Parts')]")
    public WebElement High_Lifecycle_RiskParts;
    @FindBy(linkText = "Obsolete Parts in 3 Years")
    public WebElement ObsoleteParts_3Y;
    @FindBy(linkText = "Obsolete Parts in 5 Years")
    public WebElement ObsoleteParts_5Y;
    @FindBy(xpath = "//*[@id=\"dropbg\"]/div/div/div[2]/div/div[2]/table/tbody/tr[32]/td[5]/div")
    public WebElement Row_Active;
    @FindBy(xpath = "//*[@id=\"dropbg\"]/div/div/div[2]/div/div[2]/table/tbody/tr[18]/td[8]/div")
    public WebElement Row_3Y;
    @FindBy(xpath = "//*[@id=\"z2-2cols-leftpanel\"]/ul/li[3]/a/div[2]")
    WebElement Create_Report;
    @FindBy(xpath = "//body/div[@id='main_start_page']/app-root[1]/div[3]/app-risk-manager[1]/app-riskreport[1]/div[1]/app-riskreportmpn[1]/div[1]/div[2]/div[1]/div[1]/div[1]/app-createreport[1]/app-run-create-reports[1]/div[1]/div[1]/div[1]/button[1]")
    WebElement Save_Report;
    @FindBy(xpath = "//*[@id=\"dropbg\"]/div/div/div[2]/div[1]/div[2]/input")
    WebElement Report_Name;
    @FindBy(xpath = "//body/div[@id='dropbg']/div[1]/div[1]/div[2]/button[1]")
    WebElement Confirm_Report;
    @FindBy(xpath = "//*[@id=\"z2-2cols-sub-2cols-left\"]/div/app-createreport/app-run-create-reports/div[1]/div[1]/div[1]/button[3]")
    WebElement Preview;
    @FindBy(xpath = "//*[@id=\"z2-2cols-leftpanel\"]/ul/li[7]/a")
    public WebElement Conflict_Minerals_Tab;
    @FindBy(xpath = "//a[contains(text(),'Smelters Report')]")
    public WebElement Smelters_Report_button;
    @FindBy(xpath = "//*[@id=\"dropbg\"]/div/div/div[1]/div[1]/div[1]/div[1]")
    public WebElement Smelters_Window_Title;
    @FindBy(xpath = "//*[@id=\"dropbg\"]/div/div/div[2]/div[1]/div/button")
    public WebElement Export_Button;
    @FindBy(xpath = "//*[@id=\"dropbg\"]/div/div/div[2]/div[1]/div/div/a[1]")
    public WebElement Export_Selection;




    public Reports_Page(WebDriver driver) {
        super(driver);
        action = new Actions(driver);
    }

    public void Z2D_Open_Create_Report() {
        Click_Button(Create_Report);
    }

    public void Z2D_Select_Parameter() throws InterruptedException {
        Click_Button(Check_Box1);
        Thread.sleep(1000);
        Click_Button(Check_Box2);
        Thread.sleep(2000);
    }

    public void Z2D_Save_Report() {
        Click_Button(Save_Report);
    }

    public void Z2D_Enter_Report_Name(String Name) {
        Set_Text_Element_Text(Report_Name, Name);
    }

    public void Z2D_Confirm_Report() {
        Click_Button(Confirm_Report);
    }

    public void Z2D_Preview_Report() {
        Click_Button(Preview);
    }

    public void Z2D_Close_Preview() {
        Click_Button(Close_Preview);
    }

    public void Z2D_Download_Report() {
        Click_Button(Download_Btn);
    }

    public void Z2D_Open_Obsolescence() {
        Click_Button(Obsolescence);
    }

    public void Z2D_Open_High_LifeCycle() {
        Click_Button(High_Lifecycle_RiskParts);
    }

    public void Z2D_Open_Obsolete_3Years() {
        Click_Button(ObsoleteParts_3Y);
    }

    public void Z2D_Open_Obsolete_5Years() {
        Click_Button(ObsoleteParts_5Y);
    }

    public void Z2D_Open_Smelters_Report(){action.moveToElement(Conflict_Minerals_Tab).click().perform();
    Click_Button(Smelters_Report_button);}

    public void Z2D_Export_Report_Excel(){Click_Button(Export_Button);
    action.moveToElement(Export_Selection).click().perform();}



}
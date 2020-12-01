package Com.PartRisk.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.sikuli.hotkey.Keys;

import java.util.List;

public class Reports_Page extends Page_Base {
    @FindBy(xpath = "//span[contains(text(),'Z2 Part Number')]")
    public WebElement Check_Box1;
    @FindBy(xpath = "//span[contains(text(),'Product Name')]")
    public WebElement Check_Box2;
    @FindBy(xpath = "//*[@placeholder='Saved Reports']")
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
    @FindBy(xpath = "//*[@class='pull-left width-80-per']/button[3]")
    WebElement Preview;
    @FindBy(xpath = "//*[@id=\"z2-2cols-leftpanel\"]/ul/li[7]/a")
    public WebElement Conflict_Minerals_Tab;
    @FindBy(xpath = "//a[contains(text(),'Smelters Report')]")
    public WebElement Smelters_Report_button;
    @FindBy(xpath = "//*[@id=\"dropbg\"]/div/div/div[1]/div[1]/div[1]/div[1]")
    public WebElement Report_Window_Title;
    @FindBy(xpath = "//*[@id=\"dropbg\"]/div/div/div[2]/div[1]/div//button")
    public WebElement Export_Button;
    @FindBy(xpath = "//*[@id=\"dropbg\"]/div/div/div[2]/div[1]/div/div//a[1]")
    public WebElement Export_Selection;
    @FindBy(xpath = "//a[contains(text(),'CM Compliance by Supplier')]")
    public WebElement Supplier_Report_Button;
    @FindBy(xpath = "//a[contains(text(),'MPN Conflict Minerals Report')]")
    public WebElement Compliance_By_MPN_Report_Button;
    @FindBy(xpath = "//a[contains(text(),'Conflict Minerals Metal')]")
    public WebElement Minerals_Metal_Report_Button;
    @FindBy(xpath = "//*[@id=\"dropbg\"]/div/div/div[2]/div[1]/div[1]/div[2]/div")
    public WebElement First_Filter;
    @FindBy(xpath = "//*[@id=\"dropbg\"]/div/div/div[2]/div[1]/div[2]/div[2]/div")
    public WebElement Second_Filter;
    @FindBy(xpath = "//*[@id=\"dropbg\"]/div/div/div[2]/div[1]/div[3]/div[2]/div")
    public WebElement Third_Filter;
    @FindBy(xpath = "//*[@id=\"dropbg\"]/div/div/div[2]/div[1]/div[4]/div[2]/div")
    public WebElement Fourth_Filter;
    @FindBy(xpath = "//*[@id=\"dropbg\"]/div/div/div[2]/div[2]//app-z2pagination/span/span[2]")
    public WebElement Info_Total;
    @FindBy(xpath = "//*[@placeholder='Saved Reports']/option[2]")
    public WebElement First_Report_Name;

    public Reports_Page(WebDriver driver) {
        super(driver);
        action = new Actions(driver);
    }

    @FindBy (xpath = "//*[@id=\"z2-2cols-leftpanel\"]/ul/li[2]/a/div[2]")
   public WebElement CusReport;

    @FindBy(xpath = "//*[@id=\"z2-2cols-sub-2cols-left\"]/div/app-myreports/div[3]/div[2]/div/div[2]/div/div/i")
    public WebElement reportlist;

    @FindBy(xpath = "//*[@id=\"z2-2cols-sub-2cols-left\"]/div/app-myreports/div[3]/div[2]/div/div[2]/div/div/popover-container/div[2]/div/div[1]/div[1]/a[2]/div[2]")
    public WebElement DeleteReport;

    @FindBy(xpath = "//*[@id=\"z2-2cols-sub-2cols-left\"]/div/app-myreports/div[3]/div[2]/div/div[1]/h3")
    public WebElement FirstRow;

    @FindBy(xpath = "//*[@id=\"z2-2cols-leftpanel\"]/ul/li[7]/a")
    public WebElement ConflictMinerals;

    @FindBy(xpath = "//*[@id=\"E486C921-1091-4106-AF87-9FA806D3C9CD\"]/div/div[4]/div/div/div/a")
    public WebElement ConflictMetals;

    @FindBy(xpath ="//*[@id=\"dropbg\"]/div/div/div[2]/div[2]/table/thead/tr/th[6]" )
    public WebElement Tungsten;



    public void Z2D_Open_Create_Report() {
        Click_Button(Create_Report);
    }

    public void Z2D_Select_Parameter() throws InterruptedException {
        Click_Button(Check_Box1);
        Click_Button(Check_Box2);
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

    public void Z2D_Open_Smelters_Report(){
        action.moveToElement(Conflict_Minerals_Tab).click().perform();
        Click_Button(Smelters_Report_button);}

    public void Z2D_Export_Report_Excel(){Click_Button(Export_Button);
    action.moveToElement(Export_Selection).click().build().perform();}

    public void Z2D_Open_Supplier_Report(){
        action.moveToElement(Conflict_Minerals_Tab).click().perform();
        Click_Button(Supplier_Report_Button);}

    public void Z2D_Open_Compliance_MPN_Report(){
        action.moveToElement(Conflict_Minerals_Tab).click().perform();
        Click_Button(Compliance_By_MPN_Report_Button);}

    public void Z2D_Open_Minerals_Metal_Report(){
        action.moveToElement(Conflict_Minerals_Tab).click().perform();
        Click_Button(Minerals_Metal_Report_Button);}

    public void Z2D_Click_on_2nd_Filter(){ Click_Button(Second_Filter); }
    public void Z2D_Click_on_3rd_Filter(){ Click_Button(Third_Filter); }
    public void Z2D_Click_on_4th_Filter(){ Click_Button(Fourth_Filter); }
    public void Z2D_Click_on_Saved_Reports_List(){action.moveToElement(DDL_Report).click().perform();}
    public void Z2D_Re_Click_on_Saved_Reports_List(){action.sendKeys(Keys.ESC);
        action.moveToElement(DDL_Report).click().perform();}


    public void Openlist (){
        Click_Button(reportlist);
    }

    public void Delete_Report(){
        Click_Button(DeleteReport);
    }

    public void CustomReport(){
        Click_Button(CusReport);

    }
    public void Open_ConflictMinerals() {
        Click_Button(ConflictMinerals);
    }
    public void OpenConMetals(){
        Click_Button(ConflictMetals);
    }

}
package Com.PartRisk.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Upload_BOM_Page extends Page_Base {

    //@FindBy(css = "body.NewPortalDes.ng-scope:nth-child(2) div.ng-scope:nth-child(13) div.pagecontent div.bomupload-full div:nth-child(1) div.bomupload-dragdrop:nth-child(6) div.forcenextbtm > button.bomupload-next.btnNext-step1")
    @FindBy(xpath = "//body/div[@id='DivUploadBOM']/div[1]/div[1]/div[1]/div[2]/div[1]/button[1]")
    // @FindBy(linkText = "Next")
    public WebElement Next;
    @FindBy(xpath = "//*[@id=\"bommapUL\"]/li[1]/a")
    public WebElement MPN;
    @FindBy(xpath = "//*[@id=\"selectedFolderName\"]")
    public WebElement Select_BOM_Folder;
    @FindBy(xpath = "//*[@id=\"bommapUL\"]/li[2]/a")
    public WebElement Supplier;
    @FindBy(id = "btnSaveBom")
    public WebElement Finish_Btn;
    @FindBy(xpath = "//*[@id=\"bomdropzone\"]/div[2]/a")
    public WebElement Remove_File_Link;
    @FindBy(xpath = "//*[@id=\"DivUploadBomMapCols\"]/div[1]/div[1]/h2")
    public WebElement BOM_Text;
    @FindBy(xpath = "//*[@id=\"DivUploadBomMapCols\"]/div[3]/table/thead/tr/td[2]/a/span")
    public WebElement MPN_MSG;
    @FindBy(xpath = "//body/div[@id='main_start_page']/app-root[1]/div[3]/app-risk-manager[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/a[1]")
    public WebElement Dashboard_Tab;
    @FindBy(xpath = "//body/div[@id='main_start_page']/app-root[1]/div[3]/app-risk-manager[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/a[1]")
    public WebElement Scrub_Tab;
    @FindBy(xpath = "//body/div[@id='main_start_page']/app-root[1]/div[3]/app-risk-manager[1]/div[2]/div[1]/div[1]/ul[1]/li[3]/a[1]")
    public WebElement Parts_Tab;
    @FindBy(linkText = "Forecast")
    public WebElement Forecast_Tab;
    @FindBy(xpath = "//body/div[@id='main_start_page']/app-root[1]/div[3]/app-risk-manager[1]/div[2]/div[1]/div[1]/ul[1]/li[5]/a[1]")
    public WebElement Compliance_Tab;
    @FindBy(xpath = "//body/div[@id='main_start_page']/app-root[1]/div[3]/app-risk-manager[1]/div[2]/div[1]/div[1]/ul[1]/li[6]/a[1]")
    public WebElement Mitigation_Tab;
    @FindBy(xpath = "//body/div[@id='main_start_page']/app-root[1]/div[3]/app-risk-manager[1]/div[2]/div[1]/div[1]/ul[1]/li[7]/a[1]")
    public WebElement Reports_Tab;
    @FindBy(xpath = "//*[@id=\"z2page-head-bar\"]/div/h1/span")
    public WebElement Assert_For_Part_Number;
    @FindBy(xpath = "//thead/tr[1]/td[2]")
    public WebElement Selection;
    @FindBy(xpath = "//*[@id=\"DivUploadBomMapCols\"]/div[1]/div[3]/div/button[2]")
    public WebElement Next_Step;
    @FindBy(xpath = "//*[@id=\"bommapUL\"]/li[4]/a")
    public WebElement Mapped_IPN;
    @FindBy(id = "37753_anchor")
    WebElement Selected_Folder;
    @FindBy(xpath = "//*[@id=\"DivUploadBomMapCols\"]/div[3]/table/thead/tr/td[3]")
    WebElement Column2;

    public Upload_BOM_Page(WebDriver driver) {
        super(driver);
    }

    public void Z2D_Click_Next() {
        Click_Button(Next);
    }

    public void Z2D_Select_Type() {
        Click_Button(Selection);
    }

    public void Z2D_Supplier_Selection() {
        Click_Button(Supplier);
    }

    public void Z2D_MPN_Select() {
        Click_Button(MPN);
    }

    public void Z2D_Second_Step() {
        Click_Button(Next_Step);
    }

    public void Z2D_Select_Folder() {
        Click_Button(Select_BOM_Folder);
    }

    public void Z2D_Selected_Folder() {
        Click_Button(Selected_Folder);
    }

    public void Z2D_Finish() {
        Click_Button(Finish_Btn);
    }

    public void Z2D_Open_Column() {
        Click_Button(Column2);
    }

    public void Z2D_Mapped_IPN() {
        Click_Button(Mapped_IPN);
    }

    public void Z2D_Click_Dashboard_Tab() {
        Click_Button(Dashboard_Tab);
    }

    public void Z2D_Click_Scrub_Tab() {
        Click_Button(Scrub_Tab);
    }

    public void Z2D_Click_Parts_Tab() {
        Click_Button(Parts_Tab);
    }

    public void Z2D_Click_Forecast_Tab() {
        Click_Button(Forecast_Tab);
    }

    public void Z2D_Click_Compliance_Tab() {
        Click_Button(Compliance_Tab);
    }

    public void Z2D_Click_Mitigation_Tab() {
        Click_Button(Mitigation_Tab);
    }

    public void Z2D_Click_Reports_Tab() {
        Click_Button(Reports_Tab);
    }

}

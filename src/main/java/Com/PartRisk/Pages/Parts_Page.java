package Com.PartRisk.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Parts_Page extends Page_Base {
    @FindBy(xpath = "//body/div[@id='main_start_page']/app-root[1]/div[3]/app-risk-manager[1]/app-risk-parts[1]/app-riskpartsmpn[1]/div[2]/div[1]/div[2]/div[1]/app-z2pagination[1]/span[1]/span[2]")
    public WebElement Number_Of_Parts;
    @FindBy(xpath = "//*[@id=\"partsMPNTabTHeadTrTblId\"]/th[3]")
    public WebElement Uploaded_IPN;
    @FindBy(xpath = "//*[@id=\"partsMPNTabTHeadTrTblId\"]/th[4]")
    public WebElement Uploaded_MPN;
    @FindBy(xpath = "//*[@id=\"partsMPNTabTHeadTrTblId\"]/th[5]")
    public WebElement Uploaded_Supplier;

    @FindBy(xpath = "//*[@id=\"partsMPNTabTHeadTrTblId\"]/th[7]")
    public WebElement IPN;

    @FindBy(xpath = "//*[@id=\"partsMPNTabTHeadTrTblId\"]/th[8]")
    public WebElement Part_Number;
    @FindBy(xpath = "//*[@id=\"partsMPNTabTHeadTrTblId\"]/th[9]")
    public WebElement Supplier;
    @FindBy(xpath = "//*[@id=\"partsMPNTabTHeadTrTblId\"]/th[10]")
    public WebElement Product;
    @FindBy(xpath = "//*[@id=\"partsMPNTabTHeadTrTblId\"]/th[11]")
    public WebElement Description;
    @FindBy(xpath = "//*[@id=\"partsMPNTabTHeadTrTblId\"]/th[12]")
    public WebElement Package;
    @FindBy(xpath = "//thead/tr[@id='partsMPNTabTHeadTrTblId']/th[13]")
    public WebElement LifeCycle;
    @FindBy(xpath = "//*[@id=\"partsMPNTabTHeadTrTblId\"]/th[14]")
    public WebElement RoHos;
    @FindBy(xpath = "//*[@id=\"partsMPNTabTHeadTrTblId\"]/th[15]")
    public WebElement Crosses;
    @FindBy(xpath = "//*[@id=\"partsMPNTabTHeadTrTblId\"]/th[16]")
    public WebElement Inventory;
    @FindBy(xpath = "//*[@id=\"partsMPNTabTHeadTrTblId\"]/th[17]")
    public WebElement PCN;
    @FindBy(xpath = "//*[@id=\"partsMPNTabTHeadTrTblId\"]/th[18]")
    public WebElement PartScore;
    @FindBy(xpath = "//*[@id=\"partsMPNTabTHeadTrTblId\"]/th[19]")
    public WebElement Tags;
    @FindBy(xpath = "//body[1]/div[5]/app-root[1]/div[3]/app-risk-manager[1]/app-risk-parts[1]/app-riskpartsipn[1]/div[2]/div[2]/div[1]/table[1]/thead[1]/tr[1]/th[1]")
    public WebElement IPN_Table_Header;
    @FindBy(xpath = "//th[contains(text(),'Product')]")
    public WebElement Product_Table_Header;
    @FindBy(xpath = "//th[contains(text(),'Description')]")
    public WebElement Description_Table_Header;
    @FindBy(xpath = "//th[contains(text(),'# of MPNs')]")
    public WebElement ofMPNs_Table_Header;
    @FindBy(xpath = "//th[contains(text(),'# of Sources')]")
    public WebElement OfSource_Table_Header;
    @FindBy(xpath = "//thead/tr[1]/th[6]")

    public WebElement IPN_LifeCycle_Table_Header;
    @FindBy(xpath = "//thead/tr[1]/th[7]")

    public WebElement Multi_Sourcing_Table_Header;
    @FindBy(xpath = "//thead/tr[1]/th[8]")
    public WebElement Package_Table_Header;
    @FindBy(xpath = "//thead/tr[1]/th[9]")
    public WebElement RoHS_Table_Header;
    @FindBy(xpath = "//thead/tr[1]/th[10]")
    public WebElement Lead_Finish_Table_Header;
    @FindBy(xpath = "//thead/tr[1]/th[11]")
    public WebElement Dimension_Table_Header;
    @FindBy(xpath = "//thead/tr[1]/th[12]")
    public WebElement Crosses_Table_Header;
    @FindBy(xpath = "//thead/tr[1]/th[13]")
    public WebElement IPN_Lifecycl_Forecast_Table_Header;
    @FindBy(xpath = "//thead/tr[1]/th[14]")
    public WebElement IPN_Risk_Table_Header;
    @FindBy(xpath = "//*[@id=\"z2parametric-all\"]/div/div[1]/div[2]/div[1]/label/span[1]")
    WebElement AVX_Filter;
    @FindBy(xpath = "//*[@id=\"z2parametric-all\"]/div/div[2]/div[2]/div[2]/label/span[1]")
    WebElement Fuses_Filter;
    @FindBy(xpath = "//*[@id=\"RemainMainPage\"]/app-risk-manager/div[2]/div/div/div/div/label/div")
    WebElement Parts_Switchers;

    public Parts_Page(WebDriver driver) {
        super(driver);
    }

    public void Z2D_Check_AVX() {
        Click_Button(AVX_Filter);
    }

    public void Z2D_Check_Fuses() {
        Click_Button(Fuses_Filter);
    }

    public void Z2D_Select_Switcher() {
        Click_Button(Parts_Switchers);
    }
}
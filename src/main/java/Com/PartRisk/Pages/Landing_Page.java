package Com.PartRisk.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

public class Landing_Page extends Page_Base {
    @FindBy(xpath = "//body/div[2]/div[1]/a[1]")
    public WebElement Z2data_Logo_1;
    @FindBy(xpath = "/html/body/div[1]/div[1]/span")
    public WebElement Z2data_Logo_2;
    @FindBy(xpath = "//*[@id=\"tblPartData\"]/tr/td[3]/a")
    public WebElement Verification_MSG;
    @FindBy(id = "UploadBOMTrigger")
    public WebElement Upload_BOM_Btn;
    @FindBy(xpath = "//*[@id=\"z2page-head-bar\"]/div/h1/span/span")
    public WebElement PartName;
    @FindBy(xpath = "//*[@id=\"progressDiv\"]/div/div/div[2]")
    public List<WebElement> GeneralSpinner;
    @FindBy(id = "txtMainBarSearch")
    public WebElement Search_Input;
    @FindBy(linkText = "Data Management")
    public WebElement Data_Management_Tab;
    @FindBy(xpath = "//*[@id=\"ui-id-3\"]")
    public WebElement Value;
    @FindBy(xpath = "/html[1]/body[1]/ul[2]/li[2]/a[1]")
    public WebElement IPN_Value;
    @FindBy(xpath = "//*[@id=\"z2parametric-all\"]/div/div[2]/div[2]/div[1]/label/span[1]")
    public WebElement Supp_ChkBox;
    @FindBy(id = "progressDiv")
    public WebElement SpinnerZezo;
    @FindBy(xpath = "//div[@id='dropbg']//div[@style='border-radius: 3px; background-color: rgba(0, 18, 59, 0.6);']")
    public List<WebElement> SpinnerZezo2;

    @FindBy(xpath = "//div//div[@class='usericon']")
    public WebElement MY_Account;
    //@FindBy(xpath = "/html[1]/body[1]/div[9]/div[1]/div[2]/div[2]/a[3]")
    @FindBy(xpath = "//body/div[@id='dropbg']/div[1]/div[2]/div[2]/a[3]/span[1]")
    public WebElement Logout;
    @FindBy(xpath = "//*[@id=\"main-search-bar\"]/div[1]")
    public WebElement DDL_Type_Of_Search;
    @FindBy(xpath = "//div[@id='dropbg']//a[contains(text(),'Part Number')]")
    WebElement Part_Number;
    @FindBy(xpath = "//button[@id='btnautoSearch']")
    WebElement Search_Btn;
    @FindBy(xpath = "/html/body/div[3]/div[1]/ul/li[1]/a")
    public WebElement Parametric_Menu;
    @FindBy(xpath = "/html/body/div[3]/div[1]/ul/li[1]/div/div/div[1]/ul/li[1]/a")
    WebElement Product;
    @FindBy(xpath = "//*[@id=\"ca1_Semiconductors\"]/ul/li[1]/ul/li/div[1]/div/div/a")
    WebElement SupElement;
    @FindBy(xpath = "//*[@id=\"scopeOptionDiv\"]/ul/li[6]/a")
    public WebElement Adv_Crosses_Value;
    @FindBy(xpath = "//*[@id=\"scopeOptionDiv\"]/ul/li[2]/a")
    WebElement IPN;
    @FindBy(linkText = "Compare")
    //@FindBy(xpath = "/html/body/div[4]/div[1]/ul/li[6]/a")
    public WebElement Compare_Tab;
    @FindBy(xpath = "//a[contains(text(),'More')]")
    public WebElement More_Tab;
    @FindBy(xpath = "//a[contains(text(),'Suppliers')]")
    public WebElement Suppliers;
    @FindBy(linkText = "PCN Manager")
    //@FindBy(xpath = "/html/body/div[4]/div[1]/ul/li[3]/a")
    public WebElement PCN_Manager_Tab;
    @FindBy(xpath = "//*[@id=\"btnautoSearch\"]/i")
    WebElement btn_search;

    @FindBy(xpath = "//a[contains(text(),'Remove file')]")
    public WebElement Remove_File;


    public Landing_Page(WebDriver driver) {
        super(driver);
    }

    public void Z2D_Upload_BOM(String Z2DataFilePath) throws AWTException {
        Click_Button(Upload_BOM_Btn);
        StringSelection strSelection = new StringSelection(Z2DataFilePath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(strSelection, null);
        Robot robot = new Robot();
        robot.delay(300);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(200);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }

    public void Z2D_Return_To_Landing_Page() {
        Click_Button(Z2data_Logo_1);
    }

    public void Z2D_Return_landing_Page() {
        Click_Button(Z2data_Logo_2);
    }

    public void Z2D_Select_Part_Number(String SearchValue) {
        Click_Button(DDL_Type_Of_Search);
        Click_Button(Part_Number);
        Set_Text_Element_Text(Search_Input, SearchValue);
        Click_Button(Search_Btn);
    }

    public void Z2D_input_Search(String Value) {
        Set_Text_Element_Text(Search_Input, Value);
    }

    public void ParametricSearch() {
        Click_Button(Parametric_Menu);
        Click_Button(Product);
        Click_Button(SupElement);
    }

    public void Z2D_Open_Data_Management() {
        Click_Button(Data_Management_Tab);
    }

    public void Z2D_Open_DDL_Menu() {
        Click_Button(DDL_Type_Of_Search);
    }

    public void Z2D_Adv_Crosses() {
        Click_Button(Adv_Crosses_Value);
    }

    public void Z2D_Adv_Product() {
        Click_Button(Value);
    }

    public void Z2D_IPN_DDL() {
        Click_Button(IPN);
    }

    public void Z2D_IPN_Value() {
        Click_Button(IPN_Value);
    }

    public void Z2D_Open_Compare_Page() {
        Click_Button(Compare_Tab);
    }

    public void Z2D_More_Menu() {
        Click_Button(More_Tab);
    }

    public void Z2D_Select_Supplier() {
        Click_Button(Suppliers);
    }

    public void Z2D_Open_PCN_Manager() {
        Click_Button(PCN_Manager_Tab);
    }

    public void Z2D_Check_Supplier() {
        Click_Button(Supp_ChkBox);
    }

    public void Z2D_Click_Search() {
        Click_Button(btn_search);
    }

    public void Z2D_Click_My_Account() {
        Click_Button(MY_Account);
    }

    public void Z2D_Logout() {
        Click_Button(Logout);
    }
}
package Com.PartRisk.Pages;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PCN_Manager_Page extends Page_Base {
    @FindBy(xpath = "//body/div[@id='main_start_page']/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/a[1]")
    public WebElement Dashboard_Tab;

    @FindBy(xpath = "//body/div[@id='main_start_page']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h1[1]")
    public WebElement Dashboard_Tab_Total_PCNs;

    @FindBy(xpath = "//body/div[@id='main_start_page']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/h1[1]")
    public WebElement Dashboard_Tab_Requires_Action;

    @FindBy(xpath = "//body/div[@id='main_start_page']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/h1[1]")
    public WebElement Dashboard_Tab_In_Progress;

    @FindBy(xpath = "//body/div[@id='main_start_page']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/h1[1]")
    public WebElement Dashboard_Tab_Completed;

    @FindBy(xpath = "//body/div[@id='main_start_page']/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]/a[1]")
    public WebElement Inbox_Tab;

    @FindBy(xpath = "//*[@id=\"DivInBoxFilterPCN\"]/div[1]/div[2]")
    public WebElement Inbox_Tab_Filter_Table;

    @FindBy(xpath = "//body/div[@id='main_start_page']/div[1]/div[2]/div[1]/div[1]/ul[1]/li[3]/a[1]")
    public WebElement PCNs_Tab;

    @FindBy(xpath = "//*[@id=\"DivPcnsTabFilterPCN\"]/div[1]/div[2]")
    public WebElement PCNs_Tab_Filter_Table;

    @FindBy(xpath = "//*[@id=\"DivPcnsTabFilterPCN\"]/div[1]/div[2]/div[1]/div/table/thead/tr/th[1]")
    public WebElement PCNs_Tab_Filter_Table_Header;

    @FindBy(xpath = "//*[@id=\"3760\"]/td[1]")
    public WebElement PCNs_Select_First_PCN_Notification;

    @FindBy(xpath = "//td[contains(text(),'Z2 PCN_ID')]")
    public WebElement PCNs_First_PCN_Notification_PCN_ID;

    @FindBy(xpath = "/html[1]/body[1]/div[5]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h4[1]/a[1]")
    public WebElement PCNs_Notification_Back;




    @FindBy(xpath = "//a[contains(text(),'Impacted Parts')]")
    public WebElement Impacted_Parts_Tab;

    @FindBy(xpath = "//*[@id=\"DivAlertsFilterPCN\"]/div[1]/div[2]/div[1]/div")
    public WebElement Impacted_Parts_Tab_Filter_Table;

    @FindBy(id = "PCNSearchText")
    public WebElement Search_Field;

    @FindBy(xpath = "//*[@id=\"DivPcnsTabFilterPCN\"]/div[3]/div/div/span/a")
    public WebElement Search_button;

    @FindBy(id = "tblPagePCN")
    public WebElement Results_Table;

    @FindBy(xpath = "//table[@id='tblPagePCN']/tbody/tr[1]/td[4]/div[1]/span")
    public WebElement First_Search_Result;

    @FindBy(xpath = "//div[@id=\"PCNManagerPCNTab\"]/div[2]/div[1]/div[1]/div/span[1]")
    public WebElement Showing_Of_Total;

    @FindBy(xpath = "//*[@id=\"dataconfigrationtableTableView\"]/tr[48]/td[2]")
    public WebElement Impacted_MPN_Results;

    @FindBy(xpath = "//*[@id=\"PCNManagerPCNTab\"]/div[3]/div/div/div/div[1]/div/div[2]/h4/span[2]")
    public WebElement FSP_Text;


    public PCN_Manager_Page(WebDriver driver) {
        super(driver);
        jse = (JavascriptExecutor) driver;
    }

    public void Z2D_Open_Dashboard_Tab() {
        Click_Button(Dashboard_Tab);
    }

    public void Z2D_Open_Inbox_Tab() {
        Click_Button(Inbox_Tab);
    }

    public void Z2D_Open_PCNs_Tab() {
        Click_Button(PCNs_Tab);
    }

    public void Z2D_Back_from_PCN_Notification() {
        Click_Button(PCNs_Notification_Back);

    }

    public void Z2D_Open_Impacted_Parts_Tab() {
        Click_Button(Impacted_Parts_Tab);
        boolean Intercepted = true;
        while (Intercepted) {
            try {
                Click_Button(Impacted_Parts_Tab);
                Intercepted = false;
            } catch (ElementNotInteractableException e) {
                Intercepted = true;
            }

        }

    }

    public void Z2D_PCNs_First_PCN_Notification() {
        Click_Button(PCNs_Select_First_PCN_Notification);
    }

    public void Z2D_Open_First_Search_Result(){Click_Button(First_Search_Result);}

    public void Z2D_Search(String SeacrhWith) {
        Search_Field.clear();
        Set_Text_Element_Text(Search_Field, SeacrhWith);
        Click_Button(Search_button);
    }
public void Z2D_Move_To_Impacted_MPN() throws InterruptedException {
        Scroll_to_Element(Impacted_MPN_Results);
}
}




package Com.PartRisk.Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Data_Management_Page extends Page_Base {

    @FindBy(xpath = "//*[@id=\"z2page-head-bar\"]/div/h1/span/span")
    public WebElement Verification;
    @FindBy(xpath = "//*[@id=\"z2-2cols-leftpanel\"]/ul/li/a[1]/div[2]")
    public WebElement Verify_BOMs;
    @FindBy(xpath = "//*[@id=\"z2-2cols-leftpanel\"]/ul/li/a[2]/div[2]")
    public WebElement Verify_AVL;
    @FindBy(xpath = "//*[@id=\"z2-2cols-leftpanel\"]/ul/li/a[3]/div[2]")
    public WebElement Part_Correction;
    @FindBy(xpath = "//*[@id=\"z2-2cols-leftpanel\"]/ul/li/a[4]/div[2]")
    public WebElement Data_Setting;
    @FindBy(xpath = "//div[@id='main_start_page']//th[2]")
    public WebElement Table_Name;
    @FindBy(xpath = "//div[@id='main_start_page']//th[3]")
    public WebElement Table_User;
    @FindBy(xpath = "//div[@id='main_start_page']//th[4]")
    public WebElement Table_Of_file;
    @FindBy(xpath = "//div[@id='main_start_page']//th[5]")
    public WebElement Table_Of_Parts;
    @FindBy(xpath = "//body//th[6]")
    public WebElement Table_Of_Supplier;
    @FindBy(xpath = "//body//th[7]")
    public WebElement Table_Data_Created;
    @FindBy(xpath = "//body//th[8]")
    public WebElement Table_Action;
    @FindBy(xpath = "//*[@id=\"reportToHide\"]/div[2]/div[2]/div[3]/table/tbody/tr[4]/td[2]/a")
    public WebElement Folder_Name;
    @FindBy(xpath = "//div[@id='reportToHide']//div//div//div//div//app-uploadbom//a")
    public WebElement Upload_BOM_Folder;
    @FindBy(xpath = "//*[@id=\"reportToHide\"]/div[2]/div[2]/div[3]/table/tbody/tr[8]/td[2]/a")
    public WebElement My_Folder;
    @FindBy(xpath = " //*[@id=\"reportToHide\"]/div[2]/div[3]/app-subfolders-boms/div[1]/table/tbody/tr[16]/td[2]/a[1]")
    public WebElement My_BOM;
    @FindBy(xpath = "//*[@id=\"reportToHide\"]/div[2]/div[2]/div[3]/table/thead/tr/th[6]")
    public WebElement of_Suppliers;
    @FindBy(css = "#divSearchFolders > input")
    public WebElement Search_Text_Input;
    @FindBy(xpath = "//*[@id=\"z2page-head-bar\"]/div/app-create-alert/button/span")
    public WebElement Followed_Text;
    @FindBy(xpath = "//body[1]/div[9]/div[1]/div[1]/div[2]/form[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]")
    public WebElement Folder_Name_Input;
    @FindBy(xpath = "//*[@id=\"divSearchFolders\"]/div/ul/li[2]/a")
    public WebElement Test_Folder;
    @FindBy(xpath = "//div//div[@class='z2-scorecard-each bg-white pt-05 cursornormal'][1]")
    public WebElement Graph;
    @FindBy(xpath = "//*[@id=\"DMCreatefolder\"]/span/span")
    public WebElement Create_Folder;
    @FindBy(id = "FolderAutoCompleteSearch")
    WebElement Search_Btn;
    @FindBy(xpath = "//*[@id='divSearchFolders']//li[2]/a")
    public WebElement Search_Result;
    @FindBy(xpath = "//tbody/tr[2]//td[2]/a[1]")
    WebElement Select_BOM;
    @FindBy(xpath = "//a[contains(text(),'TAP_BOM_Proud_Test')]")
    public WebElement Select_Proud_Test_BOM;
    @FindBy(xpath = "//a[contains(text(),'Parts')]")
    WebElement Parts_Btn;
    @FindBy(xpath = "//div[@id='z2page-head-bar']/div//button/span[contains(text(),'Create Alert')]")
    WebElement Create_Alert_Btn;
    @FindBy(xpath = "//div[@id='sidepanelCreateAlert']//span[contains(text(),'Lifecycle')]")
    public WebElement LifeCycle_Btn;
    @FindBy(xpath = "//div[@id='sidepanelCreateAlert']//span[contains(text(),'Litigation')]")
    WebElement Litigation_Btn;
    @FindBy(xpath = "//button[contains(text(),'Create Alert')]")
    WebElement Submit_Btn;
    @FindBy(xpath = "//*[@id=\"dropbg\"]/div/div/div[2]/form/button")
    public WebElement Create_Folder_Btn;
    @FindBy(xpath = "//tbody/tr[20]/td[2]/a[1]")
    WebElement BOM_Folder;
    @FindBy(xpath = "//tbody/tr[1]/td[2]/a[1]")
    WebElement BOM;
    @FindBy(partialLinkText = "TAP_BOM_Proud_Te")
    public WebElement BOM_Prod_Test;
    @FindBy(xpath = "//a[contains(text(),'Compliance')]")
    WebElement Compliance_Tab;
    @FindBy(xpath = "//div[@id='z2page-head-bar']/div/app-create-alert/div[1]/a[2]")
    public WebElement Unfollow_Btn;
    @FindBy(linkText = "Parts")
    public WebElement Parts;
    @FindBy(linkText = "Forecast")
    public WebElement Forecast;
    @FindBy(linkText = "Mitigation")
    public WebElement Mitigation;
    @FindBy(linkText = "Scrub")
    WebElement Scrub;
    @FindBy(xpath = "//*[@id=\"RemainMainPage\"]/app-risk-manager/app-risk-parts/app-riskpartsmpn/ngx-loading/div/div[2]/div")
    public List<WebElement> Spinner;

    @FindBy(xpath = "//*[@id=\"RemainMainPage\"]/app-risk-manager/app-risk-parts/app-riskpartsmpn/ngx-loading/div/div[2]/div")
    public WebElement Spinner2;

    @FindBy(id = "toast-container")
    public WebElement Toast_Container;

    @FindBy(xpath = "//*[@id=\"scrub_content\"]/div/table/tbody/tr")
    public List<WebElement> Table_Rows;

    @FindBy(xpath = "//*[@id=\"scrub_content\"]/div/div[2]/div[2]/app-z2pagination/div/div/div/div/pagination/ul/li[5]/a")
    public WebElement Next_Page;

    @FindBy(linkText = "Next")
    public WebElement Next_Btn;

    @FindBy(xpath = "//*[@class='table-responsive']//tbody/tr[1]/td[2]/a")
    public WebElement istRow;
    @FindBy(xpath = "//*[@id=\"reportToHide\"]/div[2]/div[2]/div[3]/table/tbody/tr[1]/td[8]/div/app-datamanagement-boms-popups/div[1]/a[2]")
    public WebElement Delete;
    @FindBy(xpath = "/html/body/modal-container/div/div/div/button[1]")
    public WebElement Yes_Delete;

    public Data_Management_Page(WebDriver driver) {
        super(driver);
        action = new Actions(driver);
        jse = (JavascriptExecutor) driver;
    }

    public void Z2D_Open_Scrub() {
        Click_Button(Scrub);
    }

    public void Z2D_Open_Parts() {
        Click_Button(Parts);
    }

    public void Z2D_Open_Forecast() {
        Click_Button(Forecast);
    }

    public void Z2D_Open_Mitigation() {
        Click_Button(Mitigation);
    }

    public void Z2D_Click_Search() {
        Click_Button(Search_Btn);
    }

    public void Z2D_Open_Folders() {
        Click_Button(Folder_Name);
    }

    public void Z2D_Open_My_Folder() {
        Click_Button(My_Folder);
    }

    public void Z2D_Open_My_BOM() {
        Click_Button(My_BOM);
    }

    public void Z2D_Create_Folder() {
        Click_Button(Create_Folder);
    }

    public void Z2D_Submit_Folder() {
        Click_Button(Create_Folder_Btn);
    }

    public void Z2D_Folder_Name(String name) {
        Set_Text_Element_Text(Folder_Name_Input, name);
    }

    public void Z2D_Open_BOM_Folder() {
        Click_Button(BOM_Folder);
    }

    public void Z2D_Open_BOM() {
        Click_Button(Select_BOM);
    }

    public void Z2D_Type_Folder_Name(String text) {
        Set_Text_Element_Text(Search_Text_Input, text);
    }

    public void Z2D_Select_Folder() throws InterruptedException {
        Thread.sleep(2000);
        Click_Button(Search_Result);
    }


    public void DeleteBom() {
        Click_Button(Delete);
    }
    public void DeleteConfirmation() {
        Click_Button(Yes_Delete);
    }

    public void Z2D_Click_on_BOM_File() {
        Click_Button(Select_BOM);
    }

    public void Z2D_Click_on_Parts() {
        Click_Button(Parts_Btn);
    }

    public void Z2D_Click_on_Create_Alert(WebDriver driver) {
        Click_Button(Create_Alert_Btn);
    }

    public void Z2D_Click_on_LifeCycle() throws InterruptedException {
       while (!LifeCycle_Btn.isSelected()){
        Click_Button(LifeCycle_Btn);
        Thread.sleep(200);
       break;}}

    public void Z2D_Click_on_Litigation() throws InterruptedException {
       while (!Litigation_Btn.isSelected()){
           Click_Button(Litigation_Btn);
           Thread.sleep(200);
           break;} }

    public void Z2D_Click_on_Submit_Btn(){
        Click_Button(Submit_Btn);
    }

    public void Z2D_Hover_to_Status(WebDriver driver) throws InterruptedException, IOException {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));
        Thread.sleep(2000);
        Scroll_To_Middle();
        TakesScreenshot Screenshot = (TakesScreenshot) driver;
        File scrFile = Screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "/Screenshots/FirstScreenshot.png"));
        Thread.sleep(2000);
        //clickButton(ManfLocation);
        action = new Actions(driver);
        action.moveByOffset(270, 488).perform();
        Thread.sleep(2000);
        action.click().build().perform();
    }

    public void Z2D_Click_on_Compliance_Tab() {
        Click_Button(Compliance_Tab);
    }

    public void Z2D_Click_Followed_Btn() {
        Click_Button(Followed_Text);
    }

    public void Z2D_Click_Unfollow_Btn() {
        Click_Button(Unfollow_Btn);
    }

    public void Z2D_Search(String Value) {
        Set_Text_Element_Text(Search_Text_Input, Value);
    }

    public void Z2D_Counter() {
    }

    public void NextPagination() {
        Click_Button(Next_Btn);
    }

    public void Bom_Pro() {
        Click_Button(BOM_Prod_Test);
    }

    public void Z2D_Click_on_BOM() {
        Click_Button(Select_Proud_Test_BOM);
    }

    public void Z2D_Move_To_Prod_BOM(WebDriver driver) throws InterruptedException {
        driver.get("https://parts.z2data.com/RiskManager?BomId=119090");
        Thread.sleep(200);
    }

    public void Z2D_Move_to_Mitigation_Bom(WebDriver driver) throws InterruptedException {
        driver.get("https://parts.z2data.com/RiskManager/Mitigation?BomId=119090");
        Thread.sleep(200);
    }
        public void Z2D_Move_to_Forecast_Bom(WebDriver driver) throws InterruptedException {
        driver.get("https://parts.z2data.com/RiskManager/Forecast?BomId=119090");
            Thread.sleep(200);
        }
    public void Z2D_Move_to_Compliance_Bom(WebDriver driver) throws InterruptedException {
        driver.get("https://parts.z2data.com/RiskManager/Compliance?BomId=119090");
        Thread.sleep(200);
    }


    public void SetFile(){
        Click_Button(Test_Folder);
    }

    public void SetSearchValue(){
        Click_Button(Search_Result);
    }
}

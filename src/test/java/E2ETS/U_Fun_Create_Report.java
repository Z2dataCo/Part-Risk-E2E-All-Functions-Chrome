package E2ETS;

import Com.PartRisk.Pages.*;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class U_Fun_Create_Report extends Test_Base {
    Faker faker = new Faker();
    String Name = faker.name().firstName();
    Dashboard_Page DashboardPageObj;
    Report_Page ReportPageObj;
    Data_Management_Page DManagementObj;
    Landing_Page LandObj;

    @Test(priority = 21)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate To Create , Review Report And Download ")
    public void Create_Report_Download() throws InterruptedException {
        LandObj = new Landing_Page(driver);
        DManagementObj = new Data_Management_Page(driver);
        DashboardPageObj = new Dashboard_Page(driver);
        ReportPageObj = new Report_Page(driver);
        LandObj.Z2D_Open_Data_Management();
        Refresh();
        Wait_Element_Clickable(DManagementObj.Search_Text_Input);
        DManagementObj.Search_Text_Input.click();
        DManagementObj.Z2D_Type_Folder_Name(Z2DataFolderName);
        Wait_Element_Visible(DManagementObj.Test_Folder);
        DManagementObj.SetFile();
        Thread.sleep(2000);
        DManagementObj.Z2D_Open_BOM();
        Switch_Tabs();
        Implicitly();
        DashboardPageObj.Z2D_Open_Reports();
        ReportPageObj = new Report_Page(driver);
        ReportPageObj.Z2D_Open_Create_Report();
        Wait_Element_Clickable(ReportPageObj.Check_Box1);
        Wait_Element_Clickable(ReportPageObj.Check_Box2);
        ReportPageObj.Z2D_Select_Parameter();
        ReportPageObj.Z2D_Save_Report();
        ReportPageObj.Z2D_Enter_Report_Name(Name);
        ReportPageObj.Z2D_Confirm_Report();
        WaitAllElement();
        Select index = new Select(ReportPageObj.DDL_Report);
        Thread.sleep(3500);
        String ExpectedResult = index.getOptions().get(1).getText();
        String ActualResult = Name;
        if (!(ExpectedResult == ActualResult)) {
            WaitAllElement();
            Assert.assertEquals(ActualResult, ExpectedResult);
            System.out.println("This Is Actual Result: " + ActualResult);
            ReportPageObj.Z2D_Preview_Report();
            Wait_Element_Clickable(ReportPageObj.Close_Preview);
            Thread.sleep(5000);
            ReportPageObj.Z2D_Close_Preview();
            Assert.assertTrue(driver.getCurrentUrl().contains("https://parts.z2data.com/RiskManager/Report?BomId="));
            index.selectByIndex(1);
            Thread.sleep(2000);
            ReportPageObj.Z2D_Preview_Report();
            Assert.assertTrue(ReportPageObj.Download_Btn.getText().contains("Download"));
            Thread.sleep(2000);
            ReportPageObj.Z2D_Download_Report();
            Thread.sleep(3000);
            ReportPageObj.Z2D_Close_Preview();
            Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        } else {
            Assert.assertEquals(ActualResult, ExpectedResult);
            System.out.println("This Is Actual Result: " + ActualResult);
            ReportPageObj.Z2D_Preview_Report();
            Wait_Element_Clickable(ReportPageObj.Close_Preview);
            Thread.sleep(5000);
            ReportPageObj.Z2D_Close_Preview();
            Assert.assertTrue(driver.getCurrentUrl().contains("https://parts.z2data.com/RiskManager/Report?BomId="));
            index.selectByIndex(1);
            Thread.sleep(2000);
            ReportPageObj.Z2D_Preview_Report();
            Assert.assertTrue(ReportPageObj.Download_Btn.getText().contains("Download"));
            Thread.sleep(2000);
            ReportPageObj.Z2D_Download_Report();
            Thread.sleep(3000);
            ReportPageObj.Z2D_Close_Preview();
            Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        }
    }
}
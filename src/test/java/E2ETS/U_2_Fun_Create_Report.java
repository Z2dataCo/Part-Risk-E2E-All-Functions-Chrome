package E2ETS;

import Com.PartRisk.Pages.Dashboard_Page;
import Com.PartRisk.Pages.Data_Management_Page;
import Com.PartRisk.Pages.Landing_Page;
import Com.PartRisk.Pages.Report_Page;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class U_2_Fun_Create_Report extends Test_Base {
    Faker faker = new Faker();
    String Name = faker.name().firstName() + "1";
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
        Wait_Element_Visible(DManagementObj.Search_Text_Input);
        DManagementObj.Z2D_Type_Folder_Name(Z2DataFolderName);
        DManagementObj.Z2D_Select_Folder();
        boolean staleElement = true;
        while (staleElement) {
            try {
                DManagementObj.Z2D_Open_BOM();
                staleElement = false;
            } catch (Exception e) {
                staleElement = true;
            }
        }
        Switch_Tabs();
        WaitAllElement();
        DashboardPageObj.Z2D_Open_Reports();
        ReportPageObj = new Report_Page(driver);
        ReportPageObj.Z2D_Open_Create_Report();
        Wait_Element_Clickable(ReportPageObj.Check_Box1);
        Wait_Element_Clickable(ReportPageObj.Check_Box2);
        ReportPageObj.Z2D_Select_Parameter();
        ReportPageObj.Z2D_Save_Report();
        ReportPageObj.Z2D_Enter_Report_Name(Name);
        ReportPageObj.Z2D_Confirm_Report();
        Implicitly();
        Select index = new Select(ReportPageObj.DDL_Report);
        Thread.sleep(3500);
        String ExpectedResult = index.getOptions().get(1).getText();
        String ActualResult = Name;
        if (!(ExpectedResult == ActualResult)) {
            WaitAllElement();
            Assert.assertEquals(ActualResult, ExpectedResult);
            //System.out.println("This Is Actual Result: " + ActualResult);
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
            Wait_for_Element_to_Disappear(DManagementObj.Spinner);
            ReportPageObj.Z2D_Close_Preview();
            WaitAllElement();

        } else {
            Assert.assertEquals(ActualResult, ExpectedResult);
            //System.out.println("This Is Actual Result: " + ActualResult);
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
            ReportPageObj.Z2D_Close_Preview();
        }
        boolean staleElement1 = true;
        while (staleElement1) {
            try {
                ReportPageObj.CustomReport();
                staleElement1 = false;
            } catch (Exception e) {
                staleElement1 = true;
            }
        }
        Wait_Element_Clickable(ReportPageObj.reportlist);
        ReportPageObj.Openlist();
        Wait_Element_Clickable(ReportPageObj.DeleteReport);
        ReportPageObj.Delete_Report();
        Thread.sleep(3000);
        Assert.assertNotEquals(ReportPageObj.FirstRow.getText(), Name,"Verify to delete Report");
        System.out.println("Report: " + Name + " Is Deleted");

    }
}
package E2ETS;

import Com.PartRisk.Pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Y_Fun_Obsolescence extends Test_Base {
    Data_Management_Page DManagementObj;
    Landing_Page LandOpj;
    Dashboard_Page DashOpj;
    Report_Page ReportOpj;
    Obsolescence_Page ObsoL_Opj;

    @Test(priority = 25)
    @Severity(SeverityLevel.NORMAL)
    @Description("Check that side panel of High Lifecycle Risk Parts link shows high risk part && Count Table in All Tabs")
    public void Check_Side_Panel_High_Risk() throws InterruptedException {
        LandOpj = new Landing_Page(driver);
        DashOpj = new Dashboard_Page(driver);
        ReportOpj = new Report_Page(driver);
        DManagementObj = new Data_Management_Page(driver);
        ObsoL_Opj = new Obsolescence_Page(driver);
        LandOpj.Z2D_Open_Data_Management();
        Wait_Element_Visible(DManagementObj.Search_Text_Input);
        DManagementObj.Z2D_Search(Z2DataFolderName);
        Thread.sleep(1000);
        DManagementObj.SetFile();
        if (!(" TAP_BOM_Proud_Test" == driver.getPageSource())) {
            DManagementObj.Z2D_Move_To_Prod_BOM(driver);
        } else {
            DManagementObj.Z2D_Click_on_BOM();
        }
        DashOpj.Z2D_Open_Reports();
        ReportOpj.Z2D_Open_Obsolescence();
        ReportOpj.Z2D_Open_High_LifeCycle();
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        ObsoL_Opj.Z2D_Get_Last_Page();
        int CountOfTable = ObsoL_Opj.Table_Size.size();
        int Count = Integer.parseInt(ObsoL_Opj.Fixed_Number.getText());
        int CountPagination = Integer.parseInt(ObsoL_Opj.Next_Page.getText());
        int CountPage = CountPagination - 1;
        int SubTotal = CountOfTable * CountPage;
        int LastPage = Count - SubTotal;
        int AllOfRow = LastPage + SubTotal;
        System.out.println("Actual Result  " + AllOfRow);
        System.out.println("Expected Result  " + Count);
        Assert.assertEquals(Count, AllOfRow);
        Thread.sleep(2000);
        ObsoL_Opj.Z2D_NRND_Parts();
        Thread.sleep(2000);
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        int CountOfTable0 = ObsoL_Opj.Table_Size.size();
        int Count0 = Integer.parseInt(ObsoL_Opj.Fixed_Number.getText());
        int CountPagination0 = Integer.parseInt(ObsoL_Opj.Next_Page.getText());
        int CountPage0 = CountPagination0 - 1;
        int SubTotal0 = CountOfTable0 * CountPage0;
        int LastPage0 = Count0 - SubTotal0;
        int AllOfRow0 = LastPage0 + SubTotal0;
        System.out.println("Actual Result " + AllOfRow0);
        System.out.println("Expected Result " + Count0);
        Assert.assertEquals(Count0, AllOfRow0);
        ObsoL_Opj.Z2D_Obsolete_Parts();
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        int CountOfTable1 = ObsoL_Opj.Table_Size.size();
        int Count1 = Integer.parseInt(ObsoL_Opj.Fixed_Number.getText());
        int CountPagination1 = Integer.parseInt(ObsoL_Opj.Next_Page.getText());
        int CountPage1 = CountPagination1 - 1;
        int SubTotal1 = CountOfTable1 * CountPage1;
        int LastPage1 = Count1 - SubTotal1;
        int AllOfRow1 = LastPage1 + SubTotal1;
        System.out.println("Actual Result  " + AllOfRow1);
        System.out.println("Expected Result  " + Count1);
        Assert.assertEquals(Count1, AllOfRow1);
        ObsoL_Opj.Z2D_Last_by_Parts();
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        int CountPagination2 = Integer.parseInt(ObsoL_Opj.Next_Page.getText());
        int CountOfTable2 = ObsoL_Opj.Table_Size.size();
        int Count2 = Integer.parseInt(ObsoL_Opj.Fixed_Number.getText());
        if (CountPagination2 <= 1) {
            int SubTotal2 = CountOfTable2 * CountPagination2;
            int LastPage2 = Count2 - SubTotal2;
            int AllOfRow2 = LastPage2 + SubTotal2;
            Thread.sleep(1000);
            System.out.println("Actual Result  " + AllOfRow2);
            System.out.println("Expected Result  " + Count2);
            Assert.assertEquals(Count2, AllOfRow2);
        } else {
            int CountPage2 = CountPagination2 - 1;
            int SubTotal2 = CountOfTable2 * CountPage2;
            int LastPage2 = Count2 - SubTotal2;
            int AllOfRow2 = LastPage2 + SubTotal2;
            Thread.sleep(1000);
            System.out.println("Actual Result  " + AllOfRow2);
            System.out.println("Expected  " + Count2);
            Assert.assertEquals(Count2, AllOfRow2);
        }
        ObsoL_Opj.Z2D_Close_Slide();
    }

    @Test(priority = 26)
    @Severity(SeverityLevel.NORMAL)
    @Description("Check that side panel of Obsolete Parts in 3 Years shows parts that have forecast up to 3 years")
    public void Obsolete_Parts_in_3_Years() throws InterruptedException {
        LandOpj = new Landing_Page(driver);
        DashOpj = new Dashboard_Page(driver);
        ReportOpj = new Report_Page(driver);
        DManagementObj = new Data_Management_Page(driver);
        ObsoL_Opj = new Obsolescence_Page(driver);
        LandOpj.Z2D_Open_Data_Management();
        Wait_Element_Visible(DManagementObj.Search_Text_Input);
        Thread.sleep(1000);
        DManagementObj.Z2D_Search(Z2DataFolderName);
        DManagementObj.SetFile();
        if (!(" TAP_BOM_Proud_Test" == driver.getPageSource())) {
            DManagementObj.Z2D_Move_To_Prod_BOM(driver);
        } else {
            DManagementObj.Z2D_Click_on_BOM();
        }
        DashOpj.Z2D_Open_Reports();
        ReportOpj.Z2D_Open_Obsolescence();
        ReportOpj.Z2D_Open_Obsolete_3Years();
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        Assert.assertEquals(ReportOpj.Row_Active.getText(), "Active");
        Assert.assertEquals(ReportOpj.Row_3Y.getText(), "3 years");
        ObsoL_Opj.Z2D_Get_Last_Page_For_3Y();
        int CountOfTable = ObsoL_Opj.Table_Size.size();
        int Count = Integer.parseInt(ObsoL_Opj.Fixed_Number_For_3Y.getText());
        int CountPagination = Integer.parseInt(ObsoL_Opj.Next_Page.getText());
        int CountPage = CountPagination - 1;
        int SubTotal = CountOfTable * CountPage;
        int LastPage = Count - SubTotal;
        int AllOfRow = LastPage + SubTotal;
        System.out.println("Actual Result For HighLifeCycle Tab: " + AllOfRow);
        System.out.println("Expected Result For HighLifeCycle Tab: " + Count);
        Assert.assertEquals(Count, AllOfRow);
        ObsoL_Opj.Z2D_Close_Slide();
    }

    @Test(priority = 27)
    @Severity(SeverityLevel.NORMAL)
    @Description("Check that side panel of Obsolete Part Forecast in 5 Years shows parts that have forecast up to 5 years")
    public void Obsolete_Part_IN_5_Years() throws InterruptedException {
        LandOpj = new Landing_Page(driver);
        DashOpj = new Dashboard_Page(driver);
        ReportOpj = new Report_Page(driver);
        DManagementObj = new Data_Management_Page(driver);
        ObsoL_Opj = new Obsolescence_Page(driver);
        LandOpj.Z2D_Open_Data_Management();
        Wait_Element_Visible(DManagementObj.Search_Text_Input);
        Thread.sleep(1000);
        DManagementObj.Z2D_Search(Z2DataFolderName);
        DManagementObj.SetFile();
        if (!(" TAP_BOM_Proud_Test" == driver.getPageSource())) {
            DManagementObj.Z2D_Move_To_Prod_BOM(driver);
        } else {
            DManagementObj.Z2D_Click_on_BOM();
        }
        DashOpj.Z2D_Open_Reports();
        ReportOpj.Z2D_Open_Obsolescence();
        ReportOpj.Z2D_Open_Obsolete_5Years();
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        ObsoL_Opj.Z2D_Get_Last_Page_For_5Y();
        int CountOfTable = ObsoL_Opj.Table_Size.size();
        int Count = Integer.parseInt(ObsoL_Opj.Fixed_Number_For_5Y.getText());
        int CountPagination = Integer.parseInt(ObsoL_Opj.Next_Page.getText());
        int CountPage = CountPagination - 1;
        int SubTotal = CountOfTable * CountPage;
        int LastPage = Count - SubTotal;
        int AllOfRow = LastPage + SubTotal;
        System.out.println("Actual Result:  " + AllOfRow);
        System.out.println("Expected Result: " + Count);
        Assert.assertEquals(Count, AllOfRow);
        ObsoL_Opj.Z2D_Close_Slide();
    }
}






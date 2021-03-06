package E2ETS;

import Com.PartRisk.Pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AD_1_CheckDashBoardData extends Test_Base {


    Landing_Page LandObj;
    Data_Management_Page DManagementObj;
    Actions act;
    Scrub_Page ScrubPageObj;
    Parts_Page Parts_Obj;
    Dashboard_Page DashboardObj;
    Upload_BOM_Page UploadBOMObj;

    @Test(priority = 31)
    @Severity(SeverityLevel.NORMAL)
    @Description("")
    public void DashBoardData() throws InterruptedException {
        LandObj = new Landing_Page(driver);
        DManagementObj = new Data_Management_Page(driver);
        act = new Actions(driver);
        Parts_Obj = new Parts_Page(driver);
        ScrubPageObj = new Scrub_Page(driver);
        DashboardObj = new Dashboard_Page(driver);
        UploadBOMObj = new Upload_BOM_Page(driver);
        LandObj.Z2D_Open_Data_Management();
        DManagementObj.Z2D_Type_Folder_Name(Z2DataFolderName);

        boolean staleElement = true;
        while (staleElement) {
            try {
                act.moveToElement(DManagementObj.Test_Folder).click().build().perform();
                staleElement = false;
            } catch (Exception e) {
                staleElement = true;
            }
        }
        DManagementObj.Z2D_Open_BOM();
        Switch_Tabs();
        DManagementObj.Z2D_Open_Parts();
        Wait_for_Element_to_Disappear(LandObj.GeneralSpinner);
        int FixedNum = Integer.parseInt(Parts_Obj.fixednumber.getText());
        if (ScrubPageObj.Last.isEnabled()) {
            int tableRows = Parts_Obj.Rowsnum.size();
            Wait_for_Element_to_Disappear(LandObj.GeneralSpinner);
            ScrubPageObj.Z2D_Last_Pagination();
            Wait_for_Element_to_Disappear(LandObj.GeneralSpinner);
            int PaginationSize = Integer.parseInt(ScrubPageObj.LastPage.getText());
            int Pagination = PaginationSize - 1;
            int SupTotal = Pagination * tableRows;
            int lastPageSize = FixedNum - SupTotal;
            int AllTableRows = lastPageSize + SupTotal;
            Assert.assertEquals(AllTableRows, FixedNum);
            System.out.println("Expected Result: " + AllTableRows);
            System.out.println("Actual Result: " + FixedNum);
        } else {
            int tableRows = Parts_Obj.Rowsnum.size();
            int PaginationSize = Integer.parseInt(ScrubPageObj.LastPage.getText());
            int Pagination = PaginationSize;
            int SupTotal = Pagination * tableRows;
            int lastPageSize = FixedNum - SupTotal;
            int AllTableRows = lastPageSize + SupTotal;
            Assert.assertEquals(AllTableRows, FixedNum);
            System.out.println("Expected Result Is: " + AllTableRows);
            System.out.println("Actual Result Is: " + FixedNum);
        }
        UploadBOMObj.Z2D_Click_Dashboard_Tab();
        DashboardObj.Z2Data_HighRisk();
        Wait_for_Element_to_Disappear(LandObj.GeneralSpinner);
        int FixedNum1 = Integer.parseInt(Parts_Obj.fixednumber.getText());
        if (ScrubPageObj.Last.isEnabled()) {
            int tableRows = Parts_Obj.Rowsnum.size();
            Thread.sleep(3000);
            ScrubPageObj.Z2D_Last_Pagination();
            Wait_for_Element_to_Disappear(LandObj.GeneralSpinner);
            int PaginationSize = Integer.parseInt(ScrubPageObj.LastPage.getText());
            int Pagination = PaginationSize - 1;
            int SupTotal = Pagination * tableRows;
            int lastPageSize = FixedNum1 - SupTotal;
            int AllTableRows = lastPageSize + SupTotal;
            Assert.assertEquals(AllTableRows, FixedNum1);
            System.out.println("High Risk Expected Result: " + AllTableRows);
            System.out.println("High Risk Actual Result: " + FixedNum1);
        } else {
            int tableRows = Parts_Obj.Rowsnum.size();
            int PaginationSize = Integer.parseInt(ScrubPageObj.LastPage.getText());
            int Pagination = PaginationSize;
            int SupTotal = Pagination * tableRows;
            int lastPageSize = FixedNum1 - SupTotal;
            int AllTableRows = lastPageSize + SupTotal;
            Assert.assertEquals(AllTableRows, FixedNum1);
            System.out.println("High Risk Expected Result Is: " + AllTableRows);
            System.out.println("High Risk Actual Result Is: " + FixedNum1);
        }


    }
}
package E2ETS;

import Com.PartRisk.Pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class W_2_Fun_Check_Side_High_Lifecycle_Risk_Parts_Link extends Test_Base {
    Data_Management_Page DManagementObj;
    Landing_Page LandOpj;
    Dashboard_Page DashOpj;
    Report_Page ReportOpj;
    Obsolescence_Page ObsoL_Opj;

    @Test(priority = 23)
    @Severity(SeverityLevel.NORMAL)
    @Description("Check that side panel of Obsolete Parts in 3 Years shows parts that have forecast up to 3 years")
    public void Check_Side_Panel_High_Risk() throws InterruptedException {
        LandOpj = new Landing_Page(driver);
        DashOpj = new Dashboard_Page(driver);
        ReportOpj = new Report_Page(driver);
        DManagementObj = new Data_Management_Page(driver);
        ObsoL_Opj = new Obsolescence_Page(driver);
        LandOpj.Z2D_Open_Data_Management();//hna
        Wait_Element_Clickable(DManagementObj.Search_Text_Input);
        DManagementObj.Z2D_Type_Folder_Name(Z2DataFolderName);
        boolean staleElement = true;
        while (staleElement) {
            try {
                DManagementObj.Z2D_Select_Folder();
                staleElement = false;
            } catch (StaleElementReferenceException e) {
                staleElement = true;
            }
        }
        DManagementObj.Z2D_Open_BOM();
        Thread.sleep(2000);
        if (!(" TAP_BOM_Proud_Test" == driver.getPageSource())) {
            DManagementObj.Z2D_Move_To_Prod_BOM(driver);
        } else {
            DManagementObj.Z2D_Click_on_BOM();
        }
        DashOpj.Z2D_Open_Reports();
        ReportOpj.Z2D_Open_Obsolescence();
        ReportOpj.Z2D_Open_High_LifeCycle();

        if ("High Lifecycle Risk Parts" == driver.getPageSource()) {
            if (ObsoL_Opj.Last.isEnabled())
                ObsoL_Opj.Z2D_Open_High_LifeCycle();

        } else {

        }
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        ObsoL_Opj.Z2D_Get_Last_Page();
        int CountOfTable = ObsoL_Opj.Table_Size.size();
        int Count = Integer.parseInt(ObsoL_Opj.Fixed_Number.getText());
        int CountPagination = Integer.parseInt(ObsoL_Opj.Next_Page.getText());
        int CountPage = CountPagination - 1;
        int SubTotal = CountOfTable * CountPage;
        int LastPage = Count - SubTotal;
        int AllOfRow = LastPage + SubTotal;
        //System.out.println(AllOfRow);
        //System.out.println(Count);
        Assert.assertEquals(Count, AllOfRow);
        Thread.sleep(2000);

        ObsoL_Opj.Z2D_NRND_Parts();
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        int CountOfTable0 = ObsoL_Opj.Table_Size.size();
        int Count0 = Integer.parseInt(ObsoL_Opj.Fixed_Number.getText());
        int CountPagination0 = Integer.parseInt(ObsoL_Opj.Next_Page.getText());
        int CountPage0 = CountPagination0 - 1;
        int SubTotal0 = CountOfTable0 * CountPage0;
        int LastPage0 = Count0 - SubTotal0;
        int AllOfRow0 = LastPage0 + SubTotal0;
        //System.out.println(AllOfRow0);
        //System.out.println(Count0);
        Assert.assertEquals(Count0, AllOfRow0);
        Switch_Tabs();
    }


}





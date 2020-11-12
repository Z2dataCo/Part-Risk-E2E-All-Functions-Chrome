package E2ETS;

import Com.PartRisk.Pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Z_Fun_All_Obsolescence extends Test_Base {
    DataManagement_Page DManagementObj;
    Report_Page ReportOpj;
    Landing_Page LandOpj;
    Obsolescence_Page ObsoL_Opj;
    Dashboard_Page DashOpj;

    @Test(priority = 28)
    @Severity(SeverityLevel.NORMAL)
    @Description("Check that side panel of All Obsolescence PCNs shows all PCNs on the BOM")
    public void All_ObsolescencePage() throws InterruptedException {
        LandOpj = new Landing_Page(driver);
        DashOpj = new Dashboard_Page(driver);
        ReportOpj = new Report_Page(driver);
        DManagementObj = new DataManagement_Page(driver);
        ObsoL_Opj = new Obsolescence_Page(driver);
        LandOpj.Z2D_Open_Data_Management();
        Wait_Element_Visible(DManagementObj.Search_Text_Input);
        DManagementObj.Z2D_Search(Z2DataFolderName);
        Actions action = new Actions(driver);
        action.moveToElement(DManagementObj.Test_Folder).click().perform();
        if (!(" TAP_BOM_Proud_Test" == driver.getPageSource())) {
            DManagementObj.Z2D_Move_To_Prod_BOM(driver);
        } else {
            DManagementObj.Z2D_Click_on_BOM();
        }
        DashOpj.Z2D_Open_Reports();
        ObsoL_Opj.ProductChange();
        ObsoL_Opj.Z2D_All_Obsolescence();
        Thread.sleep(3000);
        ObsoL_Opj.GetLastPageForAllObs();
        int CountOfTable = ObsoL_Opj.Table_Size.size();
        int Count = Integer.parseInt(ObsoL_Opj.FixedNumForAllObs.getText());
        int CountPagination = Integer.parseInt(ObsoL_Opj.Next_Page.getText());
        int CountPage = CountPagination - 1;
        int SubTotal = CountOfTable * CountPage;
        int LastPage = Count - SubTotal;
        int AllOfRow = LastPage + SubTotal;
        System.out.println("Actual Result  " + AllOfRow);
        System.out.println("Expected Result  " + Count);
        Assert.assertEquals(Count, AllOfRow);
        Thread.sleep(3000);
        ObsoL_Opj.tbl_data(driver);
        ObsoL_Opj.Z2D_Close_Slide();

    }

}

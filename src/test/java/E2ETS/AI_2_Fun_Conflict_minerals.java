package E2ETS;

import Com.PartRisk.Pages.Dashboard_Page;
import Com.PartRisk.Pages.Data_Management_Page;
import Com.PartRisk.Pages.Landing_Page;
import Com.PartRisk.Pages.Reports_Page;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AI_2_Fun_Conflict_minerals extends Test_Base {
    Data_Management_Page DManagementObj;
    Actions act;
    Landing_Page landingPage;
    Dashboard_Page DashOpj;
    Reports_Page ReportOpj;

    @Test
    public void Check_Report_Gold_Tantalum_Tin_Tungsten_Cobalt() throws InterruptedException {
        DManagementObj = new Data_Management_Page(driver);
        landingPage = new Landing_Page(driver);
        ReportOpj = new Reports_Page(driver);
        DashOpj = new Dashboard_Page(driver);
        act = new Actions(driver);
        landingPage.Z2D_Open_Data_Management();
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
        DashOpj.Z2D_Open_Reports();
        ReportOpj.Open_ConflictMinerals();
        ReportOpj.OpenConMetals();
        Assert.assertEquals(ReportOpj.Tungsten.getText(),"Tungsten");
    }

}

package E2ETS;

import Com.PartRisk.Pages.Data_Management_Page;
import Com.PartRisk.Pages.Landing_Page;
import Com.PartRisk.Pages.Reports_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AH_Fun_Check_Minerals_Metal_Report extends Test_Base {
    Data_Management_Page DManagementObj;
    Reports_Page ReportPageObj;
    Landing_Page LandObj;
    @Test()
    @Severity(SeverityLevel.NORMAL)
    @Description("Check Conflict Minerals Reports : Minerals Chemical Reports & Exporting As Excel")

    public void Check_Minerals_Report() throws InterruptedException {

        DManagementObj = new Data_Management_Page(driver);
        ReportPageObj = new Reports_Page(driver);
        LandObj = new Landing_Page(driver);

        DManagementObj.Z2D_Move_to_Reports_Bom(driver);
        ReportPageObj.Z2D_Open_Minerals_Metal_Report();
        Wait_Invisibility_oF_List(LandObj.SpinnerZezo2);
        Wait_Element_Visible(ReportPageObj.Report_Window_Title);
        Assert.assertEquals(ReportPageObj.Report_Window_Title.getText(),("Conflict Minerals Metal"));
        Wait_Element_Visible(ReportPageObj.Export_Button);
        ReportPageObj.Z2D_Export_Report_Excel();
    }

}

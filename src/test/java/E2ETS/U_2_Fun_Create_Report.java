package E2ETS;

import Com.PartRisk.Pages.Dashboard_Page;
import Com.PartRisk.Pages.Data_Management_Page;
import Com.PartRisk.Pages.Landing_Page;
import Com.PartRisk.Pages.Reports_Page;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class U_2_Fun_Create_Report extends Test_Base {
    Faker faker = new Faker();
    String Name = faker.name().firstName() + "1";
    Dashboard_Page DashboardPageObj;
    Reports_Page ReportPageObj;
    Data_Management_Page DManagementObj;
    Landing_Page LandObj;

    @Test(priority = 21)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate To Create , Review Report And Download ")
    public void Create_Report_Download() throws InterruptedException {
        LandObj = new Landing_Page(driver);
        DManagementObj = new Data_Management_Page(driver);
        DashboardPageObj = new Dashboard_Page(driver);
        ReportPageObj = new Reports_Page(driver);

        DManagementObj.Z2D_Move_to_Reports_Bom(driver);
        ReportPageObj.Z2D_Open_Create_Report();
        Wait_Element_Clickable(ReportPageObj.Check_Box1);
        Wait_Element_Clickable(ReportPageObj.Check_Box2);
        ReportPageObj.Z2D_Select_Parameter();
        ReportPageObj.Z2D_Save_Report();
        ReportPageObj.Z2D_Enter_Report_Name(Name);
        ReportPageObj.Z2D_Confirm_Report();

        Wait_Element_Invisibility(DManagementObj.Toast_Container);
        ReportPageObj.Z2D_Preview_Report();
        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        Wait_Element_Visible(ReportPageObj.Report_Window_Title);
        Assert.assertEquals(ReportPageObj.Report_Window_Title.getText(), ("Report Preview"));
        Assert.assertEquals(ReportPageObj.Download_Btn.getText(), ("Download"));
        //ReportPageObj.Z2D_Download_Report();
        Wait_Element_Clickable(ReportPageObj.Close_Preview);
        ReportPageObj.Z2D_Close_Preview();

        Wait_Element_Clickable(ReportPageObj.CusReport);
        ReportPageObj.CustomReport();
        String Saved_Report = ReportPageObj.FirstRow.getText();
        Assert.assertEquals(Saved_Report, Name);

        Wait_Element_Clickable(ReportPageObj.reportlist);
        ReportPageObj.Openlist();
        Wait_Element_Clickable(ReportPageObj.DeleteReport);
        ReportPageObj.Delete_Report();
        Wait_Element_Invisibility(DManagementObj.Toast_Container);
        driver.navigate().refresh();
        String Deleted_Report = ReportPageObj.FirstRow.getText();
        Assert.assertNotEquals(Deleted_Report, Name, "Verify to delete Report");
        System.out.println("Report: " + Name + " Is Deleted");

}
}

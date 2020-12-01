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
        ReportPageObj.Z2D_Click_on_Saved_Reports_List();
        if (ReportPageObj.First_Report_Name.getText().equals(Name)){
        String Saved_Report = ReportPageObj.First_Report_Name.getText();
        Assert.assertEquals(Saved_Report, Name);}
        else {
            ReportPageObj.Z2D_Re_Click_on_Saved_Reports_List();
            String Saved_Report = ReportPageObj.First_Report_Name.getText();
            Assert.assertEquals(Saved_Report, Name);}

        ReportPageObj.Z2D_Preview_Report();
        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        Wait_Element_Visible(ReportPageObj.Report_Window_Title);
        Assert.assertEquals(ReportPageObj.Report_Window_Title.getText(), ("Report Preview"));
        Assert.assertEquals(ReportPageObj.Download_Btn.getText(), ("Download"));
        ReportPageObj.Z2D_Download_Report();
        Wait_Element_Clickable(ReportPageObj.Close_Preview);
        ReportPageObj.Z2D_Close_Preview();

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
        Assert.assertNotEquals(ReportPageObj.FirstRow.getText(), Name, "Verify to delete Report");
        System.out.println("Report: " + Name + " Is Deleted");

}
}

  /*   Implicitly();
        Select index = new Select(ReportPageObj.DDL_Report);
        Thread.sleep(3500);
        String ExpectedResult = index.getOptions().get(1).getText();
        String ActualResult = Name;
        if (!(ExpectedResult == ActualResult)) {
            WaitAllElement();
            Assert.assertEquals(ActualResult, ExpectedResult); // hna
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
            Thread.sleep(3000);
            ReportPageObj.Z2D_Close_Preview();
            Wait_for_Element_to_Disappear(DManagementObj.Spinner);
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
            Thread.sleep(3000);
            ReportPageObj.Z2D_Close_Preview();
      `      Wait_for_Element_to_Disappear(DManagementObj.Spinner);
`}}
*/
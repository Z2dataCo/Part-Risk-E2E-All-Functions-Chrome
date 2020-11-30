package E2ETS;

import Com.PartRisk.Pages.Data_Management_Page;
import Com.PartRisk.Pages.Landing_Page;
import Com.PartRisk.Pages.Reports_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AG_Fun_Check_Compliance_MPN_Report extends Test_Base{

    Data_Management_Page DManagementObj;
    Reports_Page ReportPageObj;
    Landing_Page LandObj;

    @Test()
    @Severity(SeverityLevel.NORMAL)
    @Description("Check Conflict Minerals Reports : Compliance MPN Reports")
    public void Check_Compliance_Report() throws InterruptedException {
        DManagementObj = new Data_Management_Page(driver);
        ReportPageObj = new Reports_Page(driver);
        LandObj = new Landing_Page(driver);

        DManagementObj.Z2D_Move_to_Reports_Bom(driver);
        ReportPageObj.Z2D_Open_Compliance_MPN_Report();
        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        Wait_Element_Visible(ReportPageObj.Report_Window_Title);
        Assert.assertEquals(ReportPageObj.Report_Window_Title.getText(), "Conflict Mineral Compliance by Part");

        String First_Filter = ReportPageObj.First_Filter.getText();
        Wait_Text_To_be(ReportPageObj.Info_Total,First_Filter.replace(" Parts" ,""));
        Assert.assertTrue(First_Filter.contains(ReportPageObj.Info_Total.getText()));

        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        Wait_Element_Clickable(ReportPageObj.Second_Filter);
        ReportPageObj.Z2D_Click_on_2nd_Filter();
        String Sec_Filter = ReportPageObj.Second_Filter.getText();
        Wait_Text_To_be(ReportPageObj.Info_Total,Sec_Filter.replace(" Parts" ,""));
        Assert.assertTrue(Sec_Filter.contains(ReportPageObj.Info_Total.getText()));

        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        Wait_Element_Clickable(ReportPageObj.Third_Filter);
        ReportPageObj.Z2D_Click_on_3rd_Filter();
        String Third_Filter = ReportPageObj.Third_Filter.getText();
        Wait_Text_To_be(ReportPageObj.Info_Total,Third_Filter.replace(" Parts" ,""));
        Assert.assertTrue(Third_Filter.contains(ReportPageObj.Info_Total.getText()));

        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        Wait_Element_Clickable(ReportPageObj.Fourth_Filter);
        ReportPageObj.Z2D_Click_on_4th_Filter();
        String Fourth_Filter = ReportPageObj.Fourth_Filter.getText();
        Wait_Text_To_be(ReportPageObj.Info_Total,Fourth_Filter.replace(" Parts" ,""));
        Assert.assertTrue(Fourth_Filter.contains(ReportPageObj.Info_Total.getText()));
    }




    }


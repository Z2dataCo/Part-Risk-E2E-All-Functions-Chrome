package E2ETS;

import Com.PartRisk.Pages.Data_Management_Page;
import Com.PartRisk.Pages.Landing_Page;
import Com.PartRisk.Pages.Reports_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AF_2_Check_Supplier_Report extends Test_Base{
    Data_Management_Page DManagementObj;
    Reports_Page ReportPageObj;
    Landing_Page LandObj;
    @Test()
    @Severity(SeverityLevel.NORMAL)
    @Description("Check Conflict Minerals Reports : Suppliers Reports")
    public void Check_Supplier_Report() throws InterruptedException {
        DManagementObj = new Data_Management_Page(driver);
        ReportPageObj = new Reports_Page(driver);
        LandObj = new Landing_Page(driver);

        DManagementObj.Z2D_Move_to_Reports_Bom(driver);
        ReportPageObj.Z2D_Open_Supplier_Report();

        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        Wait_Element_Visible(ReportPageObj.Smelters_Window_Title);
        Assert.assertTrue(ReportPageObj.Smelters_Window_Title.getText().contains("Conflict Mineral Compliance by Supplier"));

        String Total = ReportPageObj.First_Filter.getText();
        System.out.println(Total);
        Wait_Text_Not_To_be(ReportPageObj.Info_Total,"0");
        String Info_Total=ReportPageObj.Info_Total.getText();
        System.out.println(Info_Total);
        Assert.assertTrue(Total.contains(Info_Total));

        ReportPageObj.Z2D_Click_on_2nd_Filter();
        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        String Sec_Filter = ReportPageObj.Second_Filter.getText();
        System.out.println(Sec_Filter);
        Wait_Text_Not_To_be(ReportPageObj.Info_Total,"0");
        String Info_Total2=ReportPageObj.Info_Total.getText();
        System.out.println(Info_Total2);
        Assert.assertTrue(Sec_Filter.contains(Info_Total2));

        ReportPageObj.Z2D_Click_on_3rd_Filter();
        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        String Third_Filter = ReportPageObj.Third_Filter.getText();
        System.out.println(Third_Filter);
        Wait_Text_Not_To_be(ReportPageObj.Info_Total,"0");
        String Info_Total3 = ReportPageObj.Info_Total.getText();
        System.out.println(Info_Total3);
        Assert.assertTrue(Third_Filter.contains(Info_Total3));

        ReportPageObj.Z2D_Click_on_4th_Filter();
        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        String Fourth_Filter = ReportPageObj.Fourth_Filter.getText();
        System.out.println(Fourth_Filter);
        Wait_Element_Clickable(ReportPageObj.Fourth_Filter);
        String Info_Total4 = ReportPageObj.Info_Total.getText();
        System.out.println(Info_Total4);
        Assert.assertTrue(Fourth_Filter.contains(Info_Total4));
    }
    }

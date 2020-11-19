package E2ETS;

import Com.PartRisk.Pages.Compliance_Page;
import Com.PartRisk.Pages.Data_Management_Page;
import Com.PartRisk.Pages.Forecast_Page;
import Com.PartRisk.Pages.Landing_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T_2_Fun_Filters_For_Compliance extends Test_Base {
    Compliance_Page CompliancePageObj;
    Data_Management_Page DManagementObj;
    Landing_Page LandObj;
    Forecast_Page ForeCastObj;

    @Test(priority = 20)
    @Severity(value = SeverityLevel.NORMAL)
    @Description("Validate Filter on Compliance Page &  Check table's data")
    public void Filters_For_Compliance() {
        LandObj = new Landing_Page(driver);
        DManagementObj = new Data_Management_Page(driver);
        CompliancePageObj = new Compliance_Page(driver);
        ForeCastObj = new Forecast_Page(driver);

        DManagementObj.Z2D_Move_to_Compliance_Bom(driver);
        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        Wait_Element_Clickable(CompliancePageObj.First_Check_Box_Filter);
        CompliancePageObj.Z2D_Click_on_First_Filter();
        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        String FirstTotal = CompliancePageObj.First_Filter_Total.getText();
        Wait_Text_To_be(CompliancePageObj.Total_Filter_Results,FirstTotal);
        String AllTotal = CompliancePageObj.Total_Filter_Results.getText();
        Assert.assertEquals(FirstTotal, AllTotal);

        Wait_Element_Clickable(CompliancePageObj.Second_Check_Box_Filter);
        CompliancePageObj.Z2D_Click_on_Second_Filter();
        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        String SecTotal = CompliancePageObj.Second_Filter_Total.getText();
        Wait_Text_To_be(CompliancePageObj.Total_Filter_Results,SecTotal);
        String AllTotal2 = CompliancePageObj.Total_Filter_Results.getText();
        Assert.assertEquals(SecTotal, AllTotal2);
    }
}
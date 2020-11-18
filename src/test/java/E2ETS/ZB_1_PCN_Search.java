package E2ETS;

import Com.PartRisk.Pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ZB_1_PCN_Search extends Test_Base {
    Landing_Page LandObj;
    Data_Management_Page DManagementObj;
    Forecast_Page ForeCastObj;
    Mitigation_Page MitigationObj;
    PCN_Manager_Page PCN_ManagerObj;


    @Test(priority = 30)
    @Severity(SeverityLevel.NORMAL)
    @Description("Check MPN Search Functionality using PCN Id & MPN ")
    public void PCN_Search () throws InterruptedException {

        LandObj = new Landing_Page(driver);
        DManagementObj = new Data_Management_Page(driver);
        ForeCastObj = new Forecast_Page(driver);
        MitigationObj = new Mitigation_Page(driver);
        PCN_ManagerObj = new PCN_Manager_Page(driver);

        LandObj.Z2D_Open_PCN_Manager();
        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        Wait_Element_Visible(PCN_ManagerObj.Dashboard_Tab_Total_PCNs);
        PCN_ManagerObj.Z2D_Open_PCNs_Tab();
        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        PCN_ManagerObj.Z2D_Search("PD22748X");
        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        Wait_Element_Visible(PCN_ManagerObj.Results_Table);
        Wait_Text_To_be(PCN_ManagerObj.First_Search_Result,"PCN #:PD22748X");
        String Search_Result = PCN_ManagerObj.First_Search_Result.getText();
        Assert.assertTrue(Search_Result.contains("PD22748X"));




    }
}

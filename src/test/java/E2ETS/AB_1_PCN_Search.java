package E2ETS;

import Com.PartRisk.Pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AB_1_PCN_Search extends Test_Base {
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
        Wait_for_Element_to_Disappear(LandObj.GeneralSpinner);
        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        Wait_Element_Visible(PCN_ManagerObj.Dashboard_Tab_Total_PCNs);
        PCN_ManagerObj.Z2D_Open_PCNs_Tab();
        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        String Before_Search = PCN_ManagerObj.Showing_Of_Total.getText();
        PCN_ManagerObj.Z2D_Search(Z2DataPCNID);
        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        Wait_Element_Visible(PCN_ManagerObj.Results_Table);
        Wait_Text_To_Be(PCN_ManagerObj.Showing_Of_Total,"Showing 1-3 of");
        String Search_Result = PCN_ManagerObj.First_Search_Result.getText();
        Assert.assertTrue(Search_Result.contains(Z2DataPCNID));

        PCN_ManagerObj.Z2D_Search(Z2DataMPNID);
        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        Wait_Element_Visible(PCN_ManagerObj.Results_Table);
        Wait_Text_Not_To_be(PCN_ManagerObj.Showing_Of_Total,"Showing 1-21 of");
        PCN_ManagerObj.Z2D_Open_First_Search_Result();
        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        Wait_Text_To_Be(PCN_ManagerObj.FSP_Text,"FSP Power Solution GmbH");
        PCN_ManagerObj.Z2D_Move_To_Impacted_MPN();
        String Impacted_MPN_Data = PCN_ManagerObj.Impacted_MPN_Results.getText();
        Assert.assertTrue(Impacted_MPN_Data.contains(Z2DataMPNID));
    }
}

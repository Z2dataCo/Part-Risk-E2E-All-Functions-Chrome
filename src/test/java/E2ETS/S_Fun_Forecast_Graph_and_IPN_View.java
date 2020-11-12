package E2ETS;

import Com.PartRisk.Pages.DataManagement_Page;
import Com.PartRisk.Pages.Forecast_Page;
import Com.PartRisk.Pages.Landing_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import java.io.IOException;

public class S_Fun_Forecast_Graph_and_IPN_View extends Test_Base {
    DataManagement_Page DManagementObj;
    Landing_Page LandObj;
    Forecast_Page ForeCastObj;

    @Test(priority = 19)
    @Severity(SeverityLevel.NORMAL)
    @Description("Validate Forecast tab Table IPN View Check table's data")

    public void ForeCast_Graph() throws InterruptedException {
        LandObj = new Landing_Page(driver);
        DManagementObj = new DataManagement_Page(driver);
        ForeCastObj = new Forecast_Page(driver);

        //LandObj.Z2D_Open_Data_Management();
        DManagementObj.Z2D_Move_To_Prod_BOM(driver);
        Wait_Element_Visible(ForeCastObj.ForeCast_Tab);
        ForeCastObj.Z2D_Click_on_Forecast_Tab();
        //Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        Wait_Element_Invisibility2(Z2dataSpinnerClassName);
        ForeCastObj.Z2D_Select_Switcher();
        //Wait_for_Element_to_Disappear(DManagementObj.Spinner);
    }
}

package E2ETS;

import Com.PartRisk.Pages.Compliance_Page;
import Com.PartRisk.Pages.Data_Management_Page;
import Com.PartRisk.Pages.Forecast_Page;
import Com.PartRisk.Pages.Landing_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T_Fun_Filters_For_Compliance extends Test_Base {
    Compliance_Page CompliancePageObj;
    Data_Management_Page DManagementObj;
    Landing_Page LandObj;
    Forecast_Page ForeCastObj;

    @Test(priority = 20)
    @Severity(value = SeverityLevel.NORMAL)
    @Description("Validate Filter on Compliance Page &  Check table's data")
    public void Filters_For_Compliance() throws InterruptedException {
        LandObj = new Landing_Page(driver);
        DManagementObj = new Data_Management_Page(driver);
        CompliancePageObj = new Compliance_Page(driver);
        ForeCastObj = new Forecast_Page(driver);

        LandObj.Z2D_Open_Data_Management();
        Thread.sleep(4000);
        DManagementObj.Z2D_Type_Folder_Name(Z2DataFolderName);
        DManagementObj.Z2D_Select_Folder();
        boolean staleElement = true;
        while (staleElement) {
            try {
                DManagementObj.Z2D_Click_on_BOM_File();
                staleElement = false;
            } catch (StaleElementReferenceException e) {
                staleElement = true;
            }
        }
        Switch_Tabs();
        Thread.sleep(2000);
        DManagementObj.Z2D_Click_on_Compliance_Tab();
        Wait_Element_Clickable(CompliancePageObj.First_Check_Box_Filter);
        CompliancePageObj.Z2D_Click_on_First_Filter();
        Wait_for_Element_to_Disappear(ForeCastObj.Spinner);
        String FirstTotal = CompliancePageObj.First_Filter_Total.getText();
        System.out.print("afterFilter Availabe is: " + FirstTotal);
        String AllTotal = CompliancePageObj.Total_Filter_Results.getText();
        System.out.print("afterFilter Total is " + AllTotal);
        Assert.assertEquals(FirstTotal, AllTotal);

        Wait_Element_Clickable(CompliancePageObj.Second_Check_Box_Filter);
        CompliancePageObj.Z2D_Click_on_Second_Filter();
        Wait_for_Element_to_Disappear(ForeCastObj.Spinner);
        String SecTotal = CompliancePageObj.Second_Filter_Total.getText();
        System.out.print("afterFilter Availabe is " + SecTotal);
        String AllTotal2 = CompliancePageObj.Total_Filter_Results.getText();
        System.out.print("afterFilter Total is " + AllTotal2);
        Assert.assertEquals(SecTotal, AllTotal2);
    }
}
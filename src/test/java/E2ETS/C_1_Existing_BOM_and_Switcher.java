package E2ETS;

import Com.PartRisk.Pages.*;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C_1_Existing_BOM_and_Switcher extends Test_Base {
    Landing_Page LandObj;
    Upload_BOM_Page UpBOMObj;
    Data_Management_Page DManagementObj;
    Mitigation_Page MitigationObj;
    Parts_Page PartsObj;
    Forecast_Page ForecastObj;

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Validate User Upload BOM")
    public void Existing_BOM_and_Switcher() throws InterruptedException {
        LandObj = new Landing_Page(driver);
        UpBOMObj = new Upload_BOM_Page(driver);
        DManagementObj = new Data_Management_Page(driver);
        MitigationObj = new Mitigation_Page(driver);
        PartsObj = new Parts_Page(driver);
        ForecastObj = new Forecast_Page(driver);

        LandObj.Z2D_Open_Data_Management();
        Wait_Element_Clickable(DManagementObj.Search_Text_Input);
        DManagementObj.Z2D_Type_Folder_Name(Z2DataFolderName);
        boolean staleElement = true;
        while (staleElement) {
            try {
                DManagementObj.Z2D_Select_Folder();
                staleElement = false;
            } catch (StaleElementReferenceException e) {
                staleElement = true;
            }
        }
        DManagementObj.Z2D_Open_BOM();
        Switch_Tabs();
        Wait_for_Element_to_Disappear(DManagementObj.Spinner);
        Wait_Element_Clickable(UpBOMObj.High_Risk_Card);
        Assert.assertTrue(UpBOMObj.High_Risk_Card.isDisplayed());
        Assert.assertTrue(UpBOMObj.Compliance_Card.isDisplayed());
        Assert.assertTrue(UpBOMObj.Market_Availability_Card.isDisplayed());
        Assert.assertEquals(UpBOMObj.Dashboard_Tab.getText(), "Dashboard");

        UpBOMObj.Z2D_Click_Scrub_Tab();
        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        Wait_Element_Clickable(UpBOMObj.Total_Card);
        Assert.assertTrue(UpBOMObj.Total_Card.isDisplayed());
        Assert.assertTrue(UpBOMObj.Exact_Matches.isDisplayed());
        Assert.assertEquals(UpBOMObj.Scrub_Tab.getText(), "Scrub");

        UpBOMObj.Z2D_Click_Parts_Tab();
        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        Wait_Element_Clickable(UpBOMObj.First_CheckBox);
        Assert.assertTrue(UpBOMObj.First_Table_Data.isDisplayed());

        UpBOMObj.Z2D_Click_Forecast_Tab();
        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        Wait_Element_Clickable(ForecastObj.First_Filter);
        Assert.assertTrue(ForecastObj.First_Filter.isDisplayed());
        Assert.assertTrue(ForecastObj.Second_Filter.isDisplayed());
        ForecastObj.Z2D_Select_Switcher();
        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        Wait_Element_Clickable(ForecastObj.First_Filter);
        Assert.assertTrue(ForecastObj.First_Filter.isDisplayed());
        Assert.assertTrue(ForecastObj.Second_Filter.isDisplayed());

        UpBOMObj.Z2D_Click_Compliance_Tab();
        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        Wait_Element_Clickable(UpBOMObj.First_CheckBox_Comp);
        Assert.assertTrue(UpBOMObj.First_Table_Data_Comp.isDisplayed());

        UpBOMObj.Z2D_Click_Mitigation_Tab();
        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        Wait_Element_Clickable(UpBOMObj.Total_Card_Mitigation);
        Assert.assertTrue(UpBOMObj.Total_Card_Mitigation.isDisplayed());
        Assert.assertTrue(UpBOMObj.Unknown_Card.isDisplayed());
        ForecastObj.Z2D_Select_Switcher();
        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        Assert.assertTrue(MitigationObj.Active_Parts.isDisplayed());
        Assert.assertTrue(MitigationObj.NRND_Parts.isDisplayed());

        UpBOMObj.Z2D_Click_Reports_Tab();
        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        Wait_Element_Clickable(UpBOMObj.Preview_Button);
        Assert.assertTrue(UpBOMObj.First_Report.isDisplayed()); 
    }
}
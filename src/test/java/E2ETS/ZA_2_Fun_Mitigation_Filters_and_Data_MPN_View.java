package E2ETS;

import Com.PartRisk.Pages.Data_Management_Page;
import Com.PartRisk.Pages.Forecast_Page;
import Com.PartRisk.Pages.Landing_Page;
import Com.PartRisk.Pages.Mitigation_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ZA_2_Fun_Mitigation_Filters_and_Data_MPN_View extends Test_Base{
    Landing_Page LandObj;
    Data_Management_Page DManagementObj;
    Forecast_Page ForeCastObj;
    Mitigation_Page MitigationObj;

    @Test(priority = 29)
    @Severity(SeverityLevel.NORMAL)
    @Description("Check Mitigation Filters & Data in MPN View")
    public void Mitigation_Filters_and_Data_MPN_View() throws InterruptedException {
        LandObj = new Landing_Page(driver);
        DManagementObj = new Data_Management_Page(driver);
        ForeCastObj = new Forecast_Page(driver);
        MitigationObj = new Mitigation_Page(driver);

        DManagementObj.Z2D_Move_to_Mitigation_Bom(driver);
        Wait_for_Element_to_Disappear(ForeCastObj.Spinner);
        while (MitigationObj.Added_Part_Label_List.size()!=0){
            MitigationObj.Z2D_Click_on_Close_Button(); }
        MitigationObj.Z2D_Click_on_DropinCrosses();
        Wait_for_Element_to_Disappear(ForeCastObj.Spinner);
        Wait_Element_Visible(MitigationObj.Table_Body);
        String Crosses_Part_Label = MitigationObj.Suggested_Part_Label.getText();
        MitigationObj.Z2D_Click_on_Add_Part_Button();
        String Added_part_Label = MitigationObj.Added_Part_Label.getText();
        Assert.assertEquals(Crosses_Part_Label,Added_part_Label);
        Wait_Element_Invisibility(DManagementObj.Toast_Container);
        MitigationObj.Z2D_Click_on_Close_Button();

        MitigationObj.Z2D_Click_on_View_Replacement_Button();
        Wait_for_Element_to_Disappear(ForeCastObj.Spinner);
        String Replacement_Part_Label = MitigationObj.Suggested_Part_Label.getText();
        MitigationObj.Z2D_Click_on_Add_Part_Button();
        String Added_part_Label2 = MitigationObj.Added_Part_Label.getText();
        Assert.assertEquals(Replacement_Part_Label,Added_part_Label2);
        MitigationObj.Z2D_Click_on_Close_Button();


        String Active_Parts = MitigationObj.Active_Parts.getText();
        System.out.println("Active_Filter_Value : " + Active_Parts);
        MitigationObj.Z2D_Click_on_Active_Filter();
        Wait_for_Element_to_Disappear(ForeCastObj.Spinner);
        String TotalFilterValue = ForeCastObj.TotalValue.getText();
        System.out.println("Total Filter Value : " + TotalFilterValue);
        Assert.assertEquals(TotalFilterValue + " Parts",Active_Parts );

        String NRND_Parts = MitigationObj.NRND_Parts.getText();
        System.out.println("NRND_Filter_Value : " + NRND_Parts);
        MitigationObj.Z2D_Click_on_NRND_Filter();
        Wait_for_Element_to_Disappear(ForeCastObj.Spinner);
        String TotalFilterValue2 = ForeCastObj.TotalValue.getText();
        System.out.println("Total Filter Value : " + TotalFilterValue2);
        Assert.assertEquals(TotalFilterValue2+ " Parts",NRND_Parts);

        String EndofLife_Parts = MitigationObj.End_Of_Life_Parts.getText();
        System.out.println("End_Of_Life_Parts : " + EndofLife_Parts);
        MitigationObj.Z2D_Click_on_EndofLife_Filter();
        Wait_for_Element_to_Disappear(ForeCastObj.Spinner);
        String TotalFilterValue3 = ForeCastObj.TotalValue.getText();
        System.out.println("Total Filter Value : " + TotalFilterValue3);
        Assert.assertEquals(TotalFilterValue3+ " Parts",EndofLife_Parts);
 }
}
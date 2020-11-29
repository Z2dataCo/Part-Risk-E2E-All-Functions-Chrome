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

public class T_2_Fun_Mitigation_Filters_and_Data_MPN_View extends Test_Base {
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
        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        MitigationObj.Z2D_Scroll();
        while (MitigationObj.Added_Part_Label_List.size()!=0){
            MitigationObj.Z2D_Click_on_Close_Button();}
        Wait_Element_Clickable(MitigationObj.View_Drop_Crosses_Button);
        MitigationObj.Z2D_Click_on_DropinCrosses();//hna intercepted
        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        Wait_Element_Visible(MitigationObj.Suggested_Part_Label);
        String Crosses_Part_Label = MitigationObj.Suggested_Part_Label.getText();
        MitigationObj.Z2D_Click_on_Add_Part_Button();
        String Added_part_Label = MitigationObj.Added_Part_Label.getText();
        Assert.assertEquals(Crosses_Part_Label,Added_part_Label);
        Wait_Element_Invisibility(DManagementObj.Toast_Container);
        MitigationObj.Z2D_Click_on_Close_Button();

        MitigationObj.Z2D_Click_on_View_Replacement_Button();
        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        Wait_Element_Visible(MitigationObj.Suggested_Part_Label);
        String Replacement_Part_Label = MitigationObj.Suggested_Part_Label.getText();
        MitigationObj.Z2D_Click_on_Add_Part_Button();
        String Added_part_Label2 = MitigationObj.Added_Part_Label.getText();
        Assert.assertEquals(Replacement_Part_Label,Added_part_Label2);
        MitigationObj.Z2D_Click_on_Close_Button();

//has been Commented because of Bug ***********************
       // String Active_Parts = MitigationObj.Active_Parts.getText();
      //  System.out.println("Active_Filter_Value : " + Active_Parts);
      //  MitigationObj.Z2D_Click_on_Active_Filter();
      //  Wait_Element_Invisibility(LandObj.SpinnerZezo);
      //  Wait_Text_To_Be(ForeCastObj.TotalValue,Active_Parts);
     //   String TotalFilterValue = ForeCastObj.TotalValue.getText();
        //System.out.println("Total Filter Value : " + TotalFilterValue);
    //    Assert.assertEquals(TotalFilterValue + " Parts",Active_Parts );
//has been Commented because of Bug ***********************

        String NRND_Parts = MitigationObj.NRND_Parts.getText();
        System.out.println("NRND_Filter_Value : " + NRND_Parts);
        Wait_Element_Clickable(MitigationObj.NRND_Parts);
        MitigationObj.Z2D_Click_on_NRND_Filter();
        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        Wait_Text_To_be(ForeCastObj.TotalValue,"226");
        String TotalFilterValue2 = ForeCastObj.TotalValue.getText();
        System.out.println("Total Filter Value : " + TotalFilterValue2);
        Assert.assertEquals(TotalFilterValue2 + " Parts",NRND_Parts);

        String End_of_Life_Parts = MitigationObj.End_Of_Life_Parts.getText();
        System.out.println("End_Of_Life_Parts : " + End_of_Life_Parts);
        Wait_Element_Clickable(MitigationObj.End_Of_Life_Parts);
        MitigationObj.Z2D_Click_on_EndofLife_Filter();
        Wait_for_Element_to_Disappear(ForeCastObj.Spinner);
        Wait_Text_To_be(ForeCastObj.TotalValue,"248");
        String TotalFilterValue3 = ForeCastObj.TotalValue.getText();
        System.out.println("Total Filter Value : " + TotalFilterValue3);
        Assert.assertEquals(TotalFilterValue3 + " Parts",End_of_Life_Parts);
 }
}
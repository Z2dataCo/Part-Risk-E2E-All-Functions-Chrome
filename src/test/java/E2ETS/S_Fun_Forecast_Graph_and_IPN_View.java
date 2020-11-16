package E2ETS;

import Com.PartRisk.Pages.Data_Management_Page;
import Com.PartRisk.Pages.Forecast_Page;
import Com.PartRisk.Pages.Landing_Page;
import Com.PartRisk.Pages.Obsolescence_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class S_Fun_Forecast_Graph_and_IPN_View extends Test_Base {
    Data_Management_Page DManagementObj;
    Landing_Page LandObj;
    Forecast_Page ForeCastObj;
    Obsolescence_Page ObsoL_Opj;

    @Test(priority = 19)
    @Severity(SeverityLevel.NORMAL)
    @Description("Validate Forecast tab Table IPN View Check table's data")

    public void ForeCast_Graph() throws InterruptedException {
        LandObj = new Landing_Page(driver);
        DManagementObj = new Data_Management_Page(driver);
        ForeCastObj = new Forecast_Page(driver);
        ObsoL_Opj = new Obsolescence_Page(driver);

        DManagementObj.Z2D_Move_To_Prod_BOM(driver);
        Wait_for_Element_to_Disappear(ForeCastObj.Spinner);
        ForeCastObj.Z2D_Click_on_Forecast_Tab();
        Wait_for_Element_to_Disappear(ForeCastObj.Spinner);
        ForeCastObj.Z2D_Select_Switcher();

        String Multi_Source_Filter_Value = ForeCastObj.First_Filter.getText();
        System.out.println("Multi_Source_Filter_Value : " + Multi_Source_Filter_Value);
        ForeCastObj.Z2D_Click_on_First_Filter();
        Wait_for_Element_to_Disappear(ForeCastObj.Spinner);
        String TotalFilterValue = ForeCastObj.TotalValue.getText();
        System.out.println("Total Filter Value : " + TotalFilterValue);
        Assert.assertEquals(TotalFilterValue, Multi_Source_Filter_Value);
        if (TotalFilterValue.equals("0")){
            System.out.println("No Data for the Selected Filter");
        }
        else {
            String First_Row_Name = ForeCastObj.First_Table_Data.getText();
            ForeCastObj.Z2D_Click_on_First_Result();
            String Opened_File_Name = ForeCastObj.File_Name.getText();
            Assert.assertTrue(Opened_File_Name.contains(First_Row_Name),"Opened File is the same as Selected");
        }


        String Single_Source_Filter_Value = ForeCastObj.Second_Filter.getText();
        System.out.println("Single_Source_Filter_Value : " + Single_Source_Filter_Value);
        ForeCastObj.Z2D_Click_on_Second_Filter();
        Wait_for_Element_to_Disappear(ForeCastObj.Spinner);
        String TotalFilterValue2 = ForeCastObj.TotalValue.getText();
        System.out.println("Total Filter Value : " + TotalFilterValue2);
        Assert.assertEquals(TotalFilterValue2, Single_Source_Filter_Value);
        if (TotalFilterValue2.equals("0")){
            System.out.println("No Data for the Selected Filter");
        }
        else {
            String First_Row_Name = ForeCastObj.First_Table_Data.getText();
            ForeCastObj.Z2D_Click_on_First_Result();
            String Opened_File_Name = ForeCastObj.File_Name.getText();
            Assert.assertTrue(Opened_File_Name.contains(First_Row_Name),"Opened File is the same as Selected");
        }

        String NA_Source_Filter_Value = ForeCastObj.Fifth_Filter.getText();
        System.out.println("NA_Source_Filter_Value : " + NA_Source_Filter_Value);
        ForeCastObj.Z2D_Click_on_Fifth_Filter();
        Wait_for_Element_to_Disappear(ForeCastObj.Spinner);
        String TotalFilterValue3 = ForeCastObj.TotalValue.getText();
        System.out.println("Total Filter Value : " + TotalFilterValue3);
        Assert.assertEquals(TotalFilterValue3, NA_Source_Filter_Value);
        if (TotalFilterValue3.equals("0")){
            System.out.println("No Data for the Selected Filter");
        }
        else {
            String First_Row_Name = ForeCastObj.First_Table_Data.getText();
            ForeCastObj.Z2D_Click_on_First_Result();
            String Opened_File_Name = ForeCastObj.File_Name.getText();
            System.out.println(Opened_File_Name);
            System.out.println(First_Row_Name);
            Assert.assertTrue(Opened_File_Name.contains(First_Row_Name),"Opened File is the same as Selected");
            Wait_Element_Visible(ObsoL_Opj.Close_Slide);
            ObsoL_Opj.Z2D_Close_Slide();
        }
    }
}

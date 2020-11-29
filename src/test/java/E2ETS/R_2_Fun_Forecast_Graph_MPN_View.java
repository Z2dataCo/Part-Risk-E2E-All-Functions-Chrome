package E2ETS;

import Com.PartRisk.Pages.Data_Management_Page;
import Com.PartRisk.Pages.Forecast_Page;
import Com.PartRisk.Pages.Landing_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;


public class R_2_Fun_Forecast_Graph_MPN_View extends Test_Base {
    Data_Management_Page DManagementObj;
    Landing_Page LandObj;
    Forecast_Page ForeCastObj;

    @Test(priority = 18)
    @Severity(value = SeverityLevel.NORMAL)
    @Description("Validate affecting Forecast Graph by filtering the Status & Check table's data ")
    public void Forecast_Graph_MPN_View() throws Exception {
        LandObj = new Landing_Page(driver);
        DManagementObj = new Data_Management_Page(driver);
        ForeCastObj = new Forecast_Page(driver);

        DManagementObj.Z2D_Move_To_Prod_BOM(driver);
        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        Wait_Element_Clickable(ForeCastObj.Graph2);
        ForeCastObj.Z2D_Click_on_Forecast_Tab();
        Wait_Element_Invisibility(LandObj.SpinnerZezo);

        String ActiveFilterValue = ForeCastObj.First_Filter.getText();
        //System.out.println("ActiveFilterValue" + ActiveFilterValue);
        ForeCastObj.Z2D_Click_on_First_Filter();
        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        Wait_Text_To_Be(ForeCastObj.First_Row_Text,"Active");
        ForeCastObj.Z2D_Get_Table_Data(driver, "Active");
        String TotalFilterValue = ForeCastObj.TotalValue.getText();
        //System.out.println("Total Filter Value : " + TotalFilterValue);
        Wait_Text_To_Be(ForeCastObj.TotalValue,ActiveFilterValue);
        Assert.assertEquals(TotalFilterValue, ActiveFilterValue);

        String EOLFilterValue = ForeCastObj.Second_Filter.getText();
        //System.out.println("EOLFilterValue" + EOLFilterValue);
        ForeCastObj.Z2D_Click_on_Second_Filter();
        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        Wait_Text_To_Be(ForeCastObj.First_Row_Text,"EOL");
        ForeCastObj.Z2D_Get_Table_Data(driver, "EOL");
        String TotalFilterValue2 = ForeCastObj.TotalValue.getText();
        //System.out.println("TotalFilterValue2 : " + TotalFilterValue2);
        Wait_Text_To_Be(ForeCastObj.TotalValue,EOLFilterValue);
        Assert.assertEquals(TotalFilterValue2, EOLFilterValue);

        String UnknownFilterValue = ForeCastObj.Third_Filter.getText();
        //System.out.println("UnknownFilterValue" + UnknownFilterValue);
        ForeCastObj.Z2D_Click_on_Third_Filter();
        Wait_Element_Invisibility(LandObj.SpinnerZezo);
        Wait_Text_To_Be(ForeCastObj.First_Row_Text,"Unknown");
        ForeCastObj.Z2D_Get_Table_Data(driver, "Unknown");
        String TotalFilterValue3 = ForeCastObj.TotalValue.getText();
        //System.out.println("TotalFilterValue3 : " + TotalFilterValue3);
        Wait_Text_To_Be(ForeCastObj.TotalValue,UnknownFilterValue);
        Assert.assertEquals(TotalFilterValue3, UnknownFilterValue);
    }
}

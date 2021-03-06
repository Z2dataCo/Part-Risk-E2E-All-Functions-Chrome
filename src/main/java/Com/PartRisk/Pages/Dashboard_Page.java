package Com.PartRisk.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard_Page extends Page_Base {
    @FindBy(xpath = "//*[@id=\"dashboard_content\"]/div/div/div[1]/div[2]/div[1]/app-dashboard-forecast/div/div[1]/div[1]/span")
    public WebElement H1_Life_forecast;
    @FindBy(xpath = "//*[@id=\"dashboard_content\"]/div/div/div[1]/div[2]/div[1]/app-dashboard-forecast/div/div[1]/div[2]/div/label/div")
    WebElement Switches_Dashboard;
    @FindBy(linkText = "Reports")
    WebElement Reports;
    @FindBy(xpath = "//*[@id=\"dashboard_content\"]/div/div/div[1]/app-dashboard-risk/div/div[1]/div[2]/div/a")
    public WebElement HighRisk;

    @FindBy(xpath = "//*[@id=\"dashboard_content\"]/div/div/div[2]/app-dashboard-bominfo/table[1]/tbody/tr[1]/td[2]/span")
    public WebElement IPNs_Count;





    public Dashboard_Page(WebDriver driver) {
        super(driver);
    }

    public void Z2D_Dashboard_Switches() {
        Click_Button(Switches_Dashboard);
    }

    public void Z2D_Open_Reports() {
        Click_Button(Reports);
    }

    public void Z2Data_HighRisk() {
        Click_Button(HighRisk);
    }


}
package Step_Definations;

import Pages.Store;
import Utilities.BrowserUtils;
import Utilities.ConfigurationReader;
import Utilities.Driver;
import Utilities.ReusableMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

import static Utilities.BrowserUtils.Assert;

public class StoreStepDefinitions {
    Store dashboardPage = new Store();
    Robot robot = new Robot();

    public StoreStepDefinitions() throws AWTException {
    }

    @Given("Kullanici URL e gider")
    public void kullanici_url_e_gider() {
        Driver.getDriver().get(ConfigurationReader.getProperty("URL"));
        ReusableMethods.waitFor(2);
    }
    @When("Kullanici arama kutusuna urun yazar ve arama yapar")
    public void kullanici_arama_kutusuna_urun_yazar() {
        ReusableMethods.clickWithJS(dashboardPage.aramaKutusu);
        ReusableMethods.waitFor(1);
        dashboardPage.aramaKutusu.sendKeys("ürün");
        ReusableMethods.waitFor(1);
        ReusableMethods.hover(dashboardPage.urun);
        ReusableMethods.waitFor(1);
        dashboardPage.urun.sendKeys(Keys.ENTER);
        ;

    }
    @Then("Kullanici bes urun ekler")
    public void kullanici_bes_urun_ekler() {
        ReusableMethods.waitFor(1);
        ReusableMethods.clickWithJS(dashboardPage.dropdown);
        Select select = new Select(dashboardPage.dropdown);
        select.selectByIndex(4);
        ReusableMethods.waitFor(1);
        ReusableMethods.clickWithJS(dashboardPage.sepeteEkle);
    }
    @Then("Kullanici sepetinize eklenmistir yazisini gorur")
    public void kullanici_sepetinize_eklenmistir_yazisini_gorur() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(dashboardPage.sepeteEklenmistir.isDisplayed());
    }
    @Then("Kullanici sepette bes urun oldugunu kontrol eder")
    public void kullanici_sepette_bes_urun_oldugunu_kontrol_eder() {
        ReusableMethods.waitFor(1);
        BrowserUtils.Assert.assertTrue(dashboardPage.urunSayisi.getText().contains("5"));
    }
    @Then("Uygulamayi kapat")
    public void uygulamayi_kapat() {
        ReusableMethods.waitFor(1);
        Driver.getDriver().close();
    }
}

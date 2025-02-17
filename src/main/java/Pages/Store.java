package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Store {
    public Store(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@name='q']")
    public WebElement aramaKutusu;

    @FindBy(xpath = "(//a[@title='Ürün'])[1]")
    public WebElement urun;

    @FindBy(xpath = "//select[@id='qty-input']")
    public WebElement dropdown;

    @FindBy(xpath = "//a[@class='add-to-cart-button']")
    public WebElement sepeteEkle;

    @FindBy(xpath = "//div[@class='shopping-information-cart-inside']")
    public WebElement sepeteEklenmistir;

    @FindBy (xpath = "(//input[@class='form-control'])[2]")
    public WebElement urunSayisi;
}

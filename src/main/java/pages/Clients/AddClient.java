package pages.Clients;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddClient {

    public AddClient(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//input[@id='client_name']")
    WebElement txtName;

    public void setTxtName(String name)
    {
        txtName.sendKeys(name);
    }
    @FindBy (xpath = "//input[@id='client_surname']")
    WebElement txtSurname;
    public void setTxtSurname(String surname)
    {
        txtSurname.sendKeys(surname);
    }
    @FindBy (xpath = "//input[@id='client_address_1']")
    WebElement txtAddress1;
    public void setTxtAddress1(String address1)
    {
        txtAddress1.sendKeys(address1);
    }
    @FindBy (xpath = "//input[@id='client_address_2']")
    WebElement txtAddress2;
    public void setTxtAddress2(String address2)
    {
        txtAddress2.sendKeys(address2);
    }
    @FindBy (xpath = "//input[@id='client_city']")
    WebElement txtCity;
    public void setTxtCity(String city)
    {
        txtCity.sendKeys(city);
    }
    @FindBy (xpath = "//input[@id='client_state']")
    WebElement txtState;
    public void setTxtState(String state)
    {
        txtState.sendKeys(state);
    }
    @FindBy (xpath = "//input[@id='client_zip']")
    WebElement txtZip;
    public void setTxtZip(String zip)
    {
        txtZip.sendKeys(zip);
    }
    @FindBy (xpath = "//input[@id='client_phone']")
    WebElement txtPhone;
    public void setTxtPhone(String phone)
    {
        txtPhone.sendKeys(phone);
    }
    @FindBy (xpath = "//input[@id='client_fax']")
    WebElement txtFax;
    public void setTxtFax(String fax)
    {
        txtFax.sendKeys(fax);
    }
    @FindBy (xpath = "//input[@id='client_mobile']")
    WebElement txtMobile;
    public void setTxtMobile(String mobile)
    {
        txtMobile.sendKeys(mobile);
    }
    @FindBy (xpath = "//input[@id='client_email']")
    WebElement txtEmail;
    public void setTxtEmail(String email)
    {
        txtEmail.sendKeys(email);
    }
    @FindBy (xpath = "//input[@id='client_web']")
    WebElement txtWeb;
    public void setTxtWeb(String web)
    {
        txtWeb.sendKeys(web);
    }
    @FindBy (xpath = "//input[@id='client_vat_id']")
    WebElement txtVat;
    public void setTxtVat(String vat)
    {
        txtVat.sendKeys(vat);
    }
    @FindBy (xpath = "//input[@id='client_tax_code']")
    WebElement txtTaxCode;
    public void setTaxCode(String taxCode)
    {
        txtTaxCode.sendKeys(taxCode);
    }
    @FindBy (xpath = "//button[@id='btn-submit']")
    WebElement btnSave;

    public void clickButtonSave()
    {
        btnSave.click();
    }
}

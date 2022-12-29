package regression.Clients;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Clients.AddClient;
import pages.Menu;
import util.DoLogin;

import java.io.IOException;

import static util.ForDataProvider.getMyData;

public class AddClientDataProviderTest extends DoLogin {

    @Test (dataProvider = "getData")
    public void addClientText(String name,String surname,String language,
                              String address1,String address2,String city,
                              String state,String zip,String country,String gender,
                              String birthdate,String phone,String fax,String mobile,
                              String email,String web,String vat,String tax,
                              String expected , String xpathActual )
    {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);

        addClient.setTxtName(name);
        addClient.setTxtSurname(surname);
        addClient.setLanguage(language);
        addClient.setTxtAddress1(address1);
        addClient.setTxtAddress2(address2);
        addClient.setTxtCity(city);
        addClient.setTxtState(state);
        addClient.setTxtZip(zip);
        addClient.setCountry(country);
        addClient.setGender(gender);
        addClient.setBirthDate(birthdate);
        addClient.setTxtPhone(phone);
        addClient.setTxtFax(fax);
        addClient.setTxtMobile(mobile);
        addClient.setTxtEmail(email);
        addClient.setTxtWeb(web);
        addClient.setTxtVat(vat);
        addClient.setTaxCode(tax);
        addClient.clickButtonSave();


        String actual = "";
        try {
            actual = driver.findElement(By.xpath(xpathActual)).getText();
        }
        catch (Exception e)
        {

        }

        System.out.println("actual="+actual);
        System.out.println("expected="+expected);
        Assert.assertEquals(actual,expected,"incorrect or no message");


    }

    @DataProvider
    public Object[][] getData() throws IOException {
        return  getMyData("Data/Invoiceplane.xlsx","Sheet1");
    }
}

package regression.Clients;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Clients.AddClient;
import pages.Login;
import pages.Menu;
import util.DoLogin;

import java.io.IOException;

import static util.ConfigReader.*;

public class AddClientTest extends DoLogin {

    @Test
    public void addClientText()
    {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);

        addClient.setTxtName("Priyanka");
        addClient.setTxtSurname("Rajput");
        addClient.setTxtAddress1("xyz");
        addClient.setTxtAddress2("abc");
        addClient.setTxtCity("pune");
        addClient.setTxtState("maharashtra");
        addClient.setTxtZip("414001");
        addClient.setTxtPhone("78787878");
        addClient.setTxtFax("31323232");
        addClient.setTxtMobile("985454555");
        addClient.setTxtEmail("a@b.com");
        addClient.setTxtWeb("www.priyanka.com");
        addClient.setTxtVat("5454545");
        addClient.setTaxCode("121212");
        addClient.clickButtonSave();



    }
}

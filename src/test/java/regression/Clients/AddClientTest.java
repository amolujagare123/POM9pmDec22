package regression.Clients;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import pages.Menu;

import java.io.IOException;

import static util.ConfigReader.*;

public class AddClientTest {
    WebDriver driver;
    @BeforeClass
    public void doLogin() throws IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(getUrl());

        Login login = new Login(driver);

        login.setTxtUsername(getUsername());
        login.setTxtPassword(getPassword());
        login.clickLogin();
    }

    @Test
    public void addClientText()
    {
        Menu menu = new Menu(driver);
        menu.clickAddClient();
    }
}

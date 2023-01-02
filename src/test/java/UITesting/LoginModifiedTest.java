package UITesting;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;

public class LoginModifiedTest extends Base{
    public Login login;

    @BeforeClass
    public void initLogin()
    {
        login = new Login(driver);

    }
    @Test
    public void txtPasswordVisibilityCheck()
    {
        boolean expected = true;
        boolean actual = availabilityCheck(login.txtPassword,"visibility");
        Assert.assertEquals(actual,expected,"");
    }

    @Test
    public void txtUsernameVisibilityCheck()
    {
        boolean expected = true;
        boolean actual = availabilityCheck(login.txtUsername,"visibility");
        Assert.assertEquals(actual,expected,"");
    }

    @Test
    public void txtUsernameEnabilityCheck()
    {
        boolean expected = true;
        boolean actual = availabilityCheck(login.txtUsername,"enability");
        Assert.assertEquals(actual,expected,"");
    }

    @Test
    public void lblEmailSpellCheck()
    {
        String expected = "Email";
        String actual = textCheck(login.lblEmail, "spellCheck");
        Assert.assertEquals(actual,expected,"");
    }

    @Test
    public void lblEmailFontSizeCheck()
    {
        String expected = "14px";
        String actual = textCheck(login.lblEmail, "font");
        Assert.assertEquals(actual,expected,"");
    }

    @Test
    public void lblEmailFontFamilyCheck()
    {
        String expected = "-apple-system, system-ui, BlinkMacSystemFont, \"Segoe UI\", Roboto, \"Helvetica Neue\", Arial, sans-serif";
        String actual = textCheck(login.lblEmail, "fontFamily");
        Assert.assertEquals(actual,expected,"");
    }

    @Test
    public void lblEmailColorCheck()
    {
        String expected = "#333333";
        String actual = textCheck(login.lblEmail, "color");
        Assert.assertEquals(actual,expected,"");
    }
}

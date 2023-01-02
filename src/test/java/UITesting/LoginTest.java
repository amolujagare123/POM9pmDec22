package UITesting;

import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import util.OpenUrl;

public class LoginTest extends OpenUrl {
    Login login;
    @BeforeClass
    public void initLogin()
    {
        login = new Login(driver);
    }
    @Test
    public void txtUsernameAvailabilityCheck()
    {
        boolean expected = true;
        boolean actual = false;
        try {
             actual = login.txtUsername.isDisplayed();
        }
        catch (Exception e)
        {

        }

        System.out.println("actual="+actual);
        System.out.println("expected="+expected);

        Assert.assertEquals(actual,expected,
                "username text box is absent");
    }

    @Test
    public void txtPasswordEnabilityCheck()
    {
        boolean expected = true;
        boolean actual = false;
        try {
            actual = login.txtPassword.isEnabled();
        }
        catch (Exception e)
        {

        }

        System.out.println("actual="+actual);
        System.out.println("expected="+expected);

        Assert.assertEquals(actual,expected,
                "username text box is disabled");
    }

    @Test
    public void txtUsernameWatermarkCheck()
    {
        String expected = "Email";
        String actual = "";
        try {
            actual = login.txtUsername.getAttribute("placeholder");
        }
        catch (Exception e)
        {

        }

        System.out.println("actual="+actual);
        System.out.println("expected="+expected);

        Assert.assertEquals(actual,expected,
                "incorrect watermark");
    }

    @Test
    public void txtPasswordWatermarkCheck()
    {
        String expected = "Password";
        String actual = "";
        try {
            actual = login.txtPassword.getAttribute("placeholder");
        }
        catch (Exception e)
        {

        }

        System.out.println("actual="+actual);
        System.out.println("expected="+expected);

        Assert.assertEquals(actual,expected,
                "incorrect watermark");
    }

    @Test
    public void lblPasswordSplellCheck()
    {
        String expected = "Password";
        String actual = "";

        try {
            actual = login.lblPassword.getText();
        }
        catch (Exception e)
        {

        }

        System.out.println("actual="+actual);
        System.out.println("expected="+expected);

        Assert.assertEquals(actual,expected,
                "incorrect spelling");
    }

    @Test
    public void lblPasswordFontSizeCheck()
    {
        String expected = "14px";
        String actual = "";

        try {
            actual = login.lblPassword.getCssValue("font-size");
        }
        catch (Exception e)
        {

        }

        System.out.println("actual="+actual);
        System.out.println("expected="+expected);

        Assert.assertEquals(actual,expected,
                "incorrect font size");
    }

    @Test
    public void lblPasswordFontFamilyCheck()
    {
        String expected = "-apple-system, system-ui, BlinkMacSystemFont, \"Segoe UI\", Roboto, \"Helvetica Neue\", Arial, sans-serif";
        String actual = "";

        try {
            actual = login.lblPassword.getCssValue("font-family");
        }
        catch (Exception e)
        {

        }

        System.out.println("actual="+actual);
        System.out.println("expected="+expected);

        Assert.assertEquals(actual,expected,
                "incorrect font family");
    }

    @Test
    public void lblPasswordFontCheck()
    {
       // String expected = "sans-serif";
        String expected = "times new roman";
        String actual = "";

        try {
            actual = login.lblPassword.getCssValue("font-family");
        }
        catch (Exception e)
        {

        }

        System.out.println("actual="+actual);
        System.out.println("expected="+expected);

        boolean result = actual.contains(expected);


        Assert.assertTrue(result,"given font is not there in the font family");


    }


    @Test
    public void btnLoginColorCheck()
    {
        String expected = "#2C8EDD";

        String actual = "";

        try {
            String rgbColor = login.btnLogin.getCssValue("background-color");
            actual = Color.fromString(rgbColor).asHex().toUpperCase();
        }
        catch (Exception e)
        {

        }

        System.out.println("actual="+actual);
        System.out.println("expected="+expected);

        Assert.assertEquals(actual,expected,
                "incorrect color");
    }
}

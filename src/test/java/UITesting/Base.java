package UITesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import util.OpenUrl;

public class Base extends OpenUrl {


    public boolean availabilityCheck(WebElement element,String testType)
    {
        boolean actual = false;
        try {

            switch (testType) {
                case "visibility" : actual = element.isDisplayed();
                    break;
                case "enability" : actual = element.isEnabled();
                    break;
            }
        }
        catch (Exception e)
        {

        }
        return actual;
    }

    String getHexColor(WebElement element,String colorType)
    {
        String rgbColor = element.getCssValue(colorType);
        return Color.fromString(rgbColor).asHex().toUpperCase();
    }

    public String textCheck(WebElement element,String testType)
    {
        String actual = "";
        try {

            switch (testType) {
                case "spellCheck" : actual = element.getText();
                    break;
                case "watermark" : actual = element.getAttribute("placeholder");
                    break;
                case "font" : actual = element.getCssValue("font-size");
                    break;
                case "fontFamily" : actual = element.getCssValue("font-family");
                    break;
                case "background-color" : actual =getHexColor(element,testType);
                    break;
                case "border-color" : actual =getHexColor(element,testType);
                    break;
                case "color" : actual =getHexColor(element,testType);
                    break;

            }
        }
        catch (Exception e)
        {

        }
        return actual;
    }

}

package DatabaseTesting;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Clients.AddClient;
import pages.Menu;
import util.DoLogin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import static util.Conversion.*;
import static util.ForDataProvider.getMyData;

public class AddClientDataProviderTest extends DoLogin {

    @Test (dataProvider = "getData")
    public void addClientText(String name,String surname,String language,
                              String address1,String address2,String city,
                              String state,String zip,String country,String gender,
                              String birthdate,String phone,String fax,String mobile,
                              String email,String web,String vat,String tax) throws ClassNotFoundException, SQLException, ParseException {
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

        ArrayList<String> expected = new ArrayList<>();
        expected.add(name);
        expected.add(surname);
        expected.add(language.toLowerCase());
        expected.add(address1);
        expected.add(address2);
        expected.add(city);
        expected.add(state);
        expected.add(zip);
        expected.add(country);
        expected.add(gender);
        expected.add(birthdate);
        expected.add(phone);
        expected.add(fax);
        expected.add(mobile);
        expected.add(email);
        expected.add(web);
        expected.add(vat);
        expected.add(tax);



        Class.forName("com.mysql.cj.jdbc.Driver");

        String username = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/ip";

        Connection con = DriverManager.getConnection(url,username,password);
        Statement st = con.createStatement();

        String sql = "SELECT * FROM ip_clients where client_name='"+name+"'";

        ResultSet rs = st.executeQuery(sql);

        ArrayList<String> actual = new ArrayList<>();

        while (rs.next())
        {
            actual.add(rs.getString("client_name"));
            actual.add(rs.getString("client_surname"));
            actual.add(rs.getString("client_language"));
            actual.add(rs.getString("client_address_1"));
            actual.add(rs.getString("client_address_2"));
            actual.add(rs.getString("client_city"));
            actual.add(rs.getString("client_state"));
            actual.add(rs.getString("client_zip"));

            String shortCountry = rs.getString("client_country");
            String convertedCountry = convertCountry(shortCountry); // full form

            actual.add(convertedCountry);

            actual.add(getGender(rs.getString("client_gender")));

            actual.add(convertDate(rs.getString("client_birthdate")));
            actual.add(rs.getString("client_phone"));
            actual.add(rs.getString("client_fax"));
            actual.add(rs.getString("client_mobile"));
            actual.add(rs.getString("client_email"));
            actual.add(rs.getString("client_web"));
            actual.add(rs.getString("client_vat_id"));
            actual.add(rs.getString("client_tax_code"));

        }


        System.out.println("actual="+actual);
        System.out.println("expected="+expected);
        Assert.assertEquals(actual,expected,"different record sets");


    }

    @DataProvider
    public Object[][] getData() throws IOException {
        return  getMyData("Data/Invoiceplane.xlsx","database testing");
    }
}

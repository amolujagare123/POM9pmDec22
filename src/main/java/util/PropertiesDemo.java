package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {

    public static void main(String[] args) throws IOException {

        // 1. read the file
        FileInputStream fis = new FileInputStream("Config/config.properties");

        // 2. create the object of properties class
        Properties prop = new Properties();

        // 3. load the properties object with file object
        prop.load(fis);

        // 4. read the values of keys using prop object
        System.out.println(prop.getProperty("url"));
        System.out.println(prop.getProperty("username"));
        System.out.println(prop.getProperty("password"));

    }
}

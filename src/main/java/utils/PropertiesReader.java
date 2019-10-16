package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class PropertiesReader {
    private Properties prop = new Properties();

    PropertiesReader() {
        String environment = System.getProperty("env");
        String propertiesFilePath = environment + ".properties";
        InputStream inputStream;
        inputStream = getInputStream(propertiesFilePath);

        try {
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private InputStream getInputStream(String propertiesFilePath) {
        return this.getClass().getClassLoader().getResourceAsStream(propertiesFilePath);
    }

    String getBaseUrl() {
        return prop.getProperty("baseUrl");
    }


    String getBrowserStackUsername() {
        return prop.getProperty("browserStackUsername");
    }

    String getBrowserStackKey() {
        return prop.getProperty("browserStackKey");
    }

    String getValidUserName() {
        return prop.getProperty("validUserName");
    }

    String getValidPassword() {
        return prop.getProperty("validPassword");
    }


    String getInvalidUserName() {
        return prop.getProperty("invalidUserName");
    }

    String getInvalidPassword() {
        return prop.getProperty("invalidPassword");
    }


    String getPhoneNoMoreThanTenDigits() {
        return prop.getProperty("phoneNoMoreThanDigits");
    }

    String getPhoneNoLessThanTenDigits() {
        return prop.getProperty("phoneNoLessThan10Digits");
    }

    String getInvalidEmailId() {
        return prop.getProperty("invalidEmailId");
    }

    String getInvalidConfirmPassword() {
        return prop.getProperty("invalidConfirmPassword");
    }

    String getUnregisteredEmailId() {
        return prop.getProperty("unregisteredEmailId");
    }

    String getUnregisteredMobileNo() {
        return prop.getProperty("unregisteredMobileNo");
    }


}

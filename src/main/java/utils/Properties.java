package utils;

public class Properties {

    private static final PropertiesReader propertiesReader = new PropertiesReader();
    public static final String baseUrl = propertiesReader.getBaseUrl();


    public static final String BROWSER_STACK_USERNAME = propertiesReader.getBrowserStackUsername();
    public static final String BROWSER_STACK_KEY = propertiesReader.getBrowserStackKey();
    public static final String invalidUserName = propertiesReader.getInvalidUserName();
    public static final String invalidPassword = propertiesReader.getInvalidPassword();
    public static final String validUserName = propertiesReader.getValidUserName();
    public static final String validPassword = propertiesReader.getValidPassword();
    public static String invalidEmailId = propertiesReader.getInvalidEmailId();
    public static String invalidConfirmPassword = propertiesReader.getInvalidConfirmPassword();
    public static String phoneNoMoreThanTenDigits = propertiesReader.getPhoneNoMoreThanTenDigits();
    public static String phoneNoLessThanTenDigits = propertiesReader.getPhoneNoLessThanTenDigits();
    public static String unregisteredEmailId = propertiesReader.getUnregisteredEmailId();
    public static String unregisteredMobileNo = propertiesReader.getUnregisteredMobileNo();


}

package amazon.site.tests;

import amazon.site.uaxiliary.EncryptDecryptStringWithDES;
import com.codeborne.selenide.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    private Properties property;
    private String baseUrl;
    private String userEmail;
    private String userLogin;
    private String userPassword;
    private FileInputStream fis;
    private EncryptDecryptStringWithDES edsDES;

    public TestBase(){
        property = new Properties();

        try {
            fis = new FileInputStream("src/test/resources/config.properties");
            property.load(fis);
            baseUrl = property.getProperty("web.baseUrl");
            edsDES = new EncryptDecryptStringWithDES(property.getProperty("secret.key"));
            userEmail = edsDES.decrypt(property.getProperty("secret.email"));
            userLogin = edsDES.decrypt(property.getProperty("secret.login"));
            userPassword = edsDES.decrypt(property.getProperty("secret.password"));
        } catch (IOException e) {
            System.err.println("ERROR: Property file is absent!");
        }
    }

    public String getBaseUrl(){
        return baseUrl;
    }

    public String getUserEmail(){
        return userEmail;
    }

    public String getUserLogin(){
        return userLogin;
    }

    public String getUserPassword(){
        return userPassword;
    }

}

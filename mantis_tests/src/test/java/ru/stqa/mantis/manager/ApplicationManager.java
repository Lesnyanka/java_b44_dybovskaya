package ru.stqa.mantis.manager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class ApplicationManager {
    private WebDriver driver;
    private Properties properties;
    private String string;

    private SessionHelper sessionHelper;
    private HttpSessionHelper httpSessionHelper;
    private JamesCliHelper jamesCliHelper;
    private MailHelper mailHelper;
    private BrowserHelper browserHelper;


    public void init(String browser, Properties properties) {
        this.string = browser;
        this.properties = properties;
    }

    public  WebDriver driver(){
        if(driver == null){
            if ("chrome".equals(string)){
                driver = new ChromeDriver();
            } else if ("firefox".equals(string)){
                driver = new FirefoxDriver();
            } else {
                throw new IllegalArgumentException(String.format("Unknown browser %s",string));
            }
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get(properties.getProperty("web.baseUrl"));
            driver.manage().window().setSize(new Dimension(1280, 680));
        }
            return driver;
        }

        public SessionHelper session(){
        if(sessionHelper == null){
            sessionHelper = new SessionHelper(this);
        }
        return sessionHelper;
        }

    public BrowserHelper browser(){
        if(browserHelper == null){
            browserHelper = new BrowserHelper(this);
        }
        return browserHelper;
    }

    public HttpSessionHelper http() {
        if(httpSessionHelper == null){
            httpSessionHelper = new HttpSessionHelper(this);
        }
        return httpSessionHelper;
    }

    public JamesCliHelper jamesCli() {
        if(jamesCliHelper == null){
            jamesCliHelper = new JamesCliHelper(this);
        }
        return jamesCliHelper;
    }

    public String property(String name){
        return properties.getProperty(name);
    }

    public MailHelper mail() {
        if(mailHelper == null){
            mailHelper = new MailHelper(this);
        }
        return mailHelper;
    }
}

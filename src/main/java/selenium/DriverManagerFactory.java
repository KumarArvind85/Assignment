package selenium;

public class DriverManagerFactory {
    public static DriverManager getDriverManager(DriverType type){
        DriverManager driverManager=null;
        switch(type){
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            //implement for other browsers
            default:
        }
        return driverManager;
    }
}

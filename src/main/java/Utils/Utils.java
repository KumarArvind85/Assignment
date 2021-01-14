package Utils;

public class Utils {

    public static String getProperty(String propertyName){
        String propertyValue = null;
        if(propertyName != null){
            propertyValue = System.getenv(propertyName);
            return propertyValue;
        }else{
            throw new IllegalArgumentException("email is not valid");
        }
    }
}

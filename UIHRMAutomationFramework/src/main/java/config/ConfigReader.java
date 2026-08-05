package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import constants.PathConstants;

public class ConfigReader
{
    private static Properties properties;

    static
    {
    	try {

            FileInputStream fis = new FileInputStream(PathConstants.CONFIG_PROPERTIES_PATH);

            properties = new Properties();

            properties.load(fis);

            fis.close();

        }
        catch (IOException e) {

            throw new RuntimeException("Unable to load config.properties", e);

        }    	
    	
    }
    
    public static String getProperty(String key) {

	    return properties.getProperty(key);

	}

	

}
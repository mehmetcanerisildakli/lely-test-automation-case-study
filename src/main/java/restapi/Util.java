package restapi;

import java.io.File;

public class Util {

    static BaseConfiguration baseConfiguration = new BaseConfiguration();

    public static String getProperty(String property, boolean addEnv) {

        if (addEnv)
            return baseConfiguration.getProperty(Util.getEnvironment() + "-" + property);
        else
            return baseConfiguration.getProperty(property);
    }

    public static String getEnvironment() {

        if (System.getProperty("env") != null)
            return System.getProperty("env");
        else
            return baseConfiguration.getProperty("env");
    }

    public static String getURL() {

        if (System.getProperty("URL") != null)
            return System.getProperty("URL");
        else
            return Util.getProperty("URL", true);
    }

    public static String getToken() {

        if (System.getProperty("TOKEN") != null)
            return System.getProperty("TOKEN");
        else
            return Util.getProperty("TOKEN", true);
    }

    public static String getFilePath(String filePath) {

        String OS = System.getProperty("os.name");
        String result;

        if (OS.startsWith("Windows"))
            result = filePath;
        else
            result = filePath.replace("\\", File.separator);

        return result;
    }
}

package gui;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GuiResources {

    private static final String RESOURCES = "src/main/resources/ContactResources_en_US.properties";
    private static final Properties CONFIG_RES = new Properties();

    public static void initComponentResources() throws IOException {
        initComponentResources(null);
    }

    public static void initComponentResources(String name) throws IOException {
        if (name != null && !name.trim().isEmpty()) {
            CONFIG_RES.load(new FileReader(name));
        } else {
            CONFIG_RES.load(new FileReader(RESOURCES));
        }
    }

    public static String getProperty(String property) {
        return CONFIG_RES.getProperty(property);
    }

    /*private static PropertyResourceBundle components = null;

    public static void initComponentResources() {
        String lang = GlobalConfig.getProperty(LANGUAGE);
        if (lang != null && !lang.trim().isEmpty()) {
            components = (PropertyResourceBundle) PropertyResourceBundle.getBundle(RESOURCES, new Locale(lang));
        } else {
            components = (PropertyResourceBundle) PropertyResourceBundle.getBundle(RESOURCES);
        }
    }

    public static String getLabel(String formId, String componentId) {
        return components.getString(formId + "." + componentId);
    }*/

}

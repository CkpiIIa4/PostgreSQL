package gui;

import config.GlobalConfig;

import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class GuiResources {

    private static final String RESOURCES = "src/main/resources/ContactResources";
    private static final String LANGUAGE = "language";

    private static PropertyResourceBundle components;

    public static void initComponentResources() {
        String lang = GlobalConfig.getProperty(LANGUAGE);
        ResourceBundle bundle = ResourceBundle.getBundle("ContactResources", new Locale(lang));
        if (lang != null && !lang.trim().isEmpty()) {
            components = (PropertyResourceBundle) bundle;
        } else
            components = (PropertyResourceBundle) PropertyResourceBundle.getBundle(RESOURCES);
    }

    public static String getLabel(String formId, String componentId) {
        return components.getString(formId + "." + componentId);
    }

}

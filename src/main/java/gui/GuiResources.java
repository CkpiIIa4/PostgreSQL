package gui;

import config.GlobalConfig;

import java.util.Locale;
import java.util.PropertyResourceBundle;

public class GuiResources {

    private static final String RESOURCES = "ContactResources";
    private static final String LANGUAGE = "language";

    private static PropertyResourceBundle components;

    public static void initComponentResources() {
        String lang = GlobalConfig.getProperty(LANGUAGE);
        if (lang != null && !lang.trim().isEmpty()) {
            components = (PropertyResourceBundle) PropertyResourceBundle.getBundle(RESOURCES);
        } else {
            components = (PropertyResourceBundle) PropertyResourceBundle.getBundle(RESOURCES);
        }
    }

    public static String getLabel(String formId, String componentId) {
        return components.getString(formId + "." + componentId);
    }

}

package com.kitchen.reliablekitchen.utilities;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private Properties properties;

    public PropertiesReader() {
        this.properties = new Properties();
    }

    public Properties getProperties(String propertiesFilePath) {
        try {
            InputStream fileInput = new FileInputStream(propertiesFilePath);
            this.properties.load(fileInput);
            fileInput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.properties;
    }
}

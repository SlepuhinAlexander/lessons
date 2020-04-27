package ru.ifmo.base.lesson17.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    private static PropertiesLoader propertiesLoader;
    public static PropertiesLoader getPropertiesLoader(String propFileName){
        if (propertiesLoader == null) {
            propertiesLoader = new PropertiesLoader(propFileName);
        }
        return propertiesLoader;
    }

    private Properties properties;
    private String propFileName;

    // возможно создание объекта только внутри класса
    private PropertiesLoader(String propFileName){
        this.properties = new Properties();
        this.propFileName = propFileName;
        loadProperties();
    }

    public Properties getProperties(){
        return properties;
    }

    private void loadProperties(){
        // загрузка данных из properties файла
        try (InputStream input = PropertiesLoader.class
                .getClassLoader()
                .getResourceAsStream(propFileName)){
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

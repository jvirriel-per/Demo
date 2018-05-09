package com.jvirriel.property;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Objects.nonNull;

/**
 * PropertyUtil.java
 * <p>
 */
public class PropertyUtil {
    private static final String CONFIG_PROPERTIES = "config.properties";

    private static PropertiesConfiguration appProperties;
    private static ObjectMapper mapper = new ObjectMapper();
    private static LinkedHashMap<String, Object> properties;

    static {
        loadProperties(CONFIG_PROPERTIES);
    }

    private static void loadProperties() {
        loadProperties(CONFIG_PROPERTIES);
    }

    private static void loadProperties(String propertyFileName) {
        String newDir;
        try {
            appProperties = new PropertiesConfiguration(propertyFileName);
            newDir = appProperties.getString("consul.resource");
//            properties = loadRemotePropertiesYaml(newDir);
            appProperties = new PropertiesConfiguration(new URL(newDir));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static LinkedHashMap<String, Object> loadRemoteProperties(URL propertyUrl) {
        LinkedHashMap<String, Object> properties = null;
        try {
            properties = mapper.readValue(propertyUrl, new TypeReference<LinkedHashMap<String, Object>>(){});
            ArrayList<Map> list = (ArrayList<Map>) properties.get("propertySources");
            properties = (LinkedHashMap<String, Object>) list.get(0).get("source");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

//    private static LinkedHashMap<String, Object> loadRemotePropertiesYaml(String propertyUrl) {
//        LinkedHashMap<String, Object> properties = null;
//        try {
//            RestTemplate restTemplate = new RestTemplate();
//            String response = restTemplate.getForObject(propertyUrl, String.class);
//            Yaml yml = new Yaml();
//            properties = yml.load(response);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return properties;
//    }

    private static PropertiesConfiguration loadLocalProperties(String propertyFileName) {
        PropertiesConfiguration appProperties = null;
        try {
            appProperties = new PropertiesConfiguration(propertyFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return appProperties;
    }

    public static String getProperty(String property) {
        if (!nonNull(appProperties))
            loadProperties();

        if (nonNull(appProperties)) {
            return appProperties.getString(property);
//            return getPropertyRecursively(property);
        }
        return null;
    }

    public static String getProperty(String propertiesFileName, String property) {
        PropertiesConfiguration appProperties = loadLocalProperties(propertiesFileName);

        if (nonNull(appProperties)) {
            return appProperties.getString(property);
        }
        return null;
    }

    public static String getProperty(URL propertiesUrl, String property) {
        LinkedHashMap<String, Object> properties = loadRemoteProperties(propertiesUrl);

        if (nonNull(properties)) {
            return (String)properties.get(property);
        }

        return null;
    }

//    public static String getPropertyRecursively(String property) {
//        ArrayList<String> levels = Lists.newArrayList(property.split("\\."));
//        Map<String, Object> map = properties;
//        Object aux = new Object();
//        for (String level : levels) {
//            if (map.containsKey(level)) {
//                aux = map.get(level);
//                if (aux instanceof LinkedHashMap) {
//                    map = (Map<String, Object>) aux;
//                }
//            } else
//                return null;
//        }
//        if (aux instanceof String)
//            return (String) aux;
//        return null;
//    }
}

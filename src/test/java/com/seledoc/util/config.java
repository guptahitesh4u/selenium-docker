package com.seledoc.util;

import io.opentelemetry.sdk.resources.Resource;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

public class config {
    private static final Logger log = LoggerFactory.getLogger(config.class);
    private static final String DEFAULT_PROPERTIES="config/default.properties";
    private static Properties properties;

    public static void initialize(){
        log.info("config.initialize method (under config.java file. cAlled from BEforeSuite Method");
        properties=loadProperties();
        for(String key:properties.stringPropertyNames()){
            if(System.getProperties().containsKey(key)){
                properties.setProperty(key,System.getProperty(key));
            }
        }

        log.info("Test Properties");
        for(String key: properties.stringPropertyNames()){
            log.info("{} = {}" , key, properties.getProperty(key));
        }
    }

    public static String get(String key){
        return properties.getProperty(key);
    }
    private static Properties loadProperties(){
        System.out.println("Inside Load Proprties method under config.java , still part of before suite");
        Properties properties= new Properties();
        try(InputStream stream=ResourceLoader.getResource(DEFAULT_PROPERTIES)){
            properties.load(stream);
        }catch(Exception e){
            log.error("unable to read the property file {}",DEFAULT_PROPERTIES, e);
        }
        return properties;

    }
}

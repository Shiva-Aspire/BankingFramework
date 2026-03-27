package com.bank.Utility;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class BaseLogger {

    private final Logger logger;

    public static BaseLogger getLogger(Class<?> clazz){
        return new BaseLogger(clazz);
    }
    public static BaseLogger getLogger(String className){
        return new BaseLogger(className);
    }

    public BaseLogger(Class<?> clazz){
        this.logger= LoggerFactory.getLogger(clazz);
    }

    public BaseLogger(String className){
        this.logger=LoggerFactory.getLogger(className);
    }

    public void debug(String message){
        this.logger.debug(message);
    }
    public void error(String message){
        this.logger.error(message);
    }
    public void fatal(String message){
        this.logger.error(message);
    }
    public void info(String message){
        this.logger.info(message);
    }
    public boolean isDebugEnabled(){
       return this.logger.isDebugEnabled();
    }
    public void warn(String message){
        this.logger.warn(message);
    }
}

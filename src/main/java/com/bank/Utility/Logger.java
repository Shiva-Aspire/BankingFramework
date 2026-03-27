package com.bank.Utility;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;


public class Logger {
    private static boolean logScreenShotsAfterPageLoad;
    private static ReentrantLock lock = new ReentrantLock();
    private static boolean reporterNotFound =false;
    private BaseLogger baseLogger;
    private String cachedTag;
    private boolean logToLogFile;
    private boolean logToReports;
//    private final ArrayList<String> tags;
    private static boolean logScreenshotAfterClick;

    public static boolean isLogScreenShotsAfterPageLoad(){
        return logScreenShotsAfterPageLoad;
    }

    public static boolean isLogScreenshotAfterClick(){
        return logScreenshotAfterClick;
    }

    public static Logger getLogger(){return getLogger(getCallerName());}

    private static String getCallerName(){
        return (new Exception()).getStackTrace()[2].getClassName();}

    public static Logger getLogger(Class<?> clazz){
        return getLogger(clazz.getName());
    }
//    public static Logger getLogger(Class<?> clazz, boolean enableLoggingToFile, boolean enableHtmlReportLogging){
//        return getLogger(clazz.getName(), enableLoggingToFile, enableHtmlReportLogging);
//    }
    public static Logger getLogger(String name){
        return new Logger(name);
    }

//    public static getLogger(String name, boolean enableLoggingToFile, boolean enableHtmlReportLogging){
//        Logger logger=new Logger(name);
//        return logger;
//    }

    public Logger(String name){
        this.baseLogger=BaseLogger.getLogger(name);
    }
    public void debug(String message){
        baseLogger.debug(message);
    }

    public void info(String message){
        baseLogger.debug(message);
    }
    public void error(String message){
        baseLogger.debug(message);
    }
    public void warn(String message){
        baseLogger.debug(message);
    }



}

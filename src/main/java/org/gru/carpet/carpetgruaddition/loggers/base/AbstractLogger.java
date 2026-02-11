package org.gru.carpet.carpetgruaddition.loggers.base;

import carpet.logging.Logger;
import carpet.logging.LoggerRegistry;

/**
 * 抽象日志记录器基类，提供通用的日志记录器功能
 */
public abstract class AbstractLogger {
    /**
     * 获取日志记录器名称
     * @return 日志记录器名称
     */
    public abstract String getLoggerName();
    
    /**
     * 获取默认选项
     * @return 默认选项
     */
    public abstract String getDefaultOption();
    
    /**
     * 获取支持的选项
     * @return 支持的选项数组
     */
    public abstract String[] getSupportedOptions();
    
    /**
     * 获取日志记录器字段
     * @return 日志记录器字段
     */
    public abstract java.lang.reflect.Field getLoggerField();
    
    /**
     * 注册日志记录器
     */
    public void register() {
        try {
            java.lang.reflect.Field field = getLoggerField();
            Logger logger = new Logger(field, getLoggerName(), getDefaultOption(), getSupportedOptions());
            LoggerRegistry.registerLogger(getLoggerName(), logger);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 检查日志记录器是否有在线订阅者
     * @return 如果有在线订阅者，返回 true；否则，返回 false
     */
    public boolean hasOnlineSubscribers() {
        try {
            java.lang.reflect.Field field = getLoggerField();
            boolean isEnabled = field.getBoolean(null);
            return isEnabled && LoggerRegistry.getLogger(getLoggerName()) != null && LoggerRegistry.getLogger(getLoggerName()).hasOnlineSubscribers();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    

}
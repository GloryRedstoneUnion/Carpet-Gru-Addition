package org.gru.carpet.carpetgruaddition.loggers;

import org.gru.carpet.carpetgruaddition.loggers.base.AbstractLogger;

/**
 * 烟花火箭轨迹日志记录器
 */
public class FireworkRocketLogger extends AbstractLogger {
    // 日志记录器名称
    public static final String LOGGER_NAME = "fireworkRocket";
    // 默认选项
    public static final String DEFAULT_OPTION = "brief";
    // 支持的选项
    public static final String[] SUPPORTED_OPTIONS = {"brief", "full"};
    // 日志记录器字段
    public static boolean __fireworkRocket;
    
    // 单例实例
    public static final FireworkRocketLogger INSTANCE = new FireworkRocketLogger();
    
    /**
     * 获取日志记录器名称
     * @return 日志记录器名称
     */
    @Override
    public String getLoggerName() {
        return LOGGER_NAME;
    }
    
    /**
     * 获取默认选项
     * @return 默认选项
     */
    @Override
    public String getDefaultOption() {
        return DEFAULT_OPTION;
    }
    
    /**
     * 获取支持的选项
     * @return 支持的选项数组
     */
    @Override
    public String[] getSupportedOptions() {
        return SUPPORTED_OPTIONS;
    }
    
    /**
     * 获取日志记录器字段
     * @return 日志记录器字段
     */
    @Override
    public java.lang.reflect.Field getLoggerField() {
        try {
            return FireworkRocketLogger.class.getField("__fireworkRocket");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException("Failed to get logger field \"__fireworkRocket\" @ FireworkRocketLogger");
        }
    }
    
    // 静态方法，供外部调用
    public static void staticRegister() {
        INSTANCE.register();
    }
    
    // 静态方法，供外部调用
    public static boolean staticHasOnlineSubscribers() {
        return INSTANCE.hasOnlineSubscribers();
    }
}
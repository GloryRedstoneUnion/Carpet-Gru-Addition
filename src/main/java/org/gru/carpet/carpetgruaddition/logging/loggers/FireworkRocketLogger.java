package org.gru.carpet.carpetgruaddition.logging.loggers;

import org.gru.carpet.carpetgruaddition.logging.GruAdditionLoggerRegistry;
import carpet.logging.Logger;

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
    
    // 单例实例
    public static final FireworkRocketLogger INSTANCE = new FireworkRocketLogger();

    public FireworkRocketLogger() {
        super(LOGGER_NAME, false);
    }
    
    /**
     * 获取默认选项
     * @return 默认选项
     */
    @Override
    public String getDefaultLoggingOption() {
        return DEFAULT_OPTION;
    }
    
    /**
     * 获取支持的选项
     * @return 支持的选项数组
     */
    @Override
    public String[] getSuggestedLoggingOption() {
        return SUPPORTED_OPTIONS;
    }
    
    // 静态方法，供外部调用
    public static void staticRegister() {
        GruAdditionLoggerRegistry.register(INSTANCE);
    }
    
    // 静态方法，供外部调用
    public static boolean staticHasOnlineSubscribers() {
        return INSTANCE.hasOnlineSubscribers();
    }
    
    // 检查是否有在线订阅者
    public boolean hasOnlineSubscribers() {
        try {
            java.lang.reflect.Field field = GruAdditionLoggerRegistry.getLoggerField(LOGGER_NAME);
            boolean isEnabled = field.getBoolean(null);
            return isEnabled;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
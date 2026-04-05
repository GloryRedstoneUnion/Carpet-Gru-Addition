package org.gru.carpet.carpetgruaddition.logging.loggers;

import org.gru.carpet.carpetgruaddition.logging.GruAdditionLoggerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.entity.Entity;

import java.lang.reflect.Field;

/**
 * 实体ID日志记录器，用于显示服务器的CURRENT_ID数值
 */
public class EntityIdLogger extends AbstractHUDLogger {
    // 日志记录器名称
    public static final String LOGGER_NAME = "entityid";
    
    // 单例实例
    public static final EntityIdLogger INSTANCE = new EntityIdLogger();

    public EntityIdLogger() {
        super(LOGGER_NAME, false);
    }

    @Override
    public Text[] onHudUpdate(String option, PlayerEntity playerEntity) {
        try {
            // 使用反射获取Entity类中的CURRENT_ID字段
            Field currentIdField = Entity.class.getDeclaredField("CURRENT_ID");
            currentIdField.setAccessible(true);
            int currentId = ((java.util.concurrent.atomic.AtomicInteger) currentIdField.get(null)).get();
            
            // 创建显示文本
            Text line1 = Text.translatable("carpetgruaddition.logger.entityid.title");
            Text line2 = Text.translatable("carpetgruaddition.logger.entityid.value", currentId);
            
            // 如果有刷新时间选项，显示刷新时间
            if (option != null && !option.isEmpty()) {
                try {
                    int refreshTime = Integer.parseInt(option);
                    Text line3 = Text.translatable("carpetgruaddition.logger.entityid.refresh", refreshTime);
                    return new Text[]{line1, line2, line3};
                } catch (NumberFormatException e) {
                    // 忽略无效的刷新时间选项
                }
            }
            
            return new Text[]{line1, line2};
        } catch (Exception e) {
            e.printStackTrace();
            Text error = Text.translatable("carpetgruaddition.logger.entityid.error");
            return new Text[]{error};
        }
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
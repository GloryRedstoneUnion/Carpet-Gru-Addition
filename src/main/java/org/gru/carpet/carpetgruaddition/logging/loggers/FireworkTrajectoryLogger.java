package org.gru.carpet.carpetgruaddition.logging.loggers;

import carpet.logging.logHelpers.TrajectoryLogHelper;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.World;

/**
 * 烟花火箭轨迹记录器
 */
public class FireworkTrajectoryLogger {
    // 轨迹记录器
    private TrajectoryLogHelper logHelper;
    
    /**
     * 初始化轨迹记录器
     * @param world 世界对象
     */
    public void initialize(World world) {
        // 检查是否有在线订阅者
        if (FireworkRocketLogger.staticHasOnlineSubscribers()) {
            // 创建轨迹记录器
            logHelper = new TrajectoryLogHelper(FireworkRocketLogger.LOGGER_NAME);
        }
    }
    
    /**
     * 记录烟花火箭的位置和速度
     * @param entity 烟花火箭实体
     */
    public void recordTick(FireworkRocketEntity entity) {
        // 检查轨迹记录器是否初始化，并且是否有在线订阅者
        if (logHelper != null && FireworkRocketLogger.staticHasOnlineSubscribers()) {
            // 记录位置和速度
            logHelper.onTick(
                entity.getX(),
                entity.getY(),
                entity.getZ(),
                entity.getVelocity()
            );
        }
    }
    
    /**
     * 结束轨迹记录
     */
    public void finish() {
        // 检查轨迹记录器是否初始化
        if (logHelper != null) {
            // 结束轨迹记录
            logHelper.onFinish();
            // 清空轨迹记录器
            logHelper = null;
        }
    }
}
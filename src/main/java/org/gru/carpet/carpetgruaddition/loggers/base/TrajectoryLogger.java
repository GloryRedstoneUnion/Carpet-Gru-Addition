package org.gru.carpet.carpetgruaddition.loggers.base;

import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.World;

/**
 * 轨迹记录器接口，定义轨迹记录的基本方法
 */
public interface TrajectoryLogger {
    /**
     * 初始化轨迹记录器
     * @param world 世界对象
     */
    void initialize(World world);
    
    /**
     * 记录烟花火箭的位置和速度
     * @param entity 烟花火箭实体
     */
    void recordTick(FireworkRocketEntity entity);
    
    /**
     * 结束轨迹记录
     */
    void finish();
}
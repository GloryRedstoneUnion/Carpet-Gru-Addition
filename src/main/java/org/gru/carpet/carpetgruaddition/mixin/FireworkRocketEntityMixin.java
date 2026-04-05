package org.gru.carpet.carpetgruaddition.mixin;

import org.gru.carpet.carpetgruaddition.logging.loggers.FireworkTrajectoryLogger;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FireworkRocketEntity.class)
public abstract class FireworkRocketEntityMixin extends Entity {
    // 烟花火箭轨迹记录器
    private FireworkTrajectoryLogger trajectoryLogger;
    
    public FireworkRocketEntityMixin(EntityType<?> entityType, World world) {
        super(entityType, world);
        // 初始化轨迹记录器
        trajectoryLogger = new FireworkTrajectoryLogger();
    }
    
    @Inject(method = "<init>(Lnet/minecraft/entity/EntityType;Lnet/minecraft/world/World;)V", at = @At("RETURN"))
    private void initializeLogger(EntityType<? extends FireworkRocketEntity> entityType, World world, CallbackInfo ci) {
        // 确保轨迹记录器已初始化
        if (trajectoryLogger == null) {
            trajectoryLogger = new FireworkTrajectoryLogger();
        }
        // 初始化轨迹记录器
        trajectoryLogger.initialize(world);
    }
    
    @Inject(method = "<init>(Lnet/minecraft/world/World;DDDLnet/minecraft/item/ItemStack;)V", at = @At("RETURN"))
    private void initializeLoggerFromStack(World world, double x, double y, double z, ItemStack stack, CallbackInfo ci) {
        // 确保轨迹记录器已初始化
        if (trajectoryLogger == null) {
            trajectoryLogger = new FireworkTrajectoryLogger();
        }
        // 初始化轨迹记录器
        trajectoryLogger.initialize(world);
    }
    
    @Inject(method = "tick", at = @At("HEAD"))
    private void recordTick(CallbackInfo ci) {
        // 确保轨迹记录器已初始化
        if (trajectoryLogger != null) {
            // 记录烟花火箭的位置和速度
            trajectoryLogger.recordTick((FireworkRocketEntity) (Object) this);
        }
    }
    
    @Inject(method = "explodeAndRemove", at = @At("HEAD"))
    private void finishLogging(CallbackInfo ci) {
        // 确保轨迹记录器已初始化
        if (trajectoryLogger != null) {
            // 结束轨迹记录
            trajectoryLogger.finish();
        }
    }
}